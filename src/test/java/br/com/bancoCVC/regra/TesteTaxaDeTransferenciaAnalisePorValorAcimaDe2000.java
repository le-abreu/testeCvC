package br.com.bancoCVC.regra;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.bancoCVC.model.Conta;
import br.com.bancoCVC.model.Transferencia;

public class TesteTaxaDeTransferenciaAnalisePorValorAcimaDe2000 {


	@Test
	public void validaRegraDaTaxaValorEstaAcima2000() {
		Conta contaLe = new Conta("0001", "22222-6", "Leandro");
		Conta contaIsa = new Conta("0001", "33333-6", "Isabella");
		Transferencia transferencia = new Transferencia(contaIsa, contaLe, 2001D, Calendar.getInstance());
		TaxaDeTransferenciaAnalisePorValorAcimaDe2000 taxa = new TaxaDeTransferenciaAnalisePorValorAcimaDe2000(null, null);
		Assert.assertTrue(taxa.regraDaTransferenciaEstaApta(transferencia));
	}

	@Test
	public void validaRegraDaTaxaNaoEstaValorAcima2000() {
		Conta contaLe = new Conta("0001", "22222-6", "Leandro");
		Conta contaIsa = new Conta("0001", "33333-6", "Isabella");
		Transferencia transferencia = new Transferencia(contaIsa, contaLe, 1999D, Calendar.getInstance());
		TaxaDeTransferenciaAnalisePorValorAcimaDe2000 taxa = new TaxaDeTransferenciaAnalisePorValorAcimaDe2000(null, null);
		Assert.assertFalse(taxa.regraDaTransferenciaEstaApta(transferencia));
	}
	
	
	
}
