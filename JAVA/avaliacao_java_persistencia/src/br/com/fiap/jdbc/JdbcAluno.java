package br.com.fiap.jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.fiap.mapper.AlunoMapper;
import br.com.fiap.mapper.CursoAlunoMapper;
import br.com.fiap.viewmodel.CursoAlunoViewModel;

public class JdbcAluno implements Serializable {

	private static final long serialVersionUID = 1L;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<CursoAlunoViewModel> lista(int id) throws Exception {
		List<CursoAlunoViewModel> alunos = new ArrayList<>();
		
		try {
			alunos =  (List<CursoAlunoViewModel>) this.jdbcTemplate.query(
					"SELECT alunos.nome, alunos.id, alunos.idade, alunos.endereco,"
					+ " escolas.id AS cursoId, cursos.id AS identf, escolas.nome AS cursoNome"
					+ " FROM alunos, escolas, cursos WHERE escolas.id = ? AND cursos.id_escola = escolas.id", 
					new Integer[] {id},
					new CursoAlunoMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return alunos;
	}
}
