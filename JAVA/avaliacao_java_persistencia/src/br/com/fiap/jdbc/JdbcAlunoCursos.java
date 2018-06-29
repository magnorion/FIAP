package br.com.fiap.jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.fiap.mapper.CursoAlunoMapper;
import br.com.fiap.viewmodel.CursoAlunoViewModel;

public class JdbcAlunoCursos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource data) {
		this.jdbcTemplate = new JdbcTemplate(data);
	}
	
	public List<CursoAlunoViewModel> lista(int id) {
		List<CursoAlunoViewModel> cursos = new ArrayList<>();
		try {
			cursos = (List<CursoAlunoViewModel>) this.jdbcTemplate.query(
					"SELECT alunos.id, cursos.id AS cursoId, cursos.nome AS cursoNome,"
					+ " alunos.endereco, alunos.nome, alunos.idade FROM alunos, cursos"
					+ " WHERE alunos.id = ?",
					new Integer[] {id},
					new CursoAlunoMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cursos;
	}
}
