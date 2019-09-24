package br.com.am.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
		Cadastro c = new Cadastro();
		Rseguranca r = new Rseguranca();

		r.setRseguranca(req.getParameter("rSeguranca"));
		c.setNome(req.getParameter("nome"));
		c.setSobrenome(req.getParameter("sobrenome"));
		c.setEmail(req.getParameter("email"));
		c.setRm(req.getParameter("rm"));
		c.setSenha(req.getParameter("senha"));
	

		CadastroDAO dao = null;
		
		
		try {
			
			ArrayList<String> erro = new ArrayList<String>();
			CadastroBO bo = new CadastroBO();
			dao = new CadastroDAO();

			
			if (bo.validarNome(c.getNome()) == false) {
				erro.add("O nome deverá conter apenas letras");
			}
			if (bo.validarSobrenome(c.getSobrenome()) == false) {
				erro.add("O sobrenome deverá conter apenas letras, ");
			}
			if (bo.validarSenha(c.getSenha()) == false) {
				erro.add("A senha deverá conter APENAS seis (6) caracteres!");
			}
			if (bo.validarEmail(c.getEmail()) == false) {
				erro.add("O e-mail deverá ser válido!");
			}

			if (bo.validarRM(c.getRm()) == false) {
				erro.add("O rm deverá conter APENAS números e conter cinco (5) caracteres");
			}
			if(bo.validarNome(c.getNome()) == true && bo.validarEmail(c.getEmail()) == true && bo.validarRM(c.getRm()) == true && bo.validarSenha(c.getSenha()) == true) {
				dao.adcionarAluno(c);
				dao.adcionarResposta(r);
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);
			}if(bo.validarNome(c.getNome()) == false || bo.validarEmail(c.getEmail()) == false || bo.validarRM(c.getRm()) == false || bo.validarSenha(c.getSenha()) == false) {
				req.setAttribute("erro", erro );
				RequestDispatcher dispatcher = req.getRequestDispatcher("cadastro.jsp");
				dispatcher.forward(req, resp);
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
