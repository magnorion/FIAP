package br.com.fiap.classes;

import java.util.ArrayList;
import java.util.List;

public class Mensagem extends Thread {
	private List<String> lista = new ArrayList<String>();
	
	public Mensagem() {
		this.lista.add("Olá, tudo bem?");
		this.lista.add("Vou bem e você?");
		this.lista.add("Vou bem também!");
		this.lista.add("Que bom!");
		this.lista.add("Fim da conversa!!!");
	}
	
	@Override
	public void run() {
		try {
			for (String msg : lista) {
				sleep(20000);
				System.out.println("Mensagem: " + msg);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
