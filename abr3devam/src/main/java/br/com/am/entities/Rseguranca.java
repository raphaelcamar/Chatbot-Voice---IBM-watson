package br.com.am.entities;

public class Rseguranca {

	private int id_respostaSeg;
	private String rseguranca;
	private Cadastro cadastro;

	public Rseguranca(int id_respostaSeg, String rseguranca, Cadastro cadastro) {
		super();
		this.id_respostaSeg = id_respostaSeg;
		this.rseguranca = rseguranca;
		this.cadastro = cadastro;
	}

	public Rseguranca() {
		super();
	}

	public int getId_respostaSeg() {
		return id_respostaSeg;
	}

	public void setId_respostaSeg(int id_respostaSeg) {
		this.id_respostaSeg = id_respostaSeg;
	}

	public String getRseguranca() {
		return rseguranca;
	}

	public void setRseguranca(String rseguranca) {
		this.rseguranca = rseguranca;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

}
