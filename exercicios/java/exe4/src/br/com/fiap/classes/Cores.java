package br.com.fiap.classes;

public enum Cores {
	BRANCO(21, "BRANCO"), PRETO(22, "PRETO"), VERMELHO(23, "VERMELHO"), AMARELO(24, "AMARELO"), AZUL(25, "AZUL");
	
	private String nomeCor;
	private int codigoCor;
	
	Cores(int cod, String nome) {
		this.nomeCor = nome;
		this.codigoCor = cod;
	}
	
	public String recuperaNomeCor () {
		return this.nomeCor;
	}
	
	public int recuperaCodigoCor () {
		return codigoCor;
	}
	
}
