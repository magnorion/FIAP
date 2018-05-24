package br.com.fiap.exercicios;

import javax.swing.JOptionPane;

public class Atividade3 {
	public static void main(String[] args) {
		String funcionarios = JOptionPane.showInputDialog("Quantos funcion�rios?");
		double media = salarios(Integer.parseInt(funcionarios));
		JOptionPane.showMessageDialog(null, "A m�dia salarial � " + media);
	}
	
	public static double salarios(int funcionarios) {
		int i;
		double salarios = 0;
		for (i = 0; i < funcionarios; i++) {
			int num = i + 1;
			String salario = JOptionPane.showInputDialog("Qual o sal�rio do " 
					+ ( num ) + "� funcion�rio?");
			salarios += Double.parseDouble(salario);
		}
		
		return salarios / funcionarios;
	}
}
