package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.am.conexao.Conexao;
import br.com.am.entities.Materia;
import br.com.am.entities.Disciplina;

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
	
	//retornar o id da matéria, para adcionar o contador
	public int retornarContadorMateria(int disciplina)throws Exception{
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
	//adciona mais um(1), no contador quando o método for chamado.
	public int contadorDisciplina(int cont, int disciplina)throws Exception{
		cont += 1;
		stmt = con.prepareStatement("UPDATE DISCIPLINA SET CONTADOR_DE_ACESSO =? where ID_DISCIPLINA=?");
			stmt.setInt(1, cont);
			stmt.setInt(2, disciplina);
			
		return stmt.executeUpdate();
	}

	
	public int ContadorMateria(int id)throws Exception{
		int cont = -1;
		
		stmt = con.prepareStatement("SELECT CONTADOR_DE_ACESSO FROM MATERIA WHERE ID_MATERIA=?");
		
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		
	if(rs.next()) {
		cont = rs.getInt("CONTADOR_DE_ACESSO");
	}
	return cont;
	}
	
	public int atualizarContadorMateria(int contador, int idDisc)throws Exception{
		contador +=1;
		stmt = con.prepareStatement("UPDATE MATERIA SET CONTADOR_DE_ACESSO=? WHERE ID_MATERIA=?");
		
		stmt.setInt(1, contador);
		stmt.setInt(2, idDisc);
		
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
				String descricao = rs.getString("DESCRICAO");
				int contador_de_acesso = rs.getInt("CONTADOR_DE_ACESSO");
				String desc = rs.getString("NOME");
				
				Materia mat = new Materia(capitulo, descricao, contador_de_acesso,desc);
				cont.add(mat);
			}
			return cont;
			
	}
}
