package controller;

import javax.inject.Inject;
import javax.inject.Named;

import servico.CalculadoraPreco;

@Named
public class PrecoProdutoBean {

	@Inject
	private CalculadoraPreco calculadora;

	public double getPreco() {
		return calculadora.calcularPreco(12, 44.57);
	}

	/**
	 * Exercicio pediu para modificar a classe public double getPreco() { return
	 * 12.55; }
	 */

}
