package br.com.am.entities;

public class Cadastro {

	private String nome;
	private String sobrenome;
	private String email;
	private String rm;
	public Cadastro() {
		super();
	}
	public Cadastro(String nome, String sobrenome, String email, String rm, String senha, String confirmarSenha,
			String respostaSeguranca) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.rm = rm;
		this.senha = senha;
		this.confirmarSenha = confirmarSenha;
		RespostaSeguranca = respostaSeguranca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getConfirmarSenha() {
		return confirmarSenha;
	}
	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	public String getRespostaSeguranca() {
		return RespostaSeguranca;
	}
	public void setRespostaSeguranca(String respostaSeguranca) {
		RespostaSeguranca = respostaSeguranca;
	}
	private String senha;
	private String confirmarSenha;
	private String RespostaSeguranca;
	
	
	
	
}
