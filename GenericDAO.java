package br.ifam.model.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ifam.model.bean.Usuario;

public class GenericDAO {
	private Connection conexao=null;
	
	public GenericDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public Usuario logar(String SQL,String...parametros) throws SQLException{
		PreparedStatement pstmt = conexao.prepareStatement(SQL) ; 
		for (int i = 0; i < parametros.length; i++) {  
			pstmt.setObject(i+1, parametros[i]);  
		} 
		pstmt.execute(); 
		pstmt.close();
		return null;
	}
	public void adicionar (String SQL,String... parametros) throws SQLException{
		PreparedStatement pstmt = conexao.prepareStatement(SQL) ; 
		for (int i = 0; i < parametros.length; i++) {  
			pstmt.setObject(i+1, parametros[i]);  
		} 
		pstmt.execute(); 
		pstmt.close(); 
	}
	public void alterar(String SQL,Long id, String... parametros) throws SQLException { 
		PreparedStatement pstmt = conexao.prepareStatement(SQL); 
		for (int i = 0; i < parametros.length; i++) { 
			pstmt.setObject(i+1, parametros[i]);  
		}
		pstmt.setObject(parametros.length + 1, id); 
		pstmt.execute(); 
		pstmt.close();  
	} 

	public void remover(String SQL,Long... parametros) throws SQLException {
		PreparedStatement pstmt = conexao.prepareStatement(SQL) ; 
		for (int i = 0; i < parametros.length; i++) {  
			pstmt.setObject(i+1, parametros[i]);  
		} 
		pstmt.execute(); 
		pstmt.close(); 
	} 	
}

