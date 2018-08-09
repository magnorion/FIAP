package br.com.fiap.app;

import br.com.fiap.classes.Aeroporto;
import br.com.fiap.classes.Aviao;

public class AeroportoExercicio {
	public static void main(String[] args) {
		Aeroporto aeroporto = new Aeroporto("Top");
		
		Aviao aviao = new Aviao("TAN 123", aeroporto);
		Aviao aviao2 = new Aviao("OLÉ 111", aeroporto);
		Aviao aviao3 = new Aviao("LINHA 222", aeroporto);
		
		aeroporto.start();
		
		aviao.start();
		aviao2.start();
		aviao3.start();
	}
}
