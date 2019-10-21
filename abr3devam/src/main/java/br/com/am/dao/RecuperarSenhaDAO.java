package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.am.conexao.Conexao;

/**
 * Esta classe é responsável por realizar o SELECT e UPDATE nas tabelas
 * CHATBOT_ALUNO e CHATBOT_RESPOSTA_SEG. É importante utilizar o método encerrar
 * para fechar conexão com o banco de dados.
 * 
 * @author André Kancelskis
 * @author Átila Ferreira
 * @author Jhonata Morais
 * @author Raphael Molina
 * @author Raphael Santantonio
 * @see br.com.am.conexao.Conexao
 * @version 1.00
 * @since 1.00
 *
 */
public class RecuperarSenhaDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * O método construtor é responsável por abrir a conexão
	 * 
	 * @throws Exception
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
	public RecuperarSenhaDAO() throws Exception {
		con = Conexao.produtoConexao();
	}

	/**
	 * Esse método é responsável por fechar a conexão
	 * 
	 * @throws Exception
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
	public void encerrar() throws Exception {
		con.close();
	}

	/**
	 * Este método está retornando a resposta de segurança, utilizando o email do
	 * aluno, selecionando nas tabelas CHATBOT_ALUNO e CHATBOT_RESPOSTA_SEG
	 * 
	 * @param email
	 * @return resposta
	 * @throws Exception
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
	public String retornarRSeguranca(String email) throws Exception {
		String resposta = null;
		stmt = con.prepareStatement("SELECT RESPOSTA_SEGURANCA FROM CHATBOT_RESPOSTA_SEG "
				+ "crs join CHATBOT_ALUNO ca on crs.ID_RESPOSTA_SEGURANCA = ca.ID_ALUNO AND ca.email = ?");
		stmt.setString(1, email);
		rs = stmt.executeQuery();
		if (rs.next()) {
			resposta = rs.getString("RESPOSTA_SEGURANCA");
		}
		return resposta;
	}

	/**
	 * Este método está retornando o id, utilizando o email do aluno, selecionando
	 * na tabela CHATBOT_ALUNO
	 * 
	 * @param email
	 * @return id
	 * @throws Exception
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
	public int retornaID(String email) throws Exception {
		int id = -1;
		stmt = con.prepareStatement("SELECT ID_ALUNO FROM CHATBOT_ALUNO WHERE email=?");
		stmt.setString(1, email);
		rs = stmt.executeQuery();
		if (rs.next()) {
			id = rs.getInt("ID_ALUNO");
		}
		return id;
	}

	/**
	 * Este método está atualizando a senha do aluno na tabela CHATBOT_ALUNO
	 * 
	 * @param id, senha
	 * @return
	 * @throws Exception
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
	public void novaSenha(int id, String senha) throws Exception {
		stmt = con.prepareStatement("UPDATE CHATBOT_ALUNO set SENHA = ?  where ID_ALUNO=?");
		stmt.setString(1, senha);
		stmt.setInt(2, id);
		stmt.execute();
	}
}