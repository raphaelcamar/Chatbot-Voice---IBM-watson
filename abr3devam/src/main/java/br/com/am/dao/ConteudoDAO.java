package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.am.conexao.Conexao;
import br.com.am.entities.Aluno;
import br.com.am.entities.Disciplina;
import br.com.am.entities.Materia;
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
 * @see br.com.am.entities.Aluno
 * @see br.com.am.entities.Disciplina
 * @see br.com.am.entities.Materia
 * @version 1.00
 * @since 1.00
 *
 */
public class ConteudoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ConteudoDAO() throws Exception{
		con = Conexao.produtoConexao();
	}
	
	public void encerrar() throws Exception {
		con.close();
	}
	
	public int retornarContadorDisciplina(int disciplina)throws Exception{
		int cont = -1;
		stmt = con.prepareStatement("SELECT CONTADOR_DE_ACESSO FROM DISCIPLINA where ID_DISCIPLINA =?");
			stmt.setInt(1, disciplina);
				rs = stmt.executeQuery();
					if(rs.next()) {
							int contM = rs.getInt("CONTADOR_DE_ACESSO");
					cont = contM;
			}
				return cont;
	}
	
	public int atualizarcontadorDisciplina(int cont, int disciplina)throws Exception{
		cont += 1;
		stmt = con.prepareStatement("UPDATE DISCIPLINA SET CONTADOR_DE_ACESSO =? where ID_DISCIPLINA=?");
			stmt.setInt(1, cont);
			stmt.setInt(2, disciplina);
			
		return stmt.executeUpdate();
	}

	public int retornarContadorMateria(int id)throws Exception{
		int cont = -1;
		
		stmt = con.prepareStatement("SELECT CONTADOR_DE_ACESSO FROM MATERIA WHERE ID_MATERIA=?");
		
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		
	if(rs.next()) {
		cont = rs.getInt("CONTADOR_DE_ACESSO");
	}
	return cont;
	}
	
	public int atualizarContadorMateria(int contador, int idM)throws Exception{
		contador +=1;
		stmt = con.prepareStatement("UPDATE MATERIA SET CONTADOR_DE_ACESSO=? WHERE ID_MATERIA=?");
			stmt.setInt(1, contador);
				stmt.setInt(2, idM);
					return stmt.executeUpdate();
	}
	
	public List<Disciplina> consultarEntradasDisciplina()throws Exception{
		List <Disciplina> dis = new ArrayList<Disciplina>();
			stmt = con.prepareStatement("SELECT * FROM DISCIPLINA");
				rs = stmt.executeQuery();
		
		while(rs.next()) {
			int id_disciplina = rs.getInt("ID_DISCIPLINA");
			String nome = rs.getString("NOME");
			int contador = rs.getInt("CONTADOR_DE_ACESSO");
				Disciplina d = new Disciplina(nome, id_disciplina, contador);
				dis.add(d);
		}
		return dis;
	}
	
	public List<Materia> consultarEntradasConteudo()throws Exception{
		List<Materia> cont = new ArrayList<Materia>();
			stmt = con.prepareStatement("select d.nome, m.id_capitulo, des.descricao, m.contador_de_acesso\r\n" + 
					"from DISCIPLINA d\r\n" + 
					"inner join MATERIA m\r\n" + 
					"on m.id_disciplina = d.id_disciplina\r\n" + 
					"inner join DESCRICAO des\r\n" + 
					"on des.id_materia = m.id_materia");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int capitulo = rs.getInt("ID_CAPITULO");
					int contador_de_acesso = rs.getInt("CONTADOR_DE_ACESSO");
						String descricao = rs.getString("DESCRICAO");
							String desc = rs.getString("NOME");
				Materia mat = new Materia(capitulo, descricao, contador_de_acesso,desc);
				cont.add(mat);
			}
			return cont;
	}
	
	public List<Aluno> consultarAlunos()throws Exception{
		List<Aluno> alunos = new ArrayList<Aluno>();
			stmt = con.prepareStatement("select * from CHATBOT_ALUNO");
				rs = stmt.executeQuery();
			while(rs.next()) {
				String nome = rs.getString("NOME");
					String sobrenome = rs.getString("SOBRENOME");
						String rm = rs.getString("RM");
							String email = rs.getString("EMAIL");
				Aluno aluno = new Aluno(0, nome, sobrenome, null, rm, email,null);
				alunos.add(aluno);
			}
			return alunos;	
	}
}
