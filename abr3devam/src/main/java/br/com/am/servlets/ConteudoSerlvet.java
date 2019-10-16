package br.com.am.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.am.dao.ConteudoDAO;
import br.com.am.excecoes.Excecao;

@WebServlet(urlPatterns = "/conteudo")
public class ConteudoSerlvet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String valor = req.getParameter("submit");
		int id_conteudo = Integer.parseInt(valor);
		ConteudoDAO dao = null;
		try {
			dao = new ConteudoDAO();

			int cont = dao.retornarContadorMateria(id_conteudo);
			dao.atualizarContadorMateria(cont, id_conteudo);
			RequestDispatcher dispatcher = req.getRequestDispatcher("conteudo.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			new Excecao("Não conseguiu atualizar o contador de acesso");
			new Excecao(e);
		} finally {
			try {
				dao.encerrar();
			} catch (Exception e) {
				new Excecao("Não conseguiu finalizar o banco");
				new Excecao(e);
			}
		}
	}
}
