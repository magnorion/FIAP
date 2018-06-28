package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
