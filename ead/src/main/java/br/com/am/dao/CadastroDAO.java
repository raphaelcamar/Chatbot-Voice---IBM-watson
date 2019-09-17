package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.am.conexao.Conexao;
import br.com.am.entities.Cadastro;

public class CadastroDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public CadastroDAO()throws Exception{
		con = Conexao.produtoConexao();
	}
	
	//gerar ID para o banco
	private static int ident = 1;
	public int gerarID() {
		return ident++;
	}
	
	public int adcionar(Cadastro c)throws Exception {
		pstmt = con.prepareStatement
				("INSERT INTO AM_USUARIO (ID_USUARIO, NOME,SOBRENOME,EMAIL, RM, SENHA, RESPOSTASEGURANCA"+
	") VALUES(?,?,?,?,?,?,?)");
		pstmt.setInt(1, gerarID());
		pstmt.setString(2, c.getNome());
		pstmt.setString(3, c.getSobrenome());
		pstmt.setString(4, c.getEmail());
		pstmt.setString(5, c.getRm());
		pstmt.setString(6, c.getSenha());
		pstmt.setString(7, c.getRespostaSeguranca());
		return pstmt.executeUpdate();	
	}
	
	
	public boolean verificarCadastroExistente(String rm)throws Exception {
		pstmt = con.prepareStatement
				("SELECT RM FROM AM_USUARIO where RM = ?");
		pstmt.setString(1, rm);
			rs = pstmt.executeQuery();
			do {
				if(rm.equals(rs.getString("RM"))) {
					return false;
				}
			}while(rs.next());
			return true;
	}
	public void Encerrar() throws Exception{
		con.close();
	}
}
