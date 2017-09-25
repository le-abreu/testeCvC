package br.com.bancoCVC.regra;

import java.util.Calendar;

import br.com.bancoCVC.model.Transferencia;
import br.com.bancoCVC.regra.calculo.Calculo;

public class TaxaDeTransferenciaAte10Dias extends TaxaDeTransferenciaRegressiva {

	public TaxaDeTransferenciaAte10Dias(Taxa proximaTaxa, Calculo calculo) {
		super(proximaTaxa, calculo);
	}



//	B: Tranferências até 10 dias da data de agendamento possuem uma taxa de $12.
	@Override
	public boolean regraDaTransferenciaEstaApta(Transferencia transferencia) {
		Calendar dataTransferencia = transferencia.getData();
		Calendar dataAgendamento = transferencia.getDataAgendamento();
		long diferencaDeDias = diferencaDeDias(dataTransferencia, dataAgendamento);
		return diferencaDeDias < 11;
	}

	

}
