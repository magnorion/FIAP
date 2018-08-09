package br.com.fiap.app;

import br.com.fiap.classes.DataHora;
import br.com.fiap.classes.Mensagem;

public class ThreadExercicio {
	public static void main(String[] args) {
		Mensagem msg = new Mensagem();
		DataHora data = new DataHora();
		
		msg.start();
		data.start();
		
		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						sleep(5000);
						System.out.println("O estado das mensagens: " + msg.getState());
						System.out.println("O estado do horario: " + data.getState());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
