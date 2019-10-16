package br.com.am.entities;

public class Materia {

	private int capitulo;
	private String descricao;
	private int contador_acesso;
	private String nomeDisciplina;

	public Materia(int capitulo, String descricao, int contador_acesso, String nomeDisciplina) {
		super();
		this.capitulo = capitulo;
		this.descricao = descricao;
		this.contador_acesso = contador_acesso;
		this.nomeDisciplina = nomeDisciplina;
	}

	public Materia() {
		super();
	}

	public int getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(int capitulo) {
		this.capitulo = capitulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getContador_acesso() {
		return contador_acesso;
	}

	public void setContador_acesso(int contador_acesso) {
		this.contador_acesso = contador_acesso;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
}