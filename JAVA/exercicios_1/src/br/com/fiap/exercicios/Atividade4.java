package br.com.fiap.exercicios;

public class Atividade4 {
	
	public static void main(String[] args) {
		// Inteiro
		int[] numInt = {10, 20, 30, 40, 50};
		System.out.println(calculadora("soma", numInt));
		
		// Inteiro
		double[] numDouble = {10.5, 20.3, 30.4, 40.7, 50.6};
		System.out.println(calculadora("soma", numDouble));
	}
	
	public static int calculadora(String operador, int...num) {
		switch (operador) {
			case "soma":
				return soma(num);
			case "subtracao":
				return subtracao(num);
			case "multiplicacao":
				return multiplicacao(num);
			case "divisao":
				return (int) divisao(num);
			default:
				System.out.println("Por favor, informe um operador");
				return 0;
		}
	}
	
	public static double calculadora(String operador, double...num) {
		switch (operador) {
		case "soma":
			return soma(num);
		case "subtracao":
			return subtracao(num);
		case "multiplicacao":
			return multiplicacao(num);
		case "divisao":
			return (double) divisao(num);
		default:
			System.out.println("Por favor, informe um operador");
			return 0;
		}
	}
	
	/**
	 * Soma
	 */
	public static int soma(int... num) {
		int i; 
		int resultado = 0;
		for (i = 0; i < num.length; i++) {
			resultado += num[i];
		}
		
		return resultado;
	}
	
	public static double soma(double... num) {
		int i; 
		double resultado = 0;
		for (i = 0; i < num.length; i++) {
			resultado += num[i];
		}
		
		return resultado;
	}
	
	/**
	 * Subtração
	 */
	
	public static int subtracao(int... num) {
		int i; 
		int resultado = 0;
		for (i = 0; i < num.length; i++) {
			resultado = num[i] - resultado;
		}
		
		return resultado;
	}
	
	public static double subtracao(double... num) {
		int i; 
		double resultado = 0;
		for (i = 0; i < num.length; i++) {
			resultado = num[i] - resultado;
		}
		
		return resultado;
	}
	
	/**
	 * Multiplição
	 */
	
	public static int multiplicacao(int... num) {
		int i; 
		int resultado = 1;
		for (i = 0; i < num.length; i++) {
			resultado *= num[i];
		}
		
		return resultado;
	}
	
	public static double multiplicacao(double... num) {
		int i; 
		double resultado = 1;
		for (i = 0; i < num.length; i++) {
			resultado *= num[i];
		}
		
		return resultado;
	}
	
	/**
	 * Divisão
	 */
	
	public static double divisao(int... num) {
		int i;
		double resultado = 1;
		for (i = 0; i < num.length; i++) {
			resultado = num[i] / resultado;
		}
		
		return resultado;
	}
	
	public static double divisao(double... num) {
		int i;
		double resultado = 1;
		for (i = 0; i < num.length; i++) {
			resultado = num[i] / resultado;
		}
		
		return resultado;
	}
}
