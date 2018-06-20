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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;

@Entity
@Table(name="alunos", catalog="dbescola")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	private String nome;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="alunos_cursos", catalog="dbescolas", joinColumns = 
	{@JoinColumn(name="id_aluno", nullable=false, updatable=false)},
	inverseJoinColumns = {@JoinColumn(name="id_curso", nullable=false, updatable=false)} )
	private Set<Curso> curso = new HashSet<>();
	
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
