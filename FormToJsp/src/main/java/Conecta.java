
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class Conecta {
	
	public static Connection getConexao() throws SQLException{
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.print("Conectado");
			
			//sofrerá mudanças quando o projeto for hospedado na web
			return DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
			
		}catch(SQLException e){
			throw new SQLException(e);
		}catch(ClassNotFoundException e1){
			throw new SQLException(e1);
		}
	}

}
