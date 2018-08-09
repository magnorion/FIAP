package br.com.fiap.app;

import br.com.fiap.classes.Cores;

public class CoresExercicio {
	public static void main(String[] args) {
		for (Cores cor : Cores.values()) {
			System.out.println(cor.recuperaNomeCor() + " " + cor.recuperaCodigoCor());
		}
		
		System.out.println("---");
		System.out.println("Codigo " + Cores.BRANCO.recuperaNomeCor() + ": "+ Cores.BRANCO.recuperaCodigoCor());
	}
}
