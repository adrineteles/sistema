package br.ifam.controller.controle;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.ifam.controller.interfaces.IGenericoControle;
import br.ifam.model.DAO.UsuarioDAO;
import br.ifam.model.bean.Usuario;
public class ControleUsuario implements IGenericoControle<Usuario>{

	UsuarioDAO usuarioDAO = null;
	
	public ControleUsuario (Connection conexao){
		usuarioDAO= new UsuarioDAO(conexao);
	}

	
	
	public Usuario logar(Usuario usuario) throws SQLException{
		// TODO Auto-generated method stub
		return usuarioDAO.logar(usuario);
	}
	
	public boolean adicionar(Usuario usuario) throws SQLException{
		return usuarioDAO.adicionar(usuario);
	}

	
	public void remover(Usuario usuario) throws SQLException{
		 usuarioDAO.remover(usuario);
	}


	
	public Usuario buscar(Long id) throws SQLException{
		return usuarioDAO.buscar(id);
	}


	public void alterar(Usuario usuario) throws SQLException{
		usuarioDAO.alterar(usuario);
		
	}


	public List<Usuario> listar() throws SQLException{
		return usuarioDAO.listar();
	}





}
