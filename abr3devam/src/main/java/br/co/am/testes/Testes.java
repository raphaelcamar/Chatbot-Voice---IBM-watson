package br.co.am.testes;
import br.com.am.dao.ConteudoDAO;

public class Testes {

	public static void main(String[] args) {
		
		ConteudoDAO dao = null;
		try {
			dao = new ConteudoDAO();
			int cont = dao.retornarContadorMateria("PORTUGUES");
			System.out.println(cont);
			
			System.out.println(cont);
			dao.contadorMateria(cont, "PORTUGUES");
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
