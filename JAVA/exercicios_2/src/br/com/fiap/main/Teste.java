package br.com.fiap.main;

import br.com.fiap.exercicios.Equipamento;
import br.com.fiap.exercicios.EquipamentoEletronico;
import br.com.fiap.exercicios.Movel;
import br.com.fiap.exercicios.Smartphone;
import br.com.fiap.exercicios.Tablet;

public class Teste {
	public static void main(String[] args) {
		EquipamentoEletronico tablet = (EquipamentoEletronico) new Tablet();
		EquipamentoEletronico smartphone = new Smartphone();
		Equipamento equipamento = new Equipamento();
		Object objeto = new Object();
		Movel movel = new Movel();
		Tablet tablet2 = new Tablet();
		Smartphone smartphone2 = new Smartphone();
		
		//Implicito
		objeto = equipamento; // A
		objeto = movel; // B
		equipamento = smartphone2; // D
		smartphone = tablet; // E
		
		
		// Explicito
		equipamento = (Equipamento) tablet; //G
		movel = (Movel) tablet; //H
		tablet = (EquipamentoEletronico) equipamento; // I
		
		// Impossivel
		// equipamento = tablet2; // C
		// smartphone2 = tablet2; // F
		
	}
}
