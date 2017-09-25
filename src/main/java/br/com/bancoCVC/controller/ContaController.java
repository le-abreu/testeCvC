package br.com.bancoCVC.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.bancoCVC.dao.ContaDao;
import br.com.bancoCVC.model.Conta;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ContaController {

	private final Result result;
	private final ContaDao contaDao;
	private final Validator validator;

	@Inject
	public ContaController(Result result, ContaDao dao, Validator validator) {
		this.result = result;
		this.contaDao = dao;
		this.validator = validator;
	}
	
	public ContaController() {
		this(null, null, null);
	}

	@Get
	public void formulario(){

	}	
	
	@Get("/")
	public void init(){

	}

	@Post("/conta")
	public void adiciona(@Valid Conta conta) {
		validator.check(
				(!contaDao.existeContaCadastrada(conta.getAgencia().trim(), conta.getNumero().trim())), 
				new I18nMessage("conta", "conta.jaExiste"));
		validator.onErrorRedirectTo(this).formulario();
		if(conta.getId() != null) {
			contaDao.atualizar(conta);
		}else {
			contaDao.adiciona(conta);
		}
		result.include("mensagem", "Conta adicionado com sucesso");
		result.redirectTo(this).lista();
	}
	
    @Get("/conta")
    @IncludeParameters
    public Conta visualiza(Conta conta) {
        return contaDao.busca(conta);
    }

    
    @Get("/conta/editar")
    @IncludeParameters
    public void editar(Conta conta) {
    	conta = contaDao.busca(conta);
      	result.include("conta", conta);
    	result.redirectTo(this).formulario();
  
    }

    
    @Delete("/conta")
    @IncludeParameters
    public void remove(Conta conta){
	try{
	   contaDao.remove(conta);
    	   result.include("mensagem", "Conta removido com sucesso");
	}catch(Exception e){
    	   result.include("mensagem", "Error ao remover Conta: " + e);
	}
	result.redirectTo(this).lista();

    }
	
	@Get
	public List<Conta> lista() {
		List<Conta> list = contaDao.lista();
		return list;
	}
	
	@Get
	public void listaXML() {
		List<Conta> lista = contaDao.lista();
		result.use(Results.xml()).from(lista).serialize();;
	}
	
	@Get
	public void listaJson() {
		List<Conta> lista = contaDao.lista();
		result.use(Results.json()).from(lista).serialize();;
	}
	
}
