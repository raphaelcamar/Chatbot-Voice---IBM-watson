package br.com.am.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.am.dao.LoginDAO;
import br.com.am.entities.Login;

@WebServlet(urlPatterns = "/logar")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				PrintWriter out = resp.getWriter();
		LoginDAO logindao = null;
		Login login = new Login();
		login.setRm(req.getParameter("rm"));
		login.setSenha(req.getParameter("senha"));
		
		try {
			logindao = new LoginDAO();
			if(logindao.verificarLogin(login.getRm(), login.getSenha()) == true) {
				//resp.sendRedirect("index.html");
					//adcionar cookies e session
				out.println("Logado com sucesso!");
			}else {
				//código
				out.println();
				out.println("não logou");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			
			try {
				logindao.Encerrar();

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
