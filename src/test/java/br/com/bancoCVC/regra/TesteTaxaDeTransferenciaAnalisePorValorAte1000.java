package br.com.bancoCVC.regra;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.bancoCVC.model.Conta;
import br.com.bancoCVC.model.Transferencia;

public class TesteTaxaDeTransferenciaAnalisePorValorAte1000 {


	@Test
	public void validaRegraDaTaxaValorEstaAte1000() {
		Conta contaLe = new Conta("0001", "22222-6", "Leandro");
		Conta contaIsa = new Conta("0001", "33333-6", "Isabella");
		Transferencia transferencia = new Transferencia(contaIsa, contaLe, 999D, Calendar.getInstance());
		TaxaDeTransferenciaAnalisePorValorAte1000 taxa = new TaxaDeTransferenciaAnalisePorValorAte1000(null, null);
		Assert.assertTrue(taxa.regraDaTransferenciaEstaApta(transferencia));
	}

	@Test
	public void validaRegraDaTaxaValorEstouraOs1000() {
		Conta contaLe = new Conta("0001", "22222-6", "Leandro");
		Conta contaIsa = new Conta("0001", "33333-6", "Isabella");
		Transferencia transferencia = new Transferencia(contaIsa, contaLe, 1001D, Calendar.getInstance());
		TaxaDeTransferenciaAnalisePorValorAte1000 taxa = new TaxaDeTransferenciaAnalisePorValorAte1000(null, null);
		Assert.assertFalse(taxa.regraDaTransferenciaEstaApta(transferencia));
	}
	
	
	
}
