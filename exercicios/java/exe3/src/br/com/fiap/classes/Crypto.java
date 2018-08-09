package br.com.fiap.classes;

public class Crypto {
	
	public static String codifique(String texto) {
		StringBuilder builder = new StringBuilder().append(texto);
		int counter = 0;
		
		while (counter < builder.length()) {
			int asc = (int) builder.charAt(counter);
			asc++;
			builder.setCharAt(counter, (char) asc);
			counter++;
		}

		return builder.toString();
	}
	
	public static String descodifique(String texto) {
		StringBuilder builder = new StringBuilder().append(texto);
		int counter = 0;
		
		while (counter < builder.length()) {
			int asc = (int) builder.charAt(counter);
			asc--;
			builder.setCharAt(counter, (char) asc);
			counter++;
		}
		
		return builder.toString();
	}
}
