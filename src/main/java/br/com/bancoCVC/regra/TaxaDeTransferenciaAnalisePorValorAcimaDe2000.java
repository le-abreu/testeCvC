package br.com.bancoCVC.regra;

import br.com.bancoCVC.model.Transferencia;
import br.com.bancoCVC.regra.calculo.Calculo;

public class TaxaDeTransferenciaAnalisePorValorAcimaDe2000 extends TaxaDeTransferenciaRegressiva{


	public TaxaDeTransferenciaAnalisePorValorAcimaDe2000(Taxa proximaTaxa, Calculo calculo) {
		super(proximaTaxa, calculo);
	}

	@Override
	public boolean regraDaTransferenciaEstaApta(Transferencia transferencia) {
		return transferencia.getValor() > 2000; 
	}


}
