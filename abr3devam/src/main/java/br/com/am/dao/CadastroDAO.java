package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.am.conexao.Conexao;
import br.com.am.entities.Cadastro;
import br.com.am.entities.Login;
import br.com.am.entities.Rseguranca;

public class CadastroDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public CadastroDAO()throws Exception{
		con = Conexao.produtoConexao();
	}
	
	public void encerrar()throws Exception{
		con.close();
	}
	
	public int adcionarAluno(Cadastro c)throws Exception {
		stmt = con.prepareStatement("INSERT INTO CHATBOT_ALUNO (ID_ALUNO,NOME, SOBRENOME, SENHA, RM, EMAIL"+
				") VALUES(ID_ALUNO_SEQ.nextval, ?,?,?,?,?)");
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getSobrenome());
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
