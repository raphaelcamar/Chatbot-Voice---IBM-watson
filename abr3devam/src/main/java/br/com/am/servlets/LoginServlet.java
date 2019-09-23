package br.com.am.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.am.bo.LoginBO;
import br.com.am.dao.CadastroDAO;
import br.com.am.entities.Login;

@WebServlet(urlPatterns = "/logar")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		CadastroDAO dao = null;
		
		String rm = req.getParameter("rm");
		String senha = req.getParameter("senha");
		
		
		try {
			Login l = new LoginBO().validarUser(rm, senha);
			dao = new CadastroDAO();
		
			if(l != null) {
				out.println("Usuário logado");
				out.println(l.getNome());
				HttpSession session = req.getSession();
				session.setAttribute("logado", l);
				session.setAttribute("nomeAluno", l.getNome());
				RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
				dispatcher.forward(req, resp);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Não logou");
		}finally {
			try {
			dao.encerrar();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Não encerrou");
			}
		}
	}
}
