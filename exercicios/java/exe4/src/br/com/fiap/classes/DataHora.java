package br.com.fiap.classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataHora extends Thread{
	private SimpleDateFormat forma;
	private Date hoje;
	
	@Override
	public void run() {
		forma = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		while (true) {
			try {
				hoje = Calendar.getInstance().getTime();
				sleep(10000);
				System.out.println("Horario: " + forma.format(hoje));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
