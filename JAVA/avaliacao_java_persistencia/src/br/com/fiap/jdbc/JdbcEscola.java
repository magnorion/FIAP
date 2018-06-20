package br.com.fiap.jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.fiap.entity.Escola;
import br.com.fiap.mapper.EscolaMapper;

public class JdbcEscola implements Serializable {
	private static final long serialVersionUID = 1L;

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void incluirEscola(Escola escola) throws Exception {
		try {
			String sql = "INSERT INTO escolas (nome) VALUES (?)";
			this.jdbcTemplate.update(sql, escola.getNome());
		} catch (Exception e) {
			throw e;
		}
	}

	public Escola buscarEscola(int id) throws Exception {
		Escola escola = null;
		try {
			String query = "SELECT * FROM escolas WHERE ID = ?";
			escola = this.jdbcTemplate.queryForObject(query, new Integer[] { id }, new EscolaMapper());
		} catch (Exception e) {
			throw e;
		}

		return escola;
	}

	public List<Escola> listarEscolas() throws Exception {
		List<Escola> escolas = new ArrayList<>();
		try {
			escolas = this.jdbcTemplate.query("SELECT * FROM escolas", new EscolaMapper());
		} catch (Exception e) {
			throw e;
		}
		return escolas;
	}
}
