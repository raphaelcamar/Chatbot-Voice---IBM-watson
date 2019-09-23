package br.com.am.entities;

public class Login {

	private String rm;
	private String senha;
	private String nome;
	
	
	public Login(String rm, String senha, String nome) {
		super();
		this.rm = rm;
		this.senha = senha;
		this.nome = nome;
	}
	public Login() {
		super();
	}
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
