package br.co.am.testes;

import br.com.am.bo.CadastroBO;
import br.com.am.dao.CadastroDAO;

public class Testes {

	public static void main(String[] args) {
		
		CadastroDAO dao = null;
		try {
			dao = new CadastroDAO();
			
			CadastroBO bo = new CadastroBO();
			bo.RmExistente("83088", "raphaelcamar@outlook.com");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				dao.encerrar();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	}

}
