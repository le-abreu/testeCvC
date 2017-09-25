package br.com.bancoCVC.regra;

import java.util.Calendar;

import br.com.bancoCVC.model.Transferencia;
import br.com.bancoCVC.regra.calculo.Calculo;

public class TaxaDeTransferenciaNoMesmoDia extends TaxaAbstrata {


	public TaxaDeTransferenciaNoMesmoDia(Taxa proximaTaxa, Calculo calculo) {
		super(proximaTaxa, calculo);
	}


	// A: Tranferências no mesmo dia do agendamento tem uma taxa de $3 mais 3% do
	// valor a ser transferido;
	@Override
	public boolean regraDaTransferenciaEstaApta(Transferencia transferencia) {
		Calendar dataTransferencia = transferencia.getData();
		Calendar dataAgendamento = transferencia.getDataAgendamento();
		return transferenciaOcorreuNaMesmaDataDeAgendamentoEDataTransferencia(dataTransferencia, dataAgendamento);
	}

	
	private boolean transferenciaOcorreuNaMesmaDataDeAgendamentoEDataTransferencia(Calendar dataTransferencia,
			Calendar dataAgendamento) {
		int anoData = dataTransferencia.get(Calendar.YEAR);
		int anoDataAgendamento = dataAgendamento.get(Calendar.YEAR);
		if(anoData != anoDataAgendamento) return false;
		
		int mesData = dataTransferencia.get(Calendar.MONTH);
		int mesDataAgendamento = dataAgendamento.get(Calendar.MONTH);
		if(mesData != mesDataAgendamento) return false;

		int diaDoMesData = dataTransferencia.get(Calendar.DAY_OF_MONTH);
		int diaDoMesDataAgendamento = dataAgendamento.get(Calendar.DAY_OF_MONTH);
		if(diaDoMesData != diaDoMesDataAgendamento) return false;

		return true;
	}

}
