package br.com.fiap.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.fiap.entity.Escola;

public class EscolaMapper implements RowMapper<Escola>, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public Escola mapRow(ResultSet rs, int arg1) throws SQLException {
		Escola escola = new Escola();
		escola.setId(rs.getInt("id"));
		escola.setNome(rs.getString("nome"));
		
		return escola;
	}

}
