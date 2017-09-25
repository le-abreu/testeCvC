package br.com.bancoCVC.regra;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.bancoCVC.model.Conta;
import br.com.bancoCVC.model.Transferencia;

public class TesteTaxaDeTransferenciaAcimaDe10Dias {


	@Test
	public void validaRegraDaTaxaEstaAcimaDe10Dias() {
		Conta contaLe = new Conta("0001", "22222-6", "Leandro");
		Conta contaIsa = new Conta("0001", "33333-6", "Isabella");

		Calendar data = Calendar.getInstance();
		data.add(Calendar.DAY_OF_MONTH, 11);
		
		Transferencia transferencia = new Transferencia(contaIsa, contaLe, 999D, data);
		TaxaDeTransferenciaRegressivaAcima10 taxa = new TaxaDeTransferenciaRegressivaAcima10(null, null);
		Assert.assertTrue(taxa.regraDaTransferenciaEstaApta(transferencia));
	}

	@Test
	public void validaRegraDaTaxaNaoEstaAcimaDe10Dias() {
		Conta contaLe = new Conta("0001", "22222-6", "Leandro");
		Conta contaIsa = new Conta("0001", "33333-6", "Isabella");

		Calendar data = Calendar.getInstance();
		data.add(Calendar.DAY_OF_MONTH, 9);
		
		Transferencia transferencia = new Transferencia(contaIsa, contaLe, 999D, data);
		TaxaDeTransferenciaRegressivaAcima10 taxa = new TaxaDeTransferenciaRegressivaAcima10(null, null);
		Assert.assertFalse(taxa.regraDaTransferenciaEstaApta(transferencia));
	}
	
	
	
	
}
