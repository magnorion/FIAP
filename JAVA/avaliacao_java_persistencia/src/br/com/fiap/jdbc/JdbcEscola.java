package br.com.fiap.jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Escola;
import br.com.fiap.mapper.CursoMapper;
import br.com.fiap.mapper.EscolaMapper;

public class JdbcEscola implements Serializable {
	private static final long serialVersionUID = 1L;

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void incluirCurso(Curso curso) throws Exception {
		try {
			String sql = "INSERT INTO curso (nome, id_escola) VALUES (?, ?)";
			this.jdbcTemplate.update(sql, curso.getNome(), curso.getEscola());
		} catch (Exception e) {
			throw e;
		}
	}
}
