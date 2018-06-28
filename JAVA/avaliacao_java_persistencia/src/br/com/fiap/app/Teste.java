package br.com.fiap.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.helper.AlunosCursosHelper;

public class Teste {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("avaliacaojavapersistencia");
		EntityManager em = emf.createEntityManager();
		
		AlunosCursosHelper helper = new AlunosCursosHelper(em);
		System.out.println(helper.nota(1, 1, 2));
	}
}
