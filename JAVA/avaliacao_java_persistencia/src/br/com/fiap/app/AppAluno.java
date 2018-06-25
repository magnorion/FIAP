package br.com.fiap.app;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Escola;
import br.com.fiap.helper.AlunoHelper;

public class AppAluno implements Serializable {

	private EntityManager em;
	
	public static void main(String[] args) {
		// listarAlunos();
		// removerAluno();
	}
	
	private static void listarAlunos() {
		AlunoHelper helper = new AlunoHelper(setEm());
		
		for (Aluno aluno : helper.listarAlunos()) {	
			System.out.println("Id do aluno: " + aluno.getId());
			System.out.println("Nome do aluno: " + aluno.getNome());
			System.out.println("Idade do aluno: " + aluno.getIdade());
			System.out.println("Endereço: " + aluno.getEndereco());
			System.out.println("====");
		}
	}
	
	private static void removerAluno() {
		AlunoHelper helper = new AlunoHelper(setEm());
		int id = 1;
		
		System.out.println(helper.remover(id));
	}
	
	public static EntityManager setEm() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("avaliacao_java_persistencia");
		EntityManager em = emf.createEntityManager();
		
		return em;
	}
}
