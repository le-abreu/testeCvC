package br.com.bancoCVC.regra;

import br.com.bancoCVC.model.Transferencia;
import br.com.bancoCVC.regra.calculo.Calculo;

public abstract class TaxaAbstrata implements Taxa {

	private Taxa proximaTaxa;
	private Calculo calculo;

	public TaxaAbstrata(Taxa proximaTaxa, Calculo calculo) {
		this.proximaTaxa = proximaTaxa;
		this.calculo = calculo;
	}

	public abstract boolean regraDaTransferenciaEstaApta(Transferencia transferencia);

	@Override
	public final double calcula(Transferencia transferencia) {
		if (this.regraDaTransferenciaEstaApta(transferencia)) {
			return this.calculo.calcular(transferencia.getValor());
		} 
		
		if(proximaTaxa == null){
			throw new IllegalAccessError("Regra de taxação está com problema, não existe nenhuma regra para o cenário do calculo da transferencia pasada");
		}
		return proximaTaxa.calcula(transferencia);

	}

}
