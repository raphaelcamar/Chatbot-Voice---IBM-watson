package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.am.conexao.Conexao;

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

	
	public int ContadorMateria(int id, int idDisc)throws Exception{
		int cont = -1;
		
		stmt = con.prepareStatement("SELECT CONTADOR_DE_ACESSO FROM MATERIA WHERE ID_MATERIA=? AND ID_DISCIPLINA=?");
		
		stmt.setInt(1, id);
		stmt.setInt(2, idDisc);
		rs = stmt.executeQuery();
		
	if(rs.next()) {
		cont = rs.getInt("CONTADOR_DE_ACESSO");
	}
	return cont;
	}
	
	public int atualizarContadorMateria(int contador, int id)throws Exception{
		contador +=1;
		stmt = con.prepareStatement("UPDATE MATERIA SET CONTADOR_DE_ACESSO=? WHERE ID_MATERIA=?");
		
		stmt.setInt(1, contador);
		stmt.setInt(2, id);
		
		return stmt.executeUpdate();
	}
}
