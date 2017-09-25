package br.com.bancoCVC.regra;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.bancoCVC.model.Conta;
import br.com.bancoCVC.model.Transferencia;

public class TesteTaxaDeTransferenciaAnalisePorValorAcimaDe1001Ate2000 {


	@Test
	public void validaRegraDaTaxaValorDentroDe1001A2000() {
		Conta contaLe = new Conta("0001", "22222-6", "Leandro");
		Conta contaIsa = new Conta("0001", "33333-6", "Isabella");
		Transferencia transferencia = new Transferencia(contaIsa, contaLe, 1001D, Calendar.getInstance());
		TaxaDeTransferenciaAnalisePorValorAcimaDe1001Ate2000 taxa = new TaxaDeTransferenciaAnalisePorValorAcimaDe1001Ate2000(null, null);
		Assert.assertTrue(taxa.regraDaTransferenciaEstaApta(transferencia));
	}

	@Test
	public void validaRegraDaTaxaValorNaoEstaDentroDe1001A2000() {
		Conta contaLe = new Conta("0001", "22222-6", "Leandro");
		Conta contaIsa = new Conta("0001", "33333-6", "Isabella");
		Transferencia transferencia = new Transferencia(contaIsa, contaLe, 3001D, Calendar.getInstance());
		TaxaDeTransferenciaAnalisePorValorAcimaDe1001Ate2000 taxa = new TaxaDeTransferenciaAnalisePorValorAcimaDe1001Ate2000(null, null);
		Assert.assertFalse(taxa.regraDaTransferenciaEstaApta(transferencia));
	}
	
	
	
}
