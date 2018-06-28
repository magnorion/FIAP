package br.com.fiap.helper;

import java.io.Serializable;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Escola;

public class AlunoHelper implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public AlunoHelper(EntityManager em) {
		this.em = em;
	}
	
	public String salvar(Aluno aluno) {
		try {
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
			return "Aluno cadastrado com sucesso!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String remover(int id) {
		try {
			Aluno aluno = em.find(Aluno.class, id);
			em.getTransaction().begin();
			em.remove(aluno);
			em.getTransaction().commit();
			return "Aluno removido com sucesso!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
