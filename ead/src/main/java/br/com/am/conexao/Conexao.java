package br.com.am.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	
	public static Connection produtoConexao() throws Exception{
		return DriverManager.getConnection("//");
	}
}
