package br.com.fiap.classes;

import java.util.ArrayList;
import java.util.Collections;

public class Pessoa {
	private String nome;
	private int idade;
	private String sexo;
	private String empresa;
	
	public Pessoa(String nome, int idade, String sexo, String empresa) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public static String sorteio(ArrayList<Pessoa> pessoas) {
		Collections.shuffle(pessoas);
		return "A pessoa sorteada foi: " + pessoas.get(0).getNome();
	}
	
	public static ArrayList<Pessoa> organizar(ArrayList<Pessoa> pessoas) {
		Collections.sort(pessoas, (lista1, lista2) -> lista1.getNome().compareTo(lista2.getNome()));
		return pessoas;
	}
	
	public static ArrayList<Pessoa> inverter(ArrayList<Pessoa> pessoas) {
		Collections.sort(pessoas, (lista1, lista2) -> lista2.getNome().compareTo(lista1.getNome()));
		return pessoas;
	}
}
