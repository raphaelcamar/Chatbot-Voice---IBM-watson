package br.com.am.bo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.am.dao.AlunoDAO;
import br.com.am.entities.UserExistente;

public class CadastroBO {

	public boolean validarNome(String nome) {
//		for (int i = 0; i < nome.length(); i++) {
//			if (!Character.isAlphabetic(nome.charAt(i))) {
//				return false;
//			}
//			if (nome.contains(" ")) {
//				return false;
//			}
//		}
		if (nome.length() > 30 || nome.length() < 2) {
			return false;
		}

		if (nome != null && nome.length() > 0) {
			String expression = "/[A-ZÀ-Ÿ][A-zÀ-ÿ']+\\s([A-zÀ-ÿ']\\s?)*[A-ZÀ-Ÿ][A-zÀ-ÿ']+$/";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(nome);
			if (matcher.matches()) {
				return true;
			}
		}

		return true;
	}

	public boolean validarSobrenome(String sobrenome) {
		if (sobrenome != null && sobrenome.length() > 0) {
			String expression = "/[A-ZÀ-Ÿ][A-zÀ-ÿ']+\\s([A-zÀ-ÿ']\\s?)*[A-ZÀ-Ÿ][A-zÀ-ÿ']+$/";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(sobrenome);
			if (matcher.matches()) {
				return true;
			}
		}
		if (sobrenome.length() > 40 || sobrenome.length() < 2) {
			return false;
		}

		return true;
	}

	public boolean validarRM(String rm) {
		for (int i = 0; i < rm.length(); i++) {
			if (!Character.isDigit(rm.charAt(i))) {
				return false;
			}
		}
		if (rm.length() != 5) {
			return false;
		}
		return true;
	}

	public boolean validarRespostaSeguranca(String resposta) {
		if (resposta.length() > 50 || resposta.length() < 2) {
			return false;
		}
		if (resposta.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean validarEmail(String email) {
		if (!email.contains("@") || !email.contains(".")) {
			return false;
		}

		if (email.length() > 60 || email.length() < 7) {
			return false;
		}

		if (email != null && email.length() > 0) {
			String expression = "[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				return true;
			}
		}
		return false;
	}

	public boolean validarSenha(String senha) {
		if (senha.length() > 20 || senha.length() < 6) {
			return false;
		}
		if (senha.isEmpty()) {
			return false;
		}
		for (int i = 0; i < senha.length(); i++) {
			if (Character.isSpaceChar((senha.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

	public UserExistente RmExistente(String rm) throws Exception {
		return new AlunoDAO().VerificarRm(rm);
	}

	public UserExistente EmailExistente(String email) throws Exception {
		return new AlunoDAO().verificarEmail(email);
	}
}
