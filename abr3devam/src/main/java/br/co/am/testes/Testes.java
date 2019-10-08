package br.co.am.testes;
import br.com.am.bo.CadastroBO;
import br.com.am.dao.RecuperarSenhaDAO;

public class Testes {

	public static void main(String[] args) {
		
		RecuperarSenhaDAO rsenha = null;
		try {
			 rsenha = new RecuperarSenhaDAO();
			CadastroBO bo = new CadastroBO();
			
			String retorno = rsenha.retornarRSeguranca("andre@gmail.com");
			//System.out.println(retorno);
//			if(retorno.equalsIgnoreCase("mumia")) {
//				System.out.println(retorno);
//				System.out.println(rsenha.retornaID("andraae@gmail.com"));
//			 boolean result = true;
	       	
//			}else {
//				System.out.println("n");
//			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				rsenha.encerrar();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	}

}
