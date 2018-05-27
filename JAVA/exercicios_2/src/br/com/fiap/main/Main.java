package br.com.fiap.main;

import javax.swing.JOptionPane;

import br.com.fiap.exercicios.Calculadora;

public class Main {
	public static void main(String[] args) throws NumberFormatException, Exception {
		String num1, num2;
		Calculadora calc = new Calculadora();
		
		// soma
		try {
			num1 = JOptionPane.showInputDialog("Digite o valor do primeiro numero!");
			num2 = JOptionPane.showInputDialog("Digite o valor do segundo numero!");
			
			if (num1.equals("0")) {
				throw new Exception("O primeiro numero não pode ser 0");
			} else if (num1.matches("[A-Z]|[a-z]") || num2.matches("[A-Z]|[a-z]")) {
				throw new Exception("Por favor, informar apenas numeros!");
			}
			
			System.out.println(calc.somar(Float.parseFloat(num1), Float.parseFloat(num2)));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		}
		
		// subtrair
		try {
			num1 = JOptionPane.showInputDialog("Digite o valor do primeiro numero!");
			num2 = JOptionPane.showInputDialog("Digite o valor do segundo numero!");
			
			if (num1.equals("0")) {
				throw new Exception("O primeiro numero não pode ser 0");
			} else if (num1.matches("[A-Z]|[a-z]") || num2.matches("[A-Z]|[a-z]")) {
				throw new Exception("Por favor, informar apenas numeros!");
			}
			
			System.out.println(calc.subtrair(Float.parseFloat(num1), Float.parseFloat(num2)));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		}
		
		// dividir
		try {
			num1 = JOptionPane.showInputDialog("Digite o valor do primeiro numero!");
			num2 = JOptionPane.showInputDialog("Digite o valor do segundo numero!");
			
			if (num1.equals("0")) {
				throw new Exception("O primeiro numero não pode ser 0");
			} else if (num1.matches("[A-Z]|[a-z]") || num2.matches("[A-Z]|[a-z]")) {
				throw new Exception("Por favor, informar apenas numeros!");
			}
			
			System.out.println(calc.dividir(Float.parseFloat(num1), Float.parseFloat(num2)));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		}
		
		// multiplicar
		try {
			num1 = JOptionPane.showInputDialog("Digite o valor do primeiro numero!");
			num2 = JOptionPane.showInputDialog("Digite o valor do segundo numero!");
			
			if (num1.equals("0")) {
				throw new Exception("O primeiro numero não pode ser 0");
			} else if (num1.matches("[A-Z]|[a-z]") || num2.matches("[A-Z]|[a-z]")) {
				throw new Exception("Por favor, informar apenas numeros!");
			}
			
			System.out.println(calc.multiplicar(Float.parseFloat(num1), Float.parseFloat(num2)));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		}
		
		
		// somar
		num1 = JOptionPane.showInputDialog("Digite o valor do primeiro numero!");
		num2 = JOptionPane.showInputDialog("Digite o valor do segundo numero!");
		System.out.println(calc.somar(Float.parseFloat(num1), Float.parseFloat(num2)));
		
		// subtrair
		num1 = JOptionPane.showInputDialog("Digite o valor do primeiro numero!");
		num2 = JOptionPane.showInputDialog("Digite o valor do segundo numero!");
		System.out.println(calc.subtrair(Float.parseFloat(num1), Float.parseFloat(num2)));
		
		// dividir
		num1 = JOptionPane.showInputDialog("Digite o valor do primeiro numero!");
		num2 = JOptionPane.showInputDialog("Digite o valor do segundo numero!");
		System.out.println(calc.dividir(Float.parseFloat(num1), Float.parseFloat(num2)));
		
		// multiplicar
		num1 = JOptionPane.showInputDialog("Digite o valor do primeiro numero!");
		num2 = JOptionPane.showInputDialog("Digite o valor do segundo numero!");
		System.out.println(calc.multiplicar(Float.parseFloat(num1), Float.parseFloat(num2)));
	}
}
