package br.ifam.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoJDBC {
	private static String url; 
	private static String driver; 
	private static String usuario; 
	private static String senha; 
	private static Connection con = null; 
	public static Connection getConnection() {  
		if(con == null){
			Properties properties = new Properties();
			try { 
				FileInputStream file= new FileInputStream("C:/Users/Ednelza/Desktop/Informat. IFAM/Defesa-JDBC/src/JDBC.properties");
				properties.load(file);
				url = properties.getProperty("url");  
				driver = properties.getProperty("driver");  
				usuario = properties.getProperty("usuario");
				senha = properties.getProperty("senha"); 
				Class.forName(driver); 
				con=DriverManager.getConnection(url, usuario, senha);
				System.out.println("ok!");
			} catch (ClassNotFoundException e) { 
				System.out.println("DataSource : ocorreu um problema ao carregar o driver:"+e.getMessage());
			}
			catch (IOException e) { 
				System.out.println("Arquivo : ocorreu um problema ao carregar o arquivo:"+e.getMessage());
			}
			catch (SQLException e) {
				System.out.println("Arquivo : ocorreu um problema no SQL:"+e.getMessage());
			}
		}
		return con;
	} 
	public static void closeConnection() {  
		if(con != null){
			try {  
				con.close();
			}  
			catch (SQLException ex) {  
				ex.printStackTrace();  
			} 
		}
	}
	public static void main(String[] args) {		
			ConexaoJDBC.getConnection();		
	}
}
