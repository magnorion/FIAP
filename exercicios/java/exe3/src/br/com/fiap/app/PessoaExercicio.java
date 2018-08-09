package br.com.fiap.app;

import java.util.ArrayList;

import br.com.fiap.classes.Pessoa;

public class PessoaExercicio {
	public static void main(String[] args) {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(new Pessoa("João Garcia", 20, "M", "AIK Enterprises"));
		pessoas.add(new Pessoa("Maria Martins", 44, "F", "Simples"));
		pessoas.add(new Pessoa("Henrique Fernando", 43, "M", "AIK Enterprises"));
		pessoas.add(new Pessoa("Inácio Luís", 33, "M", "Magazine André"));
		pessoas.add(new Pessoa("Fernando Ferreira", 87, "M", "Casas Recife"));
		
		// Sorteando uma pessoa
		System.out.println(Pessoa.sorteio(pessoas));
		System.out.println("----");
		
		System.out.println("Lista de pessoas oganizadas pelo nome ASC : ");
		for (Pessoa p : Pessoa.organizar(pessoas)) {
			System.out.println(p.getNome());
		}
		
		System.out.println("----");
		System.out.println("Lista de pessoas oganizadas pelo nome DEC: ");
		for (Pessoa p : Pessoa.inverter(pessoas)) {
			System.out.println(p.getNome());
		}
	}
}
