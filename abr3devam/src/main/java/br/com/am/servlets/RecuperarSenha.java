package br.com.am.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.am.bo.CadastroBO;
import br.com.am.dao.RecuperarSenhaDAO;
import br.com.am.excecoes.Excecao;

@WebServlet(urlPatterns = "/recuperarSenha")
public class RecuperarSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String filme = req.getParameter("filme").toUpperCase();
		String email = req.getParameter("email").toUpperCase();
		String novaSenha = req.getParameter("novaSenha").toUpperCase();
		ArrayList<String> erros = new ArrayList<String>();

		RecuperarSenhaDAO rsenha = null;

		try {
			rsenha = new RecuperarSenhaDAO();
			int id = rsenha.retornaID(email);
			CadastroBO bo = new CadastroBO();

			String retorno = rsenha.retornarRSeguranca(email);
			if (retorno == null) {
				erros.add("E-mail não cadastrado!");
			} else if (retorno.equalsIgnoreCase(filme)) {
				if (bo.validarSenha(novaSenha) == false) {
					erros.add("Senha incorreta");
				} else {
					rsenha.novaSenha(id, novaSenha);
					String msg = "Mudado com sucesso!";
					req.setAttribute("valor", msg);
					RequestDispatcher dispatcher = req.getRequestDispatcher("recuperarSenha.jsp");
					dispatcher.forward(req, resp);
				}

			} else {
				erros.add("e-mail ou resposta incorreta! Digite novamente");
			}
			req.setAttribute("erro", erros);
			RequestDispatcher dispatcher = req.getRequestDispatcher("recuperarSenha.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			new Excecao("O processo de recuperação de senha não foi completo.");
			new Excecao(e);
			System.out.println("O processo de recuperação de senha não foi completo.");
		} finally {
			try {
				rsenha.encerrar();
			} catch (Exception e) {
				new Excecao("Banco não encerrado");
				new Excecao(e);
			}
		}
	}
}
