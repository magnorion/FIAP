package br.com.fiap.jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.fiap.mapper.EscolaCursoMapper;
import br.com.fiap.viewmodel.EscolaCursoViewModel;

public class JdbcEscolaCurso implements Serializable {

	private static final long serialVersionUID = 1L;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource data) {
		this.jdbcTemplate = new JdbcTemplate(data);
	}
	
	public List<EscolaCursoViewModel> lista() {
		List<EscolaCursoViewModel> escolas = new ArrayList<>();
		try {
			escolas = this.jdbcTemplate.query("SELECT e.nome, COUNT(c.id) AS qtd"
					+ " FROM escolas AS e, cursos AS c WHERE e.id = c.id_escola GROUP BY e.nome", new EscolaCursoMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return escolas;
	}
}
