package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alunos_cursos")
public class AlunosCursos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Aluno aluno;
	private Curso curso;
	
	@Column(nullable=true, name="nota")
	private Float nota;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_aluno")
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@Id
	@ManyToOne
	@JoinColumn(name = "id_curso")
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
}
