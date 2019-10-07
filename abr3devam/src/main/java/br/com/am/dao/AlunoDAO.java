package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.am.conexao.Conexao;
import br.com.am.entities.Cadastro;
import br.com.am.entities.Rseguranca;
import br.com.am.entities.UserExistente;

public class AlunoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	
	public AlunoDAO()throws Exception{
		con = Conexao.produtoConexao();
	}
	
	public void encerrar()throws Exception{
		con.close();
	}
	
	public int adcionarAluno(Cadastro c)throws Exception {
		stmt = con.prepareStatement("INSERT INTO CHATBOT_ALUNO (ID_ALUNO,NOME, SOBRENOME, SENHA, RM, EMAIL"+
				") VALUES(ID_ALUNO_SEQ.nextval, ?,?,?,?,?)");
		stmt.setString(1, c.getNome().toUpperCase());
		stmt.setString(2, c.getSobrenome().toUpperCase());
		stmt.setString(3, c.getSenha());
		stmt.setString(4, c.getRm());
		stmt.setString(5, c.getEmail());
		
		return stmt.executeUpdate();
	}
	public int adcionarResposta(Rseguranca r)throws Exception{
		String add2 =("INSERT INTO CHATBOT_RESPOSTA_SEG (ID_RESPOSTA_SEGURANCA, "
				+ "RESPOSTA_SEGURANCA, ID_ALUNO" + ") VALUES(RESP_SEG_SEQ.nextval, ?, ID_ALUNO_RESP_SEQ.nextval)");
		
		stmt = con.prepareStatement(add2);
		stmt.setString(1, r.getRseguranca());
		return stmt.executeUpdate();
		
	}
	
	public UserExistente VerificarRm(String rm)throws Exception {
		UserExistente ue = null;
		
		stmt= con.prepareStatement("SELECT * FROM CHATBOT_ALUNO WHERE RM =?");
		
		stmt.setString(1, rm);
		
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			String rm2 = rs.getString("RM");
			String email2 = rs.getString("EMAIL");
			 ue = new UserExistente(rm2, email2);
		}
		
		return ue;
	}
	
	public UserExistente verificarEmail(String email)throws Exception{
		UserExistente ue = null;
		stmt = con.prepareStatement("SELECT * FROM CHATBOT_ALUNO WHERE EMAIL =?");
		stmt.setString(1, email);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			String email2 = rs.getString("EMAIL");
			String rm = rs.getString("RM");
			ue = new UserExistente(rm, email2);
			
		}
		return ue;
	}
	
	
	
}
