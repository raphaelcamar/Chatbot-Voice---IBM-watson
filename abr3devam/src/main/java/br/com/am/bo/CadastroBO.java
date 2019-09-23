package br.com.am.bo;

public class CadastroBO {

	
	public boolean validarNome(String nome) {
		//não deixar o usuário digitar caracter especial
		for (int i = 0; i < nome.length(); i++) {
			if(!Character.isAlphabetic(nome.charAt(i))) {
				return false;
			}
		}
		//não deixa ultrapassar o tamanho do banco
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
		if(!email.contains("@")) {
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
}