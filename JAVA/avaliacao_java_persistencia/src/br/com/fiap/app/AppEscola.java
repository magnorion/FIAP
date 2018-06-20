package br.com.fiap.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Escola;
import br.com.fiap.helper.EscolaHelper;

public class AppEscola {
	
	private EntityManager em;
	
	public static void main(String[] args) {
		//incluirEscola();
		listarEscolas();
		// removerEscola();
	}

	private static void incluirEscola() {
		EscolaHelper helper = new EscolaHelper(setEm());
		
		Escola escola = new Escola();
		escola.setNome("Minha escolinha");
		escola.setEndereco("Rua: Belford Duarte");
		
		System.out.println(helper.salvar(escola));
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

