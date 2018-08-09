package br.com.fiap.classes;

import java.time.Instant;
import java.util.HashSet;

import br.com.fiap.interfaces.Comparador;

public class ComparaHash extends ComparadorDados implements Comparador {
	private HashSet<Integer> array;
	
	public ComparaHash(String nome, HashSet<Integer> lista) {
		this.nome = nome;
		this.array = lista;
	}
	
	@Override
	public void insert() {
		this.inicio = Instant.now();
		for (int i = 0; i <= 1000000; i++) {
			this.array.add(i);
		}
		this.fim = Instant.now();
	}

	@Override
	public int select(int index) {
		this.inicio = Instant.now();
		
		for (int number : this.array) {
			if (number == index) {
				return number;
			}
		}
		
		this.fim = Instant.now();
		
		return 0;
	}
	
}
