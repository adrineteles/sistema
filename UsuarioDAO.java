package br.ifam.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.ifam.model.DAO.interfaces.IGenericoDAO;
import br.ifam.model.bean.Usuario;

public class UsuarioDAO extends GenericDAO implements IGenericoDAO<Usuario>{
	private Connection conexao;
	
	public UsuarioDAO (Connection conexao){
		super(conexao);
		this.conexao=conexao;
	}
	
	public Usuario logar(Usuario usuario) throws SQLException {
		String SQL = "SELECT * FROM usuario WHERE login = ? and senha = ?";
		try {
			super.logar(SQL,usuario.getNomeUsuario(),
					         usuario.getLoginUsuario(),
					         usuario.getSenhaUsuario(),
					         usuario.getTipoUsuario() );
		} catch (SQLException e) {			
			System.out.println("ERRO NO SCRIPT:"+e.getMessage());
		}
		return usuario; 
	}
	
	public boolean adicionar(Usuario usuario) throws SQLException {
		String SQL="INSERT INTO usuario (nome,login,senha,tipo) values (?,?,?,?)";
		try {
			super.adicionar(SQL,usuario.getNomeUsuario(),
					         usuario.getLoginUsuario(),
					         usuario.getSenhaUsuario(),
					         usuario.getTipoUsuario() );
		} catch (SQLException e) {			
			System.out.println("ERRO INSERT:"+e.getMessage());
			return false;
		}
		return true;
	}


	public void remover(Usuario usuario) throws SQLException {
		String SQL ="DELETE FROM usuario WHERE idUsuario = ?"; 
		try {
			super.remover(SQL, usuario.getIdUsuario());
		} catch (SQLException e) {			
			System.out.println("ERRO DELETE:"+e.getMessage());
		} 	
	}


	public Usuario buscar(Long id) throws SQLException {
		Usuario usuarioRetorno = null;
		String SQL = "SELECT * FROM usuario WHERE idUsuario = ?";
		PreparedStatement stmt = conexao.prepareStatement(SQL); 
		stmt.setLong(1, id); 
		ResultSet rs = stmt.executeQuery(); 		   
		if (rs.next()) {  
			usuarioRetorno = new Usuario();  
			usuarioRetorno.setIdUsuario(rs.getLong("idUsuario")); 
			usuarioRetorno.setNomeUsuario(rs.getString("nome"));
			usuarioRetorno.setLoginUsuario("login");
			usuarioRetorno.setSenhaUsuario("senha");
			usuarioRetorno.setTipoUsuario(rs.getString("tipo"));
		} 
		rs.close(); 
		stmt.close(); 
		return usuarioRetorno;
	}

	public void alterar(Usuario usuario) throws SQLException {
		String SQL = "UPDATE usuario SET nome = ?, login = ?, senha = ? , tipo= ? WHERE idUsuario = ?";  
		try {
			super.alterar(SQL, usuario.getIdUsuario(),usuario.getNomeUsuario(),usuario.getLoginUsuario(),usuario.getSenhaUsuario(),usuario.getTipoUsuario());
		} catch (SQLException e) {			
			System.out.println("ERRO UPDATE:"+e.getMessage());
		} 
	}

	public List<Usuario> listar() throws SQLException {
			List<Usuario> vetorUsuario = new ArrayList<Usuario>();		
			String SQL = "SELECT * FROM usuario"; 
			PreparedStatement stmt;
			try {
				stmt = conexao.prepareStatement(SQL);
				ResultSet rs = stmt.executeQuery(); 
				while (rs.next()) {  
					Usuario user = new Usuario();  
					user.setIdUsuario(rs.getLong("idUsuario"));
					user.setSenhaUsuario(rs.getString("senha"));
					user.setLoginUsuario(rs.getString("login"));
					user.setNomeUsuario(rs.getString("nome"));
					user.setTipoUsuario(rs.getString("tipo"));
					vetorUsuario.add(user); 
				}  
				rs.close(); 
				stmt.close();
			} catch (SQLException e) {
				System.out.println("ERRO LISTAR:"+e.getMessage());
			}
			return vetorUsuario;
	}


}
