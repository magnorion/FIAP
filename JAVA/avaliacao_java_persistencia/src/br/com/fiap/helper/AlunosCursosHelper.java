package br.com.fiap.helper;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.AlunosCursos;
import br.com.fiap.entity.Curso;
import br.com.fiap.repository.AlunoRepository;
import br.com.fiap.repository.CursoRepository;

public class AlunosCursosHelper implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public AlunosCursosHelper(EntityManager em) {
		this.em = em;
	}
	
	public String nota(int alunoId, int cursoId, float nota) {
		try {

			Aluno aluno = em.find(Aluno.class, alunoId);
			Curso curso = em.find(Curso.class, cursoId);
			
			AlunosCursos alunosCursos = new AlunosCursos();
			alunosCursos.setAluno(aluno);
			alunosCursos.setCurso(curso);
			
			AlunosCursos teste = em.find(AlunosCursos.class, alunosCursos);
			em.getTransaction().begin();
			teste.setNota(nota);
			em.getTransaction().commit();
			return "Nota cadastrada com sucesso!";
			
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
