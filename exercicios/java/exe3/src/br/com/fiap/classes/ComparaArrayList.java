package br.com.fiap.classes;

import java.time.Instant;
import java.util.ArrayList;

import br.com.fiap.interfaces.Comparador;

public class ComparaArrayList extends ComparadorDados implements Comparador {
	private ArrayList<Integer> array;
	
	public ComparaArrayList(String nome, ArrayList<Integer> lista) {
		this.nome = nome;
		this.array = lista;
	}
	
	public void insert() {
		this.inicio = Instant.now();
		for (int i = 0; i <= 1000000; i++) {
			this.array.add(i);
		}
		this.fim = Instant.now();
	}
	
	public int select(int index) {
		this.inicio = Instant.now();
		
		int value;
		value = (int) this.array.get(index);
		
		this.fim = Instant.now();
		
		return value;
	}
}
