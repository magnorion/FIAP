package br.com.fiap.classes;

public class Aeroporto extends Thread{
	
	private String nome;
	private Boolean disponivel;
	
	public Aeroporto(String nome) {
		this.nome = nome;
		this.disponivel = true;
	}
	
	public Boolean aguardarPistaDisponivel() throws InterruptedException {	
		while (!this.disponivel) {
			sleep(1000);
			System.out.println("Aeroporto " + this.nome + ": aguardando pista disponivel...");
		}
		System.out.println("Aeroporto " + this.nome + ": pista dsponivel!!!");
		
		return this.disponivel;
	}
	
	public void alteraEstadoPista() {
		if (this.disponivel) {
			this.disponivel = false;
		} else {
			this.disponivel = true;
		}
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				sleep(3000);
				this.alteraEstadoPista();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
