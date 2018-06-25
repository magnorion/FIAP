package br.com.fiap.app;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Escola;
import br.com.fiap.helper.AlunoHelper;
import br.com.fiap.helper.EscolaHelper;
import br.com.fiap.jdbc.JdbcCurso;

public class MainApp {
	
	public static void main(String[] args) {
		
		/**
		 * Inicia a aplicação com os dados inciais
		 * Cadastra escola, curso e alunos
		 */
		
		// Escola escola = bootstrapEscola();
		// Curso curso = bootstrapCurso(escola);
		// bootstrapAluno(curso);
		
		
		/**
		 * Busca de dados
		 */
		
		// listarAlunos();
		listarEscolas();
		
	}
	
	public static Escola bootstrapEscola() {
		EscolaHelper helper = new EscolaHelper(setEm()); 
		Escola escola = new Escola();
		escola.setNome("Escola Legal");
		escola.setEndereco("Um end qualquer");
		
		System.out.println(helper.salvar(escola));
		
		return escola;
	}
	
	public static Curso bootstrapCurso(Escola escola) {
		Curso curso = new Curso();
		
		try {
			curso.setNome("ADMINISTRAÇÃO");
			curso.setEscola(escola);
			
			JdbcCurso dao = dao();
			dao.incluirCurso(curso);
			
			System.out.println("Curso cadastrado!");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return curso;
	}
	
	public static void bootstrapAluno(Curso curso) {
		AlunoHelper helper = new AlunoHelper(setEm()); 
		
		Aluno aluno = new Aluno();
		aluno.setNome("Cazalbe");
		aluno.setIdade(45);
		aluno.setEndereco("Rua: Praça nossa");
		
		aluno.getCurso().add(curso);
		
		System.out.println(helper.salvar(aluno));
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
	
	private static void listarEscolas() {
		EscolaHelper helper = new EscolaHelper(setEm());

		for (Escola escola : helper.listarEscolas()) {
			System.out.println("Id da escola: " + escola.getId());
			System.out.println("Nome da escola: " + escola.getNome());
			System.out.println("Endereço: " + escola.getEndereco());
			System.out.println("====");
		}
	}
	
	/**
	 * SetEm
	 * @return EntityManager
	 */
	public static EntityManager setEm() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("avaliacao_java_persistencia");
		EntityManager em = emf.createEntityManager();

		return em;
	}
	
	/**
	 * dao
	 * @return JdbcCurso
	 */
	public static JdbcCurso dao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
		JdbcCurso dao = (JdbcCurso) context.getBean("AppEscolaCursos");
		
		return dao;
	}
}
