package br.com.fiap.viewmodel;

import java.io.Serializable;

public class EscolaCursoViewModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private int qtd;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQtd() {
		return qtd;
	}
	
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
}
