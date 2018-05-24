package br.com.fiap.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="functionario", catalog="dbtarefas", uniqueConstraints = {
		@UniqueConstraint(columnNames="codido_funcionario")
})
@NamedQuery(name="funcionario.findAll", query="select f from Funcionario f")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="codigo_funcionario", unique=true, nullable=false, length=10)
	private String nome;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="FUNCIONARIO_TAREFA", catalog="dbtarefas", joinColumns = {@JoinColumn(name="FUNCIONARIO_ID", nullable=false, updatable=false)},
	inverseJoinColumns = {@JoinColumn(name="TAREFA_ID", nullable=false, updatable=false)})
	private Set<Tarefa> tarefas = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(Set<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
}
