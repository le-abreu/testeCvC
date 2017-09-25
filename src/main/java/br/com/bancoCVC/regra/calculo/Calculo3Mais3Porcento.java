package br.com.bancoCVC.regra.calculo;

public class Calculo3Mais3Porcento implements Calculo {

	@Override
	public double calcular(Double valor) {
		return 3 + (valor * 0.03);
	}

}
