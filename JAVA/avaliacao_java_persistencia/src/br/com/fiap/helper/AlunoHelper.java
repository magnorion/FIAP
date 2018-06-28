package br.com.fiap.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;

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
	
	public String cadastraCurso(Aluno aluno, int idCurso) {
		
		try {
			Set<Curso> cursos = new HashSet<>();
			Curso curso = em.find(Curso.class, idCurso);
			cursos.add(curso);
			em.getTransaction().begin();
			aluno.getCurso().add(curso);
			em.merge(aluno);
			em.getTransaction().commit();
			return aluno.getNome() + " foi cadastrado no curso com sucesso!";
		} catch (Exception e) {
			// TODO: handle exception
			return e.getMessage();
		}

	}
	
	public Aluno retornaAluno(int id) {
		Aluno aluno = new Aluno();
		try {
			aluno = em.find(Aluno.class, id);
			return aluno;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return aluno;
	}
	
	
	public String nota(float nota, int id) {
		try {
			Aluno aluno = em.find(Aluno.class, new Integer[] {id});
			em.getTransaction().begin();
			em.getTransaction().commit();
			return "Nota atualizada!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
}
