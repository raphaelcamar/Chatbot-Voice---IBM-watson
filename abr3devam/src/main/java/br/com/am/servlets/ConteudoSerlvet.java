package br.com.am.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.am.dao.ConteudoDAO;


@WebServlet(urlPatterns = "/conteudo")
public class ConteudoSerlvet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String valor = req.getParameter("submit");
		String materia = req.getParameter("materia");
		ConteudoDAO dao = null;
		try {
			int v = Integer.parseInt(materia);
			System.out.println(materia);
			int idCapitulo = Integer.parseInt(valor);
				dao = new ConteudoDAO();
				int contador = dao.ContadorMateria(idCapitulo, v);
				dao.atualizarContadorMateria(contador, idCapitulo);
				RequestDispatcher dispatcher = req.getRequestDispatcher("conteudo.jsp");
				dispatcher.forward(req, resp);
					
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				dao.encerrar();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
