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




	public int adcionar(Cadastro c)throws Exception {
		pstmt = con.prepareStatement
				("INSERT INTO AM_USUARIO (ID_USUARIO, NOME,SOBRENOME,EMAIL, RM, SENHA, RESPOSTASEGURANCA"+
	") VALUES(cadastro_seq.nextval, ?,?,?,?,?,?)");
		//pstmt.setInt(1, cadastro_seq.intValue);
		pstmt.setString(1, c.getNome());
		pstmt.setString(2, c.getSobrenome());
		pstmt.setString(3, c.getEmail());
		pstmt.setString(4, c.getRm());
		pstmt.setString(5, c.getSenha());
		pstmt.setString(6, c.getRespostaSeguranca());
		return pstmt.executeUpdate();	
	}
	
	
	public boolean verificarCadastroExistente(String rm)throws Exception {
		pstmt = con.prepareStatement
				("SELECT RM FROM AM_USUARIO where RM = ?");
		pstmt.setString(1, rm);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("RM").equals(rm)) {
					return false;
				}
			}
			return true;
	}
	public void Encerrar() throws Exception{
		con.close();
	}
}
