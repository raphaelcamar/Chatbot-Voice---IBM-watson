package br.com.am.entities;

public class Disciplina {

	private String nome;
	private int id_disciplina;
	private int contador_de_acesso;

	public Disciplina(String nome, int id_disciplina, int contador_de_acesso) {
		super();
		this.nome = nome;
		this.id_disciplina = id_disciplina;
		this.contador_de_acesso = contador_de_acesso;
	}

	public Disciplina() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId_disciplina() {
		return id_disciplina;
	}

	public void setId_disciplina(int id_disciplina) {
		this.id_disciplina = id_disciplina;
	}

	public int getContador_de_acesso() {
		return contador_de_acesso;
	}

	public void setContador_de_acesso(int contador_de_acesso) {
		this.contador_de_acesso = contador_de_acesso;
	}

}
