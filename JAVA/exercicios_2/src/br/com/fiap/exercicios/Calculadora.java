package br.com.fiap.exercicios;

public class Calculadora implements CalculadoraBasica{
	private float result;
	
	@Override
	public float somar(float op1, float op2) {
		this.result = op1 + op2;
		return this.result;
	}

	@Override
	public float subtrair(float op1, float op2) {
		this.result = op1 - op2;
		return this.result;
	}

	@Override
	public float dividir(float op1, float op2) {
		this.result = op1 / op2;
		return this.result;
	}

	@Override
	public float multiplicar(float op1, float op2) {
		this.result = op1 * op2;
		return this.result;
	}
	
}
