package br.com.am.bo;

import br.com.am.dao.CadastroDAO;
import br.com.am.entities.Cadastro;
import br.com.am.entities.Login;

public class CadastroBO {

	
	public boolean validarNome(String nome) {

		for (int i = 0; i < nome.length(); i++) {
			if(!Character.isAlphabetic(nome.charAt(i))) {
				return false;
			}
		}
		if(nome.length() > 30) {
			return false;
		}
		return true;
	}
	
	
	public boolean validarSobrenome(String sobrenome) {
		for (int i = 0; i < sobrenome.length(); i++) {
			if(!Character.isAlphabetic(sobrenome.charAt(i))) {
				return false;
			}
		}
		//não deixar ultrapassar o tamanho do banco
		if(sobrenome.length() > 40){
			return false;
			}
		return true;
		}
	
	public boolean validarRM(String rm) {
		for (int i = 0; i < rm.length(); i++) {
			if(!Character.isDigit(rm.charAt(i))) {
				return false;
			}
		}
		if(rm.length() > 5) {
			return false;
		}
		return true;
	}
	
	public boolean validarRespostaSeguranca(String resposta) {
		if(resposta.length() > 50) {
			return false;
		}
		return true;
	}
	
	public boolean validarEmail(String email) {
		if(!email.contains("@") || !email.contains(".")) {
			return false;
		}
		
		if(email.length()>60) {
			return false;
		}
		return true;
	}
	
	public boolean validarSenha(String senha) {
		if(senha.length() > 6) {
			return false;
		}
		return true;
	}
	
	public Login validarLogin(String rm, String senha)throws Exception {
		return new CadastroDAO().consultarUser(rm, senha);
	}
}
