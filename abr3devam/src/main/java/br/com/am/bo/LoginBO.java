package br.com.am.bo;

import br.com.am.dao.CadastroDAO;
import br.com.am.entities.Login;

public class LoginBO {

	
	public Login validarUser(String rm, String senha)throws Exception {
		return new CadastroDAO().consultarUser(rm, senha );
	}
}
