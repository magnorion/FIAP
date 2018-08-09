package br.com.fiap.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataHoraClasse {
	private String dataTexto;
	private Date data;
	private String formato;
	
	public DataHoraClasse(String data, String formato) {
		this.dataTexto = data;
		this.formato = formato;
	}
	
	public String formatarData(String novoFormato) {
		try {
			SimpleDateFormat formatador = new SimpleDateFormat(this.formato);
			this.data = formatador.parse(this.dataTexto);
			formatador.applyPattern(novoFormato);
			
			return formatador.format(this.data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Date getData() {
		return this.data;
	}
}
