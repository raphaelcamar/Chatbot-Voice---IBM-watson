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
	
//	public Rseguranca recuperarSenha(String rm, String resposta)throws Exception{
//		
//		stmt= con.prepareStatement("select )";
//	}
	
	
	
}
