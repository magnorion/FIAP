package br.com.fiap.app;

import javax.swing.JOptionPane;

import br.com.fiap.classes.Arquivo;
import br.com.fiap.classes.Crypto;

public class CodificacaoExercicio {
	public static void main(String[] args) {
		System.out.println("O Arquivo será gerado em: " + System.getProperty("java.io.tmpdir"));
		String texto = JOptionPane.showInputDialog("Digite a mensagem a ser codificada:");
		
		// Salva arquivo codificado e ler o conteudo
		Arquivo.salvar(Crypto.codifique(texto), "mensagemCodificada");
		JOptionPane.showMessageDialog(null, Arquivo.ler("mensagemCodificada"), "Mensagem codificada!", 0);
		
		// Decodifica o arquivo
		Arquivo.salvar(Crypto.descodifique(Arquivo.ler("mensagemCodificada")), "mensagemDecodificada");
		JOptionPane.showMessageDialog(null, Arquivo.ler("mensagemDecodificada"), "Mensagem codificada!", 0);
	}
}
