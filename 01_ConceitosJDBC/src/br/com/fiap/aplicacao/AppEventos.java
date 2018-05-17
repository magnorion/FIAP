package br.com.fiap.aplicacao;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import br.com.fiap.dao.EventosDao;
import br.com.fiap.entity.Evento;

public class AppEventos {
	public static void main(String[] args) {
		try {
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			int opcao = JOptionPane.showConfirmDialog(null, "Deseja incluir um evento?", 
					"Confirmação", JOptionPane.YES_NO_OPTION);
			
			if (opcao != JOptionPane.NO_OPTION) {
				String descricao = JOptionPane.showInputDialog("Descricao do evento: ");
				
				String data = JOptionPane.showInputDialog("Data do evento (aa/mm/aaaa)");
				Date dataEvento = new SimpleDateFormat("dd/MM/yyyy").parse(data);
				String responsavel = JOptionPane.showInputDialog("Responsavel do Evento");
				
				Evento evento = new Evento();
				evento.setData(dataEvento);
				evento.setDescricao(descricao);
				evento.setResponsavel(responsavel);
				
				EventosDao dao = new EventosDao();
				dao.incluir(evento);
				
				JOptionPane.showMessageDialog(null, "Evento incluido com sucesso!", 
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
