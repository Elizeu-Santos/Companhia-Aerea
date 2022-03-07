package helloworld;

public class Companhia {
	
	private String nome;
	private String fone;
	private Voo[] vetVoo;
	private int qtdeVoo;

	public Companhia() {
		this.vetVoo = new Voo[20];
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String n) {
		this.nome = n;
	}

	public String getFone() {
		return this.fone;
	}
	
	public void setFone(String f) {
		this.fone = f;
	}

	public int getqtdeVoo() {
		return this.qtdeVoo;
	}
	
	public void setqtdeVoo(int qt){
		this.qtdeVoo = qt;
	}

	public Voo getVoo(int pos) {
		return this.vetVoo[pos];
	}
	
	public void setVoo(Voo t){
		this.setqtdeVoo(this.getqtdeVoo() + 1);
		int pos = this.getqtdeVoo() - 1;
		this.vetVoo[pos] = t;
	}
}