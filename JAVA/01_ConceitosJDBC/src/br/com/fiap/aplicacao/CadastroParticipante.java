package br.com.fiap.aplicacao;

import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import br.com.fiap.dao.EventosDao;
import br.com.fiap.dao.ParticipantesDao;
import br.com.fiap.entity.Evento;
import br.com.fiap.entity.Participante;
import br.com.fiap.repository.Repositorio;

public class CadastroParticipante {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
			while (true) {
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja incluir um Participante?", 
						"Confirma��o", JOptionPane.YES_NO_OPTION);
				if (opcao == JOptionPane.NO_OPTION) {
					break;
				}
				
				// Buscando o evento
				EventosDao dao = Repositorio.getEventosDao();
				Set<Evento> listaEventos = dao.listar();
				
				Evento evento = (Evento) JOptionPane.showInputDialog(null, "Selecione um evento",
						"Eventos", JOptionPane.DEFAULT_OPTION, null, listaEventos.toArray(), null);
			
				String nome = JOptionPane.showInputDialog("Nome do participante");
				String email = JOptionPane.showInputDialog("Email do participante");
				
				/**
				 * Implementar a classe participanteDao
				 * Preparar a inclus�o do participante
				 * Prever uma op��o para listar todos os participaentes de um evento
				 */
				
				Participante participante = new Participante();
				participante.setEvento(evento);
				participante.setNome(nome);
				participante.setEmail(email);
				
				ParticipantesDao participanteDao = Repositorio.getParticipantesDao();
				participanteDao.incluir(participante);
				
				JOptionPane.showMessageDialog(null, "Participante incluido com sucesso!", 
						",mensagem", JOptionPane.INFORMATION_MESSAGE);

			}
			
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage(),
					"ERRO",JOptionPane.ERROR_MESSAGE);
		} finally {
			// TODO: handle finally clause
		}
	}
}
