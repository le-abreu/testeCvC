package br.com.bancoCVC.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Conta {

	@Id
	@GeneratedValue
	private Long id;

	private Double saldo = 0D;
	@NotEmpty
	@Pattern(regexp = "\\d{4}", message="Deve corresponder a 4 digitos")
	private String agencia;
	@NotEmpty
	@Pattern(regexp = "\\d{5}-\\d{1}", message="Deve corresponder a 12345-5")
	private String numero;
	@NotEmpty
	private String nome;

	public Conta() {
	}

	public Conta(String agencia, String numero, String nome) {
		this.agencia = agencia;
		this.numero = numero;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAgencia() {
		return this.agencia;
	}

	public String getNumero() {
		return this.numero;
	}
	
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void deposita(Double valor) {
		if(valor < 0.01) {
			throw new IllegalArgumentException("Valor não pode ser negativo ou zero, favor verificar o valor");
		}
	}
	
	public void saca(Double valor) {
		if(valor < 0.01) {
			throw new IllegalArgumentException("Valor não pode ser negativo ou zero, favor verificar o valor");
		}
		
		if(valor > this.saldo) {
			throw new IllegalArgumentException("Valor excede o saldo");
		}
	}
	
	
	public void transferir(Conta conta, Double valor) {
		this.saca(valor);
		try{
			conta.deposita(valor);
		}catch(Exception e){
			
		}
	}
	
	public Double getSaldo() {
		return new Double(this.saldo);
	}

}