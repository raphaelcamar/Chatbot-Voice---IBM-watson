package br.com.am.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.co.am.excecoes.Excecao;
import br.com.am.bo.LoginBO;
import br.com.am.dao.AlunoDAO;
import br.com.am.dao.ConteudoDAO;
import br.com.am.entities.Login;

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

		if(rm.equals( "12345") && senha.equals("123456")) {
		try {
			contdao = new ConteudoDAO();
				req.setAttribute("ListaDisciplina", contdao.consultarEntradasConteudo());
					req.setAttribute("ListaMateria", contdao.consultarEntradasDisciplina());
						req.setAttribute("ListaAluno", contdao.consultarAlunos());
							HttpSession sessaoAdm = req.getSession();
								Login l = new Login("12345", "123456", "Administrador");
								sessaoAdm.setAttribute("logado", l);
								sessaoAdm.setAttribute("nomeAluno", l.getNome());
						dispatcher = req.getRequestDispatcher("adm.jsp");
							dispatcher.forward(req, resp);
		}catch(Exception e) {
			new Excecao("ADM não conseguiu logar");
			new Excecao(e);
		}finally {
			try {
				contdao.encerrar();
			}catch(Exception e){
				new Excecao("O banco não foi encerrado");
				new Excecao(e);
			}
		}
		}else {
			try {
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
				req.setAttribute("erroLogin", erro);
				dispatcher = req.getRequestDispatcher("login.jsp");
					dispatcher.forward(req, resp);
						dispatcher = req.getRequestDispatcher("conteudo.jsp");
							dispatcher = req.getRequestDispatcher("portugues.jsp");
			}
		
		} catch (Exception e) {
			new Excecao("O usuário não foi logado");
			new Excecao(e);
				
		} finally {
			try {
				dao.encerrar();
			} catch (Exception e) {
				new Excecao("O banco não foi encerrado");
				new Excecao(e);
			}
		}
	}
	}
}
