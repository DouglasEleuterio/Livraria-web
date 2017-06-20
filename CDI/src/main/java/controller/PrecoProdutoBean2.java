package controller;

import javax.inject.Inject;
import javax.inject.Named;

import servico.CalculadoraPreco;

@Named
public class PrecoProdutoBean2 {

	
	private CalculadoraPreco calculadora;

	public double getCalculadoraPreco () {
		return calculadora.calcularPreco(5, 10.5);
	}
	
	@Inject
	public void setCalculadoraPreco(CalculadoraPreco calculadora) {
		this.calculadora = calculadora;
	}



	/**
	 * Exercicio pediu para modificar a classe public double getPreco() { return
	 * 12.55; }
	 */

}
