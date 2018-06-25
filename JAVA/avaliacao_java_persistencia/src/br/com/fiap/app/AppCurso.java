package br.com.fiap.app;

import java.io.Serializable;

import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Escola;
import br.com.fiap.jdbc.JdbcCurso;

public class AppCurso implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// incluirCurso();
		listarCursos();
	}

	public static JdbcCurso dao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
		JdbcCurso dao = (JdbcCurso) context.getBean("AppEscolaCursos");
		
		return dao;
	}
	
	public static void incluirCurso() {
		try {
			JdbcCurso dao = dao();
			
			Curso curso = new Curso();
			curso.setNome("ADMINISTRAÇÃO");
			
			Escola escola = new Escola();
			escola.setId(2);
			
			curso.setEscola(escola);
			
			dao.incluirCurso(curso);
			JOptionPane.showMessageDialog(null, "Curso cadastrado!");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static void listarCursos() {
		try {
			JdbcCurso dao = dao();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
