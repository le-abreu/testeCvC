package br.com.bancoCVC.regra.calculo;

import java.util.Calendar;

import br.com.bancoCVC.model.Conta;
import br.com.bancoCVC.model.Transferencia;
import br.com.bancoCVC.regra.Taxa;
import br.com.bancoCVC.regra.TaxaDeTransferenciaAnalisePorValorAcimaDe1001Ate2000;
import br.com.bancoCVC.regra.TaxaDeTransferenciaAnalisePorValorAte1000;
import br.com.bancoCVC.regra.TaxaDeTransferenciaAte10Dias;
import br.com.bancoCVC.regra.TaxaDeTransferenciaNoMesmoDia;
import br.com.bancoCVC.regra.TaxaDeTransferenciaRegressivaAcima10;
import br.com.bancoCVC.regra.TaxaDeTransferenciaRegressivaAcima20;
import br.com.bancoCVC.regra.TaxaDeTransferenciaRegressivaAcima30;
import br.com.bancoCVC.regra.TaxaDeTransferenciaRegressivaAcima40;

public class CalculadoraTaxaCVC{

	private Transferencia transferencia;

	public CalculadoraTaxaCVC(Transferencia transferencia) {
		this.transferencia = transferencia;
	}
	
	Taxa taxa;
	
	{

		Taxa taxaC_D = new TaxaDeTransferenciaRegressivaAcima10(null, new Calculo8_2());
		Taxa taxaC_C = new TaxaDeTransferenciaRegressivaAcima20(taxaC_D, new Calculo6_9());
		Taxa taxaC_B = new TaxaDeTransferenciaRegressivaAcima30(taxaC_C, new Calculo4_7());
		Taxa taxaC_A = new TaxaDeTransferenciaRegressivaAcima40(taxaC_B, new Calculo1_7());
//		Taxa taxaD_C = new TaxaDeTransferenciaAnalisePorValorAcimaDe2000(taxaC_A, new Calculo12());
		Taxa taxaD_B = new TaxaDeTransferenciaAnalisePorValorAcimaDe1001Ate2000(taxaC_A, new Calculo12());
		Taxa taxaD_A = new TaxaDeTransferenciaAnalisePorValorAte1000(taxaD_B, new Calculo3Mais3Porcento());
		Taxa taxaB = new TaxaDeTransferenciaAte10Dias(taxaD_A, new Calculo12());
		taxa = new TaxaDeTransferenciaNoMesmoDia(taxaB, new Calculo3Mais3Porcento());
	}
	
	public double gerarTaxa() {
		return taxa.calcula(transferencia);
	}
	
}
