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
			escolas = this.jdbcTemplate.query("SELECT escolas.nome AS nomeEscola, cursos.nome AS nomeCurso, COUNT(cursos.id) AS qtd"
					+ " FROM escolas, cursos WHERE escolas.id = cursos.id_escola GROUP BY cursos.id", new EscolaCursoMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return escolas;
	}
}
