package br.com.bancoCVC.regra;

import java.util.Calendar;

import br.com.bancoCVC.model.Transferencia;
import br.com.bancoCVC.regra.calculo.Calculo;

public class TaxaDeTransferenciaRegressivaAcima10 extends TaxaDeTransferenciaRegressiva{

	public TaxaDeTransferenciaRegressivaAcima10(Taxa proximaTaxa, Calculo calculo) {
		super(proximaTaxa, calculo);
	}



	@Override
	public boolean regraDaTransferenciaEstaApta(Transferencia transferencia) {
		Calendar dataTransferencia = transferencia.getData();
		Calendar dataAgendamento = transferencia.getDataAgendamento();
		return transferenciaOcorreuAcimaDe10DiasDaDataDeAgendamentoParaDataTransferencia(dataTransferencia, dataAgendamento);
	}
	
	

	private boolean transferenciaOcorreuAcimaDe10DiasDaDataDeAgendamentoParaDataTransferencia(
			Calendar dataTransferencia, Calendar dataAgendamento) {
		long dias = diferencaDeDias(dataTransferencia, dataAgendamento);
		return dias > 10;
	}

}
