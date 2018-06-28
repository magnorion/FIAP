package br.com.fiap.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="alunos", catalog="dbescola")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	private String nome;
	private String endereco;
	private int idade;
	private float nota;
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Set<Curso> getCurso() {
		return cursos;
	}
	public void setCurso(Set<Curso> curso) {
		this.cursos = curso;
	}
	
	public float getNota() {
		return nota;
	}
	
	public void setNota(float nota) {
		this.nota = nota;
	}
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "alunos_cursos",
        joinColumns = @JoinColumn(name = "id_aluno"),
        inverseJoinColumns = @JoinColumn(name = "id_curso")
    )
	private Set<Curso> cursos = new HashSet<>();
	
	public Set<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}
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
	
}
