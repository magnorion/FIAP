package br.com.fiap.jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.fiap.entity.Curso;
import br.com.fiap.mapper.CursoMapper;

public class JdbcCurso implements Serializable{

	private static final long serialVersionUID = 1L;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void incluirCurso(Curso curso) throws Exception {
		try {
			String sql = "INSERT INTO cursos (nome, id_escola) VALUES (?, "
					+ "(SELECT id FROM escolas WHERE id = ?))";
			this.jdbcTemplate.update(sql, curso.getNome(), curso.getEscola());
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Curso buscarCurso(int id_curso, int id_escola) throws Exception {
		Curso curso = null;
		try {
			String query = "SELECT * FROM cursos WHERE ID = ? AND id_escola = ?";
			curso = this.jdbcTemplate.queryForObject(query, new Integer[] { id_curso, id_escola }, new CursoMapper());
		} catch (Exception e) {
			throw e;
		}

		return curso;
	}

	public List<Curso> listarCursos(int id_escola) throws Exception {
		List<Curso> cursos = new ArrayList<>();
		try {
			cursos = (List<Curso>) this.jdbcTemplate.queryForObject(
					"SELECT * FROM cursos WHERE id_escola = ?", 
					new Integer[] {id_escola},
					new CursoMapper());
		} catch (Exception e) {
			throw e;
		}
		return cursos;
	}
}
