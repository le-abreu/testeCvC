package br.com.bancoCVC.regra;

import br.com.bancoCVC.model.Transferencia;
import br.com.bancoCVC.regra.calculo.Calculo;

public class TaxaDeTransferenciaAnalisePorValorAte1000 extends TaxaDeTransferenciaRegressiva{


	public TaxaDeTransferenciaAnalisePorValorAte1000(Taxa proximaTaxa, Calculo calculo) {
		super(proximaTaxa, calculo);
	}


	@Override
	public boolean regraDaTransferenciaEstaApta(Transferencia transferencia) {
		return transferencia.getValor() <= 1000; 
	}

}
