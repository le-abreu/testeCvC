package br.com.bancoCVC.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.bancoCVC.model.Transferencia;

@RequestScoped
public class TransferenciaDao {

	private final EntityManager em;


	@Inject 
	public TransferenciaDao(EntityManager em) {
		this.em = em;
	}
	
	public TransferenciaDao() {
		this(null);
	}
	
	public void adiciona(Transferencia transferencia) {
		em.persist(transferencia);
	}

	public void remove(Transferencia transferencia) {
		em.remove(busca(transferencia));
	}

	public Transferencia busca(Transferencia transferencia) {
		return em.find(Transferencia.class, transferencia.getId());
	}

	@SuppressWarnings("unchecked")
	public List<Transferencia> lista() {
		return em.createQuery("select p from Transferencia p").getResultList();
	}
	
	
	
}