package br.com.bancoCVC.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.bancoCVC.model.Conta;

@RequestScoped
public class ContaDao {

	private final EntityManager em;

	@Inject
	public ContaDao(EntityManager em) {
		this.em = em;
	}

	public ContaDao() {
		this(null);
	}

	public void adiciona(Conta conta) {
		em.persist(conta);
	}

	public void remove(Conta conta) {
		em.remove(busca(conta));
	}

	public Conta busca(Conta conta) {
		return em.find(Conta.class, conta.getId());
	}

	public boolean existeContaCadastrada(String agencia, String numero) {
		try {
			Conta conta = this.pesquisa(agencia, numero);
			return conta != null;
		} catch (NoResultException e) {
		}
		return false;
	}

	public Conta pesquisa(String agencia, String numero) {
		try {
			String jpql = "select c from Conta c where c.agencia = :agencia and c.numero= :numero";
			TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);
			query.setParameter("agencia", agencia);
			query.setParameter("numero", numero);
			Conta Conta = query.getSingleResult();
			return Conta;
		} catch (NoResultException e) {
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Conta> lista() {
		return em.createQuery("select p from Conta p").getResultList();
	}

	public void atualizar(Conta conta) {
		em.merge(conta);
	}
}