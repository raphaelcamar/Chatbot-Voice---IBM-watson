package br.com.am.excecoes;

public class Excecao extends Exception {

	private static final long serialVersionUID = 1L;

	public Excecao(Exception e) {
		e.printStackTrace();
		System.out.println(e.getClass().toString());
	}

	public Excecao(String mensagem) {
		System.out.println(mensagem);
	}
}
