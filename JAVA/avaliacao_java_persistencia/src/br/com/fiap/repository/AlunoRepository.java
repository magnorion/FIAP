package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
