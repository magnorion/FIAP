package br.com.fiap.viewmodel;

import java.io.Serializable;

public class CursoAlunoViewModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private int idade;
	private String endereco;
	private int cursoId;
	private String cursoNome;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getCursoId() {
		return cursoId;
	}
	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
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
		return this.getNome();
	}
	
}
