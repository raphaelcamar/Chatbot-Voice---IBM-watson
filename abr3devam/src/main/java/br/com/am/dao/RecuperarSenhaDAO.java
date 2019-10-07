package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.am.conexao.Conexao;
import br.com.am.entities.Rseguranca;

public class RecuperarSenhaDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	public RecuperarSenhaDAO()throws Exception{
		con = Conexao.produtoConexao();
	}
	
	public void encerrar()throws Exception{
		con.close();
	}
	
	public String retornarRSeguranca(String email)throws Exception{
		String resposta = null;
		stmt = con.prepareStatement("select RESPOSTA_SEGURANCA from CHATBOT_RESPOSTA_SEG "
				+ "crs join CHATBOT_ALUNO ca on crs.ID_RESPOSTA_SEGURANCA = ca.ID_ALUNO AND ca.email = ?");
				stmt.setString(1, email);
			
				rs = stmt.executeQuery();
				
				if(rs.next()) {
					resposta = rs.getString("RESPOSTA_SEGURANCA");
				}
				return resposta;
		}
	
	public int retornaID(String email)throws Exception{
		int id = -1;
			stmt = con.prepareStatement("SELECT ID_ALUNO FROM CHATBOT_ALUNO WHERE email=?");
				stmt.setString(1, email);
					rs = stmt.executeQuery();
					if(rs.next()) {
						id = rs.getInt("ID_ALUNO");
					}
					return id;
	}
	
	public void novaSenha(int id, String senha)throws Exception{
		stmt = con.prepareStatement("UPDATE CHATBOT_ALUNO set SENHA = ?  where ID_ALUNO=?");
		
		stmt.setString(1, senha);
			stmt.setInt(2, id);
				stmt.execute();
	}
	
	
	
	
}
