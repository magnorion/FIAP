package br.com.fiap.dao;

import java.util.HashSet;
import java.util.Set;

import br.com.fiap.entity.Evento;
import br.com.fiap.entity.Participante;
import br.com.fiap.repository.Repositorio;

public class ParticipantesDao extends Dao<Participante>{

	@Override
	public void incluir(Participante elemento) throws Exception {
		// TODO Auto-generated method stub
		try {
		abrirConexao();
		
		String sql = "INSERT INTO participantes(id_evento, nome, email) "
				+ "VALUES(?,?,?)";
		stmt = cn.prepareStatement(sql);
		
		stmt.setInt(1, elemento.getEvento().getId());
		stmt.setString(2,  elemento.getNome());
		stmt.setString(3, elemento.getEmail());
		
		stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
	}

	@Override
	public Participante buscar(int id) throws Exception {
		Participante participante = null;
		
		try {
			abrirConexao();
			
			stmt = cn.prepareStatement("SELECT * FROM participantes WHERE id=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				participante = new Participante();
				participante.setId(id);
				participante.setEvento(
						Repositorio.getEventosDao().buscar(rs.getInt("id_evento")));
				participante.setNome(rs.getString("nome"));
				participante.setEmail(rs.getString("email"));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
		return participante;
	}

	@Override
	public Set<Participante> listar(int... param) throws Exception {
		// TODO Auto-generated method stub
		Set<Participante> lista = new HashSet<>();
		
		try {
			
			if (param.length != 1) {
				throw new Exception("Só é permitido um parametro!");
			}
			
			abrirConexao();
			
			stmt = cn.prepareStatement("SELECT * FROM participantes WHERE id_evento = ?");
			stmt.setInt(1, param[0]);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Participante participante = new Participante();
				participante.setId(rs.getInt("id"));
				participante.setEvento(
						Repositorio.getEventosDao().buscar(rs.getInt("id_evento")));
				participante.setNome(rs.getString("nome"));
				participante.setEmail(rs.getString("email"));
				
				lista.add(participante);
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
		return lista;
	}

}
