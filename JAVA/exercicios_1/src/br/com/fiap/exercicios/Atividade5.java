package br.com.fiap.exercicios;

import javax.swing.JOptionPane;

public class Atividade5 {
	public static void main(String[] args) {
		String num = JOptionPane.showInputDialog("Digite um numero "
				+ "que deseja calcular o fatorial.");
		int number = Integer.parseInt(num);
		JOptionPane.showMessageDialog(null, "O fatorial de " + number 
				+ " é " + fatorial(number));
	}
	
	public static int fatorial(int numero) {
		int i, result = numero;
		
		for (i = numero; i > 1; i--) {
			result *= i - 1;
		}
		return result;
	}
}
