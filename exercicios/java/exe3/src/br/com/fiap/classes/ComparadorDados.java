package br.com.fiap.classes;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class ComparadorDados {
	protected String nome;
	protected Instant inicio;
	protected Instant fim;
	
	public Long gap() {
		return ChronoUnit.MILLIS.between(this.inicio, this.fim);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public static String compara(ComparadorDados com1, ComparadorDados com2) {
		if (com1.gap() < com2.gap()) {
			return com1.getNome() + " é mais rapido!";
		}
		
		return com2.getNome() + " é mais rapido!";
	}
}
