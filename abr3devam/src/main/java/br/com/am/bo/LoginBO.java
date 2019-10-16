package br.com.am.bo;

import br.com.am.dao.AlunoDAO;
import br.com.am.entities.Aluno;

public class LoginBO {

	
	public Aluno LogarAluno(String rm, String senha)throws Exception {
		return new AlunoDAO().consultarLogin(rm, senha);
	}
}
