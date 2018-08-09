package br.com.fiap.app;

import br.com.fiap.classes.DataHoraClasse;

public class DataHoraExercicio {
	public static void main(String[] args) {
		DataHoraClasse dataHora = new DataHoraClasse("10/09/2012 12:00", "dd/MM/yyyy H:s");
		
		// formato: 2012-09-10 12:00
		System.out.println(dataHora.formatarData("yyyy-MM-dd H:ss"));
		
		// formato: 10-09-12 12:00:00
		System.out.println(dataHora.formatarData("dd-MM-yy H:ss:mm"));
		
		// formato: DIA DA SEMANA
		System.out.println(dataHora.formatarData("EEEE"));
		
		// formato: ANO
		System.out.println(dataHora.formatarData("yyyy"));
		
		// formato: ERA
		System.out.println(dataHora.formatarData("G"));
	}
}
