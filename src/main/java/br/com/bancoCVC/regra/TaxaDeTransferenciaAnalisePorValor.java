package br.com.bancoCVC.regra;

import br.com.bancoCVC.regra.calculo.Calculo;

public abstract class TaxaDeTransferenciaAnalisePorValor extends TaxaAbstrata {

	public TaxaDeTransferenciaAnalisePorValor(Taxa proximaTaxa, Calculo calculo) {
		super(proximaTaxa, calculo);
	}
	
//	D: Operações do tipo D tem a taxa igual a A, B ou C dependendo do valor da
//	transferência.
//	Valores até $1.000 seguem a taxação tipo A
//	Valores de $1.001 até $2.000 seguem a taxação tipo B
//	Valores maiores que $2.000 seguem a taxação tipo C

}
