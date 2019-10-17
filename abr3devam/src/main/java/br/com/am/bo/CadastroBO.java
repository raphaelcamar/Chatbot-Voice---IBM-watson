package br.com.am.bo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.am.dao.AlunoDAO;
import br.com.am.entities.UserExistente;

/**
 * Esta classe é responsável por realizar as validações e regras de negócios.
 * 
 * @author André Kancelskis
 * @author Átila Ferreira
 * @author Jhonata Morais
 * @author Raphael Molina
 * @author Raphael Santantonio
 * @see br.com.am.dao.AlunoDAO
 * @see br.com.am.entities.UserExistente
 * @version 1.00
 * @since 1.00
 *
 */
public class CadastroBO {
	/**
	 * Este método é resposável para validar o nome de acordo com as regras de
	 * negócios, verificando o tamanho dele, se está vazio e se possui somente
	 * letras sem nenhum caractere especial, retornando true ou false.
	 * 
	 * @param nome
	 * @return
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
	public boolean validarNome(String nome) {

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

	/**
	 * Este método é resposável para validar o sobrenome de acordo com as regras de
	 * negócios, verificando o tamanho dele, se está vazio e se possui somente
	 * letras sem nenhum caractere especial, retornando true ou false.
	 * 
	 * @param sobrenome
	 * @return
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
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
	/**
	 * Este método é resposável para validar o rm de acordo com as regras de
	 * negócios, verificando o tamanho dele e se possui somente números, retornando true ou false.
	 * 
	 * @param rm
	 * @return
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
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
	/**
	 * Este método é resposável para validar a resposta de segurança de acordo com as regras de
	 * negócios, verificando o tamanho dele e se está vazio, retornando true ou false.
	 * 
	 * @param resposta
	 * @return
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
	public boolean validarRespostaSeguranca(String resposta) {
		if (resposta.length() > 50 || resposta.length() < 2) {
			return false;
		}
		if (resposta.isEmpty()) {
			return false;
		}
		return true;
	}
	/**
	 * Este método é resposável para validar o email de acordo com as regras de
	 * negócios, verificando se existe a estrutura padrão de email, com ("@" e "."), nesta ordem, 
	 * o tamanho dele e se possui alguns caracteres especiais e números, retornando true ou false.
	 * 
	 * @param email
	 * @return
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
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
	/**
	 * Este método é resposável para validar a senha de acordo com as regras de
	 * negócios, verificando o tamanho dele, se está vazio e se ele é um unicode space character, 
	 * retornando true ou false.
	 * 
	 * @param senha
	 * @return
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
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
	/**
	 * Este método é responsável por verificar se já existe o rm cadastrado no banco de dados, 
	 * retornando um objeto AlunoDAO.
	 * 
	 * @param rm
	 * @return
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
	public UserExistente RmExistente(String rm) throws Exception {
		return new AlunoDAO().VerificarRm(rm);
	}
	/**
	 * Este método é responsável por verificar se já existe o email cadastrado no banco de dados, 
	 * retornando um objeto AlunoDAO.
	 * 
	 * @param email
	 * @return
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
	public UserExistente EmailExistente(String email) throws Exception {
		return new AlunoDAO().verificarEmail(email);
	}
}
