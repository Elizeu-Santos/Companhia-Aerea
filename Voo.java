package helloworld;

import java.util.Arrays;

public class Voo {
	private int numeroVoo;
	private String nomeVoo;
	private String data;
	private Passageiro[] vetPassageiro;
	private int AssentosTotais = 10;
		
	public int getAssentos() {
		return this.AssentosTotais;
	}

	public void setAssentos(int assentos) {
		AssentosTotais = assentos;
	}
	
	public Voo(){
		this.vetPassageiro = new Passageiro[40];
	}

	public int getNumeroVoo() {
		return this.numeroVoo;
	}
	
	public void setNumeroVoo(int nt) {
		this.numeroVoo = nt;
	}

	public String getNomeVoo() {
		return this.nomeVoo;
	}
	
	public void setNomeVoo(String n) {
		this.nomeVoo = n;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Passageiro getPassageiro(int pos) {
		return this.vetPassageiro[pos];
	}
	
	public void setPassageiro(int pos, Passageiro a) {
		this.vetPassageiro[pos] = a;
	}
}