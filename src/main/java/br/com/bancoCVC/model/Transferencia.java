package br.com.bancoCVC.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;

import br.com.bancoCVC.regra.calculo.CalculadoraTaxaCVC;



@Entity
public class Transferencia {

	@Id
	@GeneratedValue
	private Long id;
	// Conta de origem (padrão XXXXXX)
	@ManyToOne
	@NotNull
	private Conta contaOrigem;
	// Conta de destino (padrão XXXXXX)
	@ManyToOne
	@NotNull
	private Conta contaDestino;
	// Valor da transferência
	@NotNull
	@DecimalMin(value="0.01")
	private Double valor;
	// Taxa (a ser calculada)
	@NotNull
	private Double taxa;
	// Data da transferência (data que será realizada a transferência)
	@NotNull
	@Temporal(TemporalType.DATE)
	private Calendar data;
	// Data de agendamento (hoje)
	@NotNull
	@Temporal(TemporalType.DATE)
	private Calendar dataAgendamento = Calendar.getInstance();

	public Transferencia(Conta contaOrigem, Conta contaDestino, Double valor, Calendar data) {
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
		this.data = data;
	}

	public Transferencia() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getTaxa() {
		return taxa;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getDataAgendamento() {
		return dataAgendamento;
	}

	public void gerarTaxa() {
		 this.taxa = new CalculadoraTaxaCVC(this).gerarTaxa();
	}

}
