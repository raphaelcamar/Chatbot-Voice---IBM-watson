package br.com.am.bo;

import br.com.am.dao.AlunoDAO;
import br.com.am.entities.Aluno;

/**
 * Esta classe é responsável por realizar as validações e regras de negócios.
 * 
 * @author André Kancelskis
 * @author Átila Ferreira
 * @author Jhonata Morais
 * @author Raphael Molina
 * @author Raphael Santantonio
 * @see br.com.am.dao.AlunoDAO
 * @see br.com.am.entities.Aluno
 * @version 1.00
 * @since 1.00
 *
 */
public class LoginBO {
	/**
	 * Este método é responsável por validar o login, permitindo que o usuário cadastrado 
	 * no banco de dados possa utilizar o sistema as regras de negócios, verificando o rm e a senha,
	 * retornando um objeto AlunoDAO.
	 * 
	 * @param rm, senha
	 * @return
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
	public Aluno LogarAluno(String rm, String senha) throws Exception {
		return new AlunoDAO().consultarLogin(rm, senha);
	}
}
