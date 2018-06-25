package br.com.fiap.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Escola;

public class CursoMapper implements RowMapper<Curso>, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public Curso mapRow(ResultSet rs, int arg1) throws SQLException {
		Curso curso = new Curso();
		curso.setId(rs.getInt("id"));
		curso.setNome(rs.getString("nome"));
		curso.setEscola(getEscola(rs.getInt("id_escola")));
		
		return curso;
	}
	
	public Escola getEscola(int id) {
		Escola escola = new Escola();
		escola.setId(id);
		return escola;
	}
}
