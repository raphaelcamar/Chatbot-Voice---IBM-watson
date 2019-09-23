package br.com.am.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.am.bo.CadastroBO;
import br.com.am.dao.CadastroDAO;
import br.com.am.entities.Cadastro;
import br.com.am.entities.Rseguranca;

@WebServlet(urlPatterns = "/cadastrar")
public class CadastroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		Cadastro c = new Cadastro();
		Rseguranca r = new Rseguranca();

		r.setRseguranca(req.getParameter("rSeguranca"));
		c.setNome(req.getParameter("nome"));
		c.setSobrenome(req.getParameter("sobrenome"));
		c.setEmail(req.getParameter("email"));
		c.setRm(req.getParameter("rm"));
		c.setSenha(req.getParameter("senha"));
	

		CadastroDAO dao = null;
		
		out.println("Você está na servlet certa");
		try {
			CadastroBO bo = new CadastroBO();
			dao = new CadastroDAO();

			
			if (bo.validarNome(c.getNome()) == false) {
				out.println("Nome incorreto!");
			}
			if (bo.validarSobrenome(c.getSobrenome()) == false) {
				out.println("Sobrenome incorreto!");
			}
			if (bo.validarSenha(c.getSenha()) == false) {
				out.println("Senha inválida!");
			}
			if (bo.validarEmail(c.getEmail()) == false) {
				out.println("E-mail incorreto!");
			}

			if (bo.validarRM(c.getRm()) == false) {
				out.println("Rm incorreto!");
			}
			if(bo.validarNome(c.getNome()) == true && bo.validarEmail(c.getEmail()) == true && bo.validarRM(c.getRm()) == true && bo.validarSenha(c.getSenha()) == true) {
				dao.adcionarAluno(c);
				dao.adcionarResposta(r);
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		System.out.println("não guardou no banco");
		} finally {
			try {
				dao.encerrar();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("não conseguiu encerrar!");
			}
 		}

	}
}
