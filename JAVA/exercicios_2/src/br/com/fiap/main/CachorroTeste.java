package br.com.fiap.main;

import br.com.fiap.exercicios.Cachorro;
import br.com.fiap.exercicios.ChowChow;

public class CachorroTeste {
	public static void main(String[] args) {
		// A
		ChowChow chowChow = new ChowChow();
		Boolean valor = chowChow instanceof Cachorro;
		
		System.out.println("Verdadeiro ou Falso "+ valor);
		// A é verdadeiro pois Cachorro seria a super classe e por herança, ele pode ser considerado uma instancia!
		
		// B
		Cachorro dog = new Cachorro();
		valor = dog instanceof ChowChow;
		System.out.println("Verdadeiro ou Falso "+ valor);
		// B é falso pois ChowChow seria uma sub classe e não foi instanciado. Como não há alguma herança e ele é uma instancia direta da Classe Cachorro, não há ligação alguma com ChowChow
	}
}
