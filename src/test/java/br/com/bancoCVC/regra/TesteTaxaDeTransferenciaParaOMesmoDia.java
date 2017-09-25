package br.com.bancoCVC.regra;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.bancoCVC.model.Conta;
import br.com.bancoCVC.model.Transferencia;

public class TesteTaxaDeTransferenciaParaOMesmoDia {


	@Test
	public void validaRegraDaTaxaEstaComoMesmoDiaDaDataDeAgendamentoParaDataTransferencia() {
		Conta contaLe = new Conta("0001", "22222-6", "Leandro");
		Conta contaIsa = new Conta("0001", "33333-6", "Isabella");

		Transferencia transferencia = new Transferencia(contaIsa, contaLe, 999D, Calendar.getInstance());
		TaxaDeTransferenciaNoMesmoDia taxa = new TaxaDeTransferenciaNoMesmoDia(null, null);
		Assert.assertTrue(taxa.regraDaTransferenciaEstaApta(transferencia));
	}

	@Test
	public void validaRegraDaTaxaEstaComoDiaDaDataDeAgendamentoParaDataTransferenciaDiferentes() {
		Conta contaLe = new Conta("0001", "22222-6", "Leandro");
		Conta contaIsa = new Conta("0001", "33333-6", "Isabella");

		Calendar data = Calendar.getInstance();
		data.set(Calendar.YEAR, 2017); 
		data.set(Calendar.MONTH, Calendar.OCTOBER); 
		data.set(Calendar.DAY_OF_MONTH, 25);
		
		Transferencia transferencia = new Transferencia(contaIsa, contaLe, 999D, data);
		TaxaDeTransferenciaNoMesmoDia taxa = new TaxaDeTransferenciaNoMesmoDia(null, null);
		Assert.assertFalse(taxa.regraDaTransferenciaEstaApta(transferencia));
	}
	
	
	
}
