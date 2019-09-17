package br.com.am.conexao;

import java.sql.Connection;

public class TesteConexao {

	public static void main(String[] args) {
		Connection conectar = null;
		try {
			conectar = Conexao.produtoConexao();
			System.out.println("Conectou");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conectar.close();
				System.out.println("fechando conexao");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
