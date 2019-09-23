package br.com.am.entities;

public class Rseguranca {

	private Long id_respostaSeg;
	private String Rseguranca;

	public Rseguranca() {
		super();
	}

	public Rseguranca(Long id_respostaSeg, String rseguranca) {
		super();
		this.id_respostaSeg = id_respostaSeg;
		Rseguranca = rseguranca;

	}

	public Long getId_respostaSeg() {
		return id_respostaSeg;
	}

	public void setId_respostaSeg(Long id_respostaSeg) {
		this.id_respostaSeg = id_respostaSeg;
	}

	public String getRseguranca() {
		return Rseguranca;
	}

	public void setRseguranca(String rseguranca) {
		Rseguranca = rseguranca;
	}

}
