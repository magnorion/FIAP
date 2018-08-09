package br.com.fiap.classes;

import java.time.Instant;
import java.util.WeakHashMap;

import br.com.fiap.interfaces.Comparador;

public class ComparaWeakHashMap extends ComparadorDados implements Comparador {
	private WeakHashMap<Integer, Integer> array;
	
	public ComparaWeakHashMap(String nome, WeakHashMap<Integer, Integer> lista) {
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
