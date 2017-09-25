package br.com.bancoCVC.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.bancoCVC.dao.ContaDao;
import br.com.bancoCVC.dao.TransferenciaDao;
import br.com.bancoCVC.model.Conta;
import br.com.bancoCVC.model.Transferencia;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class TransferenciaController {

	private final Result result;
	private final ContaDao contaDao;
	private final TransferenciaDao transferenciaDao;
	private final Validator validator;

	@Inject
	public TransferenciaController(Result result, ContaDao dao, TransferenciaDao transferenciaDao, Validator validator) {
		this.result = result;
		this.contaDao = dao;
		this.transferenciaDao = transferenciaDao;
		this.validator = validator;
	}
	
	public TransferenciaController() {
		this(null, null, null, null);
	}

	@Get
	public void formulario(){

	}

	@Post("/transferencia")
	public void adiciona(Transferencia transferencia) {
		Conta contaOrigem = transferencia.getContaOrigem();
		transferencia.setContaOrigem(buscarConta(contaOrigem.getAgencia(), contaOrigem.getNumero()));
		

		Conta contaDestino = transferencia.getContaDestino();
		transferencia.setContaDestino(buscarConta(contaDestino.getAgencia(), contaDestino.getNumero()));
		transferencia.gerarTaxa();
	
		validator.check(
				(transferencia.getContaDestino() != null ), 
				new I18nMessage("contaDestino", "contaDestino.invalida"));
		validator.check(
				(transferencia.getContaOrigem() != null), 
				new I18nMessage("contaOrigem", "contaOrigem.invalida"));
		
		validator.onErrorUsePageOf(this).formulario();
		
		transferenciaDao.adiciona(transferencia);
		result.include("mensagem", "Transferencia adicionado com sucesso");
		result.redirectTo(this).lista();
	}

	private Conta buscarConta(String agencia, String numero) {
		return contaDao.pesquisa(agencia.trim(), numero.trim());
	}
	
    @Delete("/transferencia")
    @IncludeParameters
    public void remove(Transferencia transferencia){
    	transferenciaDao.remove(transferencia);
    	result.include("mensagem", "transferencia removido com sucesso");
    	result.redirectTo(this).lista();
    }
	
	@Get
	public List<Transferencia> lista() {
		List<Transferencia> list = transferenciaDao.lista();
		return list;
	}
	
	@Get
	public void listaXML() {
		List<Transferencia> lista = transferenciaDao.lista();
		result.use(Results.xml()).from(lista).serialize();;
	}
	
	@Get
	public void listaJson() {
		List<Transferencia> lista = transferenciaDao.lista();
		result.use(Results.json()).from(lista).serialize();;
	}
	
}
