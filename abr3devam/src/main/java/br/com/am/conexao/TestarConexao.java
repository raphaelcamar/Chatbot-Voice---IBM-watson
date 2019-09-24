package br.com.am.conexao;

import java.sql.Connection;

public class TestarConexao {

	public static void main(String[] args) {
		Connection produtoConexao = null;
		
		try {
			produtoConexao = Conexao.produtoConexao();
			System.out.println("Conectou");
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				produtoConexao.close();
				System.out.println("Fechando conexao");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
