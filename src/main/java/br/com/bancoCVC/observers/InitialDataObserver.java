package br.com.bancoCVC.observers;

import java.util.Calendar;

import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;

import br.com.bancoCVC.model.Conta;
import br.com.bancoCVC.model.Transferencia;
import br.com.bancoCVC.util.JPAUtil;
import br.com.caelum.vraptor.events.VRaptorInitialized;

public class InitialDataObserver {

	public void insert(@Observes VRaptorInitialized event) {
		
		EntityManager em = JPAUtil.criaEntityManager();
		em.getTransaction().begin();

		em.persist(new Conta("0001", "11111-6", "Mariana"));
		em.persist(new Conta("0001", "44444-6", "Gabriel"));
		Conta contaLe = new Conta("0001", "22222-6", "Leandro");
		Conta contaIsa = new Conta("0001", "33333-6", "Isabella");
		em.persist(contaLe);
		em.persist(contaIsa);
		Transferencia transferencia = new Transferencia(contaIsa, contaLe, 100D, Calendar.getInstance());
		transferencia.gerarTaxa();
		em.persist(transferencia);
		
		em.getTransaction().commit();
		em.close();
	}	
}