package br.com.fiap.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.ValidationEvent;

import org.springframework.jdbc.core.RowMapper;

import br.com.fiap.viewmodel.EscolaCursoViewModel;

public class EscolaCursoMapper implements Serializable, RowMapper<EscolaCursoViewModel> {

	private static final long serialVersionUID = 1L;

	@Override
	public EscolaCursoViewModel mapRow(ResultSet rs, int arg1) throws SQLException {
		EscolaCursoViewModel vm = new EscolaCursoViewModel();
		
		vm.setNome(rs.getString("nomeEscola"));
		vm.setCursoNome(rs.getString("nomeCurso"));
		vm.setQtd(rs.getInt("qtd"));
		return vm;
	}
	
}
