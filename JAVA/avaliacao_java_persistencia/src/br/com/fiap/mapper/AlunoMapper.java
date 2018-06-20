package br.com.fiap.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.fiap.entity.Aluno;

public class AlunoMapper implements RowMapper<Aluno>, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Aluno mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Aluno aluno = new Aluno();
		aluno.setId(rs.getInt("id"));
		aluno.setNome(rs.getString("nome"));
		
		return aluno;
	}
	
}
