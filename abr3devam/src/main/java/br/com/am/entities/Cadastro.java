package br.com.am.entities;

public class Cadastro {

	private int id_aluno;
	private String nome;
	private String sobrenome;
	private String senha;
	private String rm;
	private String email;

	public Cadastro(int id_aluno, String nome, String sobrenome, String senha, String rm, String email) {
		super();
		this.id_aluno = id_aluno;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.senha = senha;
		this.rm = rm;
		this.email = email;
	}

	public Cadastro() {
		super();
	}

	public int getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
