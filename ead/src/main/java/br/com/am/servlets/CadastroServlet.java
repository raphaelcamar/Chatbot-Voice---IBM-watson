package br.com.am.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.am.dao.CadastroDAO;
import br.com.am.entities.Cadastro;

@WebServlet(urlPatterns = "/cadastrar")
public class CadastroServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CadastroDAO dao;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Cadastro c = new Cadastro();
		
		c.setNome(req.getParameter("nome"));
		c.setSobrenome(req.getParameter("sobrenome"));
		c.setEmail(req.getParameter("email"));
		c.setRm(req.getParameter("rm"));
		c.setSenha(req.getParameter("senha"));
		c.setRespostaSeguranca(req.getParameter("perguntaSeguranca"));
		CadastroDAO dao = null;
	
		try {
			dao = new CadastroDAO();
				dao.adcionar(c);
		}catch (Exception e) {
			e.printStackTrace();
		System.out.println("Não guardou no banco");
		}finally{
			try {
				dao.Encerrar();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Não encerrou");
			}
		}
	}
}
