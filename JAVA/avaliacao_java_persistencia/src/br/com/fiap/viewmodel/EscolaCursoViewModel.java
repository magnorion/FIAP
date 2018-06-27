package br.com.fiap.viewmodel;

import java.io.Serializable;

public class EscolaCursoViewModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cursoNome;
	private int qtd;
	private int cursoId;
	
	public int getCursoId() {
		return cursoId;
	}

	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}

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
	
	public String getCursoNome() {
		return cursoNome;
	}

	public void setCursoNome(String cursoNome) {
		this.cursoNome = cursoNome;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getCursoNome();
	}
	
}
