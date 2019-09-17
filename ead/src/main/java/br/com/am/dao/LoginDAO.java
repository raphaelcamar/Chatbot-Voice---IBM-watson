package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.am.conexao.Conexao;

public class LoginDAO {

	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	public LoginDAO()throws Exception{
		con = Conexao.produtoConexao();
	}
	
	public boolean verificarLogin(String rm, String senha)throws Exception {
		stmt = con.prepareStatement(
				"SELECT RM, SENHA FROM AM_USUARIO where RM=? and SENHA =?");
		stmt.setString(1, rm);
		stmt.setString(2, senha);
		rs = stmt.executeQuery();
		do {
			if(rm.equals("RM") && senha.equals("SENHA")) {
				return true;
			}else {
				return false;
			}
		}while(rs.next());
	}
	public void Encerrar() throws Exception{
		con.close();
	}
}
