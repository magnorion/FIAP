package br.com.fiap.helper;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Escola;

public class EscolaHelper implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public EscolaHelper(EntityManager em) {
		this.em = em;
	}
	
	public String salvar(Escola escola) {
		try {
			em.getTransaction().begin();
			em.persist(escola);
			em.getTransaction().commit();
			return "Escola cadastrada com sucesso!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public List<Escola> listarEscolas() {
		TypedQuery<Escola> query = em.createQuery("SELECT s FROM Escola s", Escola.class);
		return query.getResultList();
	}
	
	public String remover(int id) {
		try {
			Escola escola = em.find(Escola.class, id);
			em.getTransaction().begin();
			em.remove(escola);
			em.getTransaction().commit();
			return "Escola removida com sucesso!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
