package br.com.fiap.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import br.com.fiap.entity.Escola;
import br.com.fiap.helper.EscolaHelper;
import br.com.fiap.jdbc.JdbcEscolaCurso;
import br.com.fiap.viewmodel.EscolaCursoViewModel;

public class AppEscola {

	private EntityManager em;

	public static void main(String[] args) {
		// incluirEscola();
		// listarEscolas();
		listarEscolasCursos();
		// removerEscola();
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

	private static void listarEscolasCursos() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
			List<EscolaCursoViewModel> escolas = ((JdbcEscolaCurso) context.getBean("AppEscolaCursosDao"))
					.lista();
			for (EscolaCursoViewModel vm : escolas) {
				System.out.println("Escola: " + vm.getNome());
				System.out.println("Num. Cursos: " + vm.getQtd());
				System.out.println("====");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void removerEscola() {
		EscolaHelper helper = new EscolaHelper(setEm());

		int id = 1;
		System.out.println(helper.remover(id));
	}

	public static EntityManager setEm() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("avaliacao_java_persistencia");
		EntityManager em = emf.createEntityManager();

		return em;
	}

}
