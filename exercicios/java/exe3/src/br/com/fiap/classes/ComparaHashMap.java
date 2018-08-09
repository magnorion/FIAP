package br.com.fiap.classes;

import java.time.Instant;
import java.util.HashMap;

import br.com.fiap.interfaces.Comparador;

public class ComparaHashMap extends ComparadorDados implements Comparador {
	private HashMap<Integer, Integer> array;
	
	public ComparaHashMap(String nome, HashMap<Integer, Integer> lista) {
		this.nome = nome;
		this.array = lista;
	}
	
	@Override
	public void insert() {
		this.inicio = Instant.now();
		for (int i = 0; i <= 1000000; i++) {
			this.array.put(i, i);
		}
		this.fim = Instant.now();	
	}

	@Override
	public int select(int index) {
		this.inicio = Instant.now();
		
		int value;
		if (this.array.containsKey(index)) {
			value = this.array.get(index);
		} else {
			value = 0;
		}
		
		this.fim = Instant.now();
		
		return value;
	}

}
