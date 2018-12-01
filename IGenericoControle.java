package br.ifam.controller.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IGenericoControle <T>{
	
	public T logar(T t) throws SQLException;
	public boolean adicionar (T t) throws SQLException;

	public void remover(T t)throws SQLException;

	public T buscar(Long t)throws SQLException;

	public void alterar(T t)throws SQLException;

	public List<T> listar()throws SQLException;
}
