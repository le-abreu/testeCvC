package br.com.bancoCVC.regra;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import br.com.bancoCVC.regra.calculo.Calculo;

public abstract class TaxaDeTransferenciaRegressiva extends TaxaAbstrata {

	public TaxaDeTransferenciaRegressiva(Taxa proximaTaxa, Calculo calculo) {
		super(proximaTaxa, calculo);
	}

	private static final int MILESEGUNDOS = 60;
	private static final int SEGUNDOS = 60;
	private static final long MINUTOS = 60;

	// C: Operações do tipo C tem uma taxa regressiva conforme a data de
	// transferência:
	// acima de 10 dias da data de agendamento 8.2%
	// acima de 20 dias da data de agendamento 6.9%
	// acima de 30 dias da data de agendamento 4.7%
	// acima de 40 dias da data de agendamento 1.7%


	protected long diferencaDeDias(Calendar pDataTransferencia, Calendar pDataAgendamento) {
		LocalDate dataTransferencia = converterCalendarParaLocalDate(pDataTransferencia);
		LocalDate dataAgendamento = converterCalendarParaLocalDate(pDataAgendamento);
		long diferencaEmDias = ChronoUnit.DAYS.between(dataAgendamento, dataTransferencia);
		return diferencaEmDias;
	}

	private LocalDate converterCalendarParaLocalDate(Calendar pDataTransferencia) {
		Instant instant = pDataTransferencia.getTime().toInstant();
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	}

}
