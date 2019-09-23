package br.com.am.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection produtoConexao() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm83088", "140399");
	}
}
