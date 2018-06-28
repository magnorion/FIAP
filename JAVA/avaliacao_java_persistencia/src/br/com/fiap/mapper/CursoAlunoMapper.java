package br.com.fiap.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.fiap.viewmodel.CursoAlunoViewModel;

public class CursoAlunoMapper implements Serializable, RowMapper<CursoAlunoViewModel>{

	private static final long serialVersionUID = 1L;

	@Override
	public CursoAlunoViewModel mapRow(ResultSet rs, int arg1) throws SQLException {
		CursoAlunoViewModel vm = new CursoAlunoViewModel();
		
		vm.setId(rs.getInt("id"));
		vm.setCursoId(rs.getInt("cursoId"));
		vm.setCursoNome(rs.getString("cursoNome"));
		vm.setEndereco(rs.getString("endereco"));
		vm.setNome(rs.getString("nome"));
		vm.setIdade(rs.getInt("idade"));
		
		return vm;
	}

}
