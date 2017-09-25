package br.com.bancoCVC.regra;

import java.util.Calendar;

import br.com.bancoCVC.model.Transferencia;
import br.com.bancoCVC.regra.calculo.Calculo;

public class TaxaDeTransferenciaRegressivaAcima20 extends TaxaDeTransferenciaRegressiva{

	public TaxaDeTransferenciaRegressivaAcima20(Taxa proximaTaxa, Calculo calculo) {
		super(proximaTaxa, calculo);
	}



	@Override
	public boolean regraDaTransferenciaEstaApta(Transferencia transferencia) {
		Calendar dataTransferencia = transferencia.getData();
		Calendar dataAgendamento = transferencia.getDataAgendamento();
		return transferenciaOcorreuAcimaDe20DiasDaDataDeAgendamentoParaDataTransferencia(dataTransferencia, dataAgendamento);
	}
	
	

	private boolean transferenciaOcorreuAcimaDe20DiasDaDataDeAgendamentoParaDataTransferencia(
			Calendar dataTransferencia, Calendar dataAgendamento) {
		long dias = diferencaDeDias(dataTransferencia, dataAgendamento);
		return dias > 20;
	}


}
