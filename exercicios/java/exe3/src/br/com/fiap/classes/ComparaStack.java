package br.com.fiap.classes;

import java.time.Instant;
import java.util.Stack;

import br.com.fiap.interfaces.Comparador;

public class ComparaStack extends ComparadorDados implements Comparador {
	private Stack<Integer> array;
	
	public ComparaStack(String nome, Stack<Integer> lista) {
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
		
		int value;
		value = (int) this.array.get(index);
		
		this.fim = Instant.now();
		
		return value;
	}

}
