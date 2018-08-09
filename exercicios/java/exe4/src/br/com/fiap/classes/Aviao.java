package br.com.fiap.classes;

public class Aviao extends Thread{
	
	private Aeroporto aeroporto;
	private String voo;
	
	public Aviao(String voo, Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
		this.voo = voo;
	}
	
	public void decolar () throws InterruptedException {
		this.aeroporto.aguardarPistaDisponivel();
		System.out.println(voo + " acaba de decolar");
	}
	
	public void voar () throws InterruptedException {
		sleep(2000);
		System.out.println(voo + " esta voando!");
	}
	
	public void aterrissar () throws InterruptedException {
		this.aeroporto.aguardarPistaDisponivel();
		System.out.println(voo + " acaba de aterrisar");
	}
	
	@Override
	public void run () {
		while(true) {
			try {
				this.decolar();
				this.voar();
				this.aterrissar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
