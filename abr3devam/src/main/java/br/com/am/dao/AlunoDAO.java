package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.am.conexao.Conexao;
import br.com.am.entities.Aluno;

import br.com.am.entities.Rseguranca;
import br.com.am.entities.UserExistente;

/**
 * Esta classe é responsável por realizar o INSERT e SELECT nas tabelas
 * CHATBOT_ALUNO e CHATBOT_RESPOSTA_SEG. É importante utilizar o método encerrar
 * para fechar conexão com o banco de dados.
 * 
 * @author André Kancelskis
 * @author Átila Ferreira
 * @author Jhonata Morais
 * @author Raphael Molina
 * @author Raphael Santantonio
 * @see br.com.am.conexao.Conexao
 * @see br.com.am.entities.Aluno
 * @see br.com.am.entities.Rseguranca
 * @see br.com.am.entities.UserExistente
 * @version 1.00
 * @since 1.00
 *
 */
public class AlunoDAO {

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
	public AlunoDAO() throws Exception {
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
	 * Neste método por meio do objeto Aluno, guardando na tabela CHATBOT_ALUNO
	 * 
	 * @param c
	 * @return
	 * @throws Exception
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
	public int adcionarAluno(Aluno c) throws Exception {
		stmt = con.prepareStatement("INSERT INTO CHATBOT_ALUNO (ID_ALUNO, NOME, SOBRENOME, SENHA, RM, EMAIL"
				+ ") VALUES(ID_ALUNO_SEQ.nextval, ?,?,?,?,?)");
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getSobrenome());
		stmt.setString(3, c.getSenha());
		stmt.setString(4, c.getRm());
		stmt.setString(5, c.getEmail());

		return stmt.executeUpdate();
	}

	/**
	 * Neste método por meio do objeto Rseguranca, guardando na tabela
	 * CHATBOT_RESPOSTA_SEG
	 * 
	 * @param r
	 * @return
	 * @throws Exception
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
	public int adcionarResposta(Rseguranca r) throws Exception {
		String add2 = ("INSERT INTO CHATBOT_RESPOSTA_SEG (ID_RESPOSTA_SEGURANCA, " + "RESPOSTA_SEGURANCA, ID_ALUNO"
				+ ") VALUES(RESP_SEG_SEQ.nextval, ?, ID_ALUNO_RESP_SEQ.nextval)");

		stmt = con.prepareStatement(add2);
		stmt.setString(1, r.getRseguranca().toUpperCase());
		return stmt.executeUpdate();
	}

	/**
	 * Este método está verificando se está cadastrado o rm, selecionando na tabela
	 * CHATBOT_ALUNO
	 * 
	 * @param rm
	 * @return ue
	 * @throws Exception
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
	public UserExistente VerificarRm(String rm) throws Exception {
		UserExistente ue = null;

		stmt = con.prepareStatement("SELECT * FROM CHATBOT_ALUNO WHERE RM =?");
		stmt.setString(1, rm);
		rs = stmt.executeQuery();

		if (rs.next()) {
			String rm2 = rs.getString("RM");
			String email2 = rs.getString("EMAIL");
			ue = new UserExistente(rm2, email2);
		}
		return ue;
	}

	/**
	 * Este método está verificando se está cadastrado o email, selecionando na
	 * tabela CHATBOT_ALUNO
	 * 
	 * @param email
	 * @return ue
	 * @throws Exception
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
	public UserExistente verificarEmail(String email) throws Exception {
		UserExistente ue = null;
		stmt = con.prepareStatement("SELECT * FROM CHATBOT_ALUNO WHERE EMAIL =?");
		stmt.setString(1, email);
		rs = stmt.executeQuery();

		if (rs.next()) {
			String email2 = rs.getString("EMAIL");
			String rm = rs.getString("RM");
			ue = new UserExistente(rm, email2);
		}
		return ue;
	}

	/**
	 * Este método está consultando o aluno por rm e senha, selecionando na tabela
	 * CHATBOT_ALUNO, retornando um objeto Aluno.
	 * 
	 * @param rm, senha
	 * @return a
	 * @throws Exception
	 * @author André Kancelskis
	 * @author Átila Ferreira
	 * @author Jhonata Morais
	 * @author Raphael Molina
	 * @author Raphael Santantonio
	 * @version 1.00
	 */
	public Aluno consultarLogin(String rm, String senha) throws Exception {
		Aluno a = null;
		stmt = con.prepareStatement("SELECT * FROM CHATBOT_ALUNO WHERE RM = ? AND SENHA = ?");
		stmt.setString(1, rm);
		stmt.setString(2, senha);

		rs = stmt.executeQuery();
		if (rs.next()) {
			int id = rs.getInt("ID_ALUNO");
			String nome = rs.getString("NOME");
			String sobrenome = rs.getString("SOBRENOME");
			String rmL = rs.getString("RM");
			String email = rs.getString("EMAIL");
			String senhaL = rs.getString("SENHA");
			a = new Aluno(id, nome, sobrenome, rmL, email, senhaL, null);
		}
		return a;
	}

}
