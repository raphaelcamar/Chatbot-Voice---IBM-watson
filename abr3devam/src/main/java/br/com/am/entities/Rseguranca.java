package br.com.am.entities;

public class Rseguranca {

	private int id_respostaSeg;
	private String Rseguranca;

	public Rseguranca() {
		super();
	}

	public Rseguranca(int id_respostaSeg, String rseguranca) {
		super();
		this.id_respostaSeg = id_respostaSeg;
		Rseguranca = rseguranca;

	}

	public int getId_respostaSeg() {
		return id_respostaSeg;
	}

	public void setId_respostaSeg(int id_respostaSeg) {
		this.id_respostaSeg = id_respostaSeg;
	}

	public String getRseguranca() {
		return Rseguranca;
	}

	public void setRseguranca(String rseguranca) {
		Rseguranca = rseguranca;
	}

}
