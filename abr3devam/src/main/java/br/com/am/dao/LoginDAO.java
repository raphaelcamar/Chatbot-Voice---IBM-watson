package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.am.conexao.Conexao;
import br.com.am.entities.Login;

public class LoginDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public LoginDAO()throws Exception{
		con = Conexao.produtoConexao();
	}
	
	public Login consultarUser(String rm, String senha)throws Exception {
		Login l = null;
		stmt = con.prepareStatement("SELECT * FROM CHATBOT_ALUNO WHERE RM = ? AND SENHA = ?");
		
		stmt.setString(1, rm);
		stmt.setString(2, senha);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			String rmL = rs.getString("RM");
			String senhaL = rs.getString("SENHA");
			String nome = rs.getString("NOME");
			l = new Login(rmL, senhaL, nome);
		}
		return l;
	}

}
