package br.com.am.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.am.bo.LoginBO;
import br.com.am.dao.AlunoDAO;
import br.com.am.dao.ConteudoDAO;
import br.com.am.entities.Disciplina;
import br.com.am.entities.Login;
import br.com.am.entities.Materia;

@WebServlet(urlPatterns = "/logar")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

		AlunoDAO dao = null;
		ConteudoDAO contdao = null;
		RequestDispatcher dispatcher;

		String rm = req.getParameter("rm").toUpperCase();
		String senha = req.getParameter("senha").toUpperCase();

		
		try {
			
			if(rm.equals( "12345") && senha.equals("123456")) {
				contdao = new ConteudoDAO();
				req.setAttribute("ListaDisciplina", contdao.consultarEntradasConteudo());
					req.setAttribute("ListaMateria", contdao.consultarEntradasDisciplina());
					dispatcher = req.getRequestDispatcher("adm.jsp");
						dispatcher.forward(req, resp);
				
			}else {
			Login l = new LoginBO().validarUser(rm, senha);
			dao = new AlunoDAO();
			String erro = "";

			if (l != null) {
				HttpSession session = req.getSession();
				session.setAttribute("logado", l);
					session.setAttribute("nomeAluno", l.getNome());
						dispatcher =  req.getRequestDispatcher("index.jsp");
							dispatcher.forward(req, resp);
			} else {
				erro = "erro";
				HttpSession session2 = req.getSession();
				session2.setAttribute("erroLogin", erro);
				dispatcher = req.getRequestDispatcher("login.jsp");
					dispatcher.forward(req, resp);
						dispatcher = req.getRequestDispatcher("conteudo.jsp");
							dispatcher = req.getRequestDispatcher("portugues.jsp");
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
				System.out.println("O usuário não foi logado");
				
		} finally {
			try {
				contdao.encerrar();
				
			} catch (Exception e) {
				e.printStackTrace();
					System.out.println("O banco não foi encerrado");
			}
		}
	}
}
