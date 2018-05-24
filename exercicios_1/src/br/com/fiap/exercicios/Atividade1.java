package br.com.fiap.exercicios;

public class Atividade1 {

	public static void main(String[] args) {
		int array[] = { 1, 2, 3 };
		int i;

		array = invertArray(array);
		for (i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static int[] invertArray(int[] array) {
		int[] revert = new int[array.length];
		int i, key = 0, counter = (array.length - 1);

		for (i = counter; i >= 0; i--) {
			revert[key] = array[i];
			key++;
		}

		return revert;
	}
}
