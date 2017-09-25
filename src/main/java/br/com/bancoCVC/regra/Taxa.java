package br.com.bancoCVC.regra;

import br.com.bancoCVC.model.Transferencia;

public interface Taxa {

	double calcula(Transferencia transferencia);
}
