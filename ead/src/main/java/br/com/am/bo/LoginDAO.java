package br.com.am.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.am.conexao.Conexao;

public class LoginDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public LoginDAO() throws Exception{
		con = Conexao.produtoConexao();
	}
	
	
	public boolean verificarLogin(String rm, String senha) throws Exception {
		pstmt = con.prepareStatement("select rm, senha from AM_USUARIO where rm =? and senha =?");
		pstmt.setString(1, rm);
		pstmt.setString(2, senha);
		rs = pstmt.executeQuery();
		if(rs != null) {
			while(rs.next()) {
				if(rm.equals(rs.getString("rm")) && senha.equals(rs.getString("senha"))) {
					return true;
				}
			}
	}
		return false;
	}
	
}
