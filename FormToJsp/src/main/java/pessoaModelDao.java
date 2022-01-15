import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class pessoaModelDao {

	private Connection con;
	
	public pessoaModelDao(Connection con) {
		this.con = con;
	}
	
	public void adicionar(pessoa in) throws SQLException{
		
	String sql = "insert into pessoa(nome,idade)values(?,?)";	
		
	try { 
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, in.getNome());
		stmt.setString(2, in.getIdade());
		
			stmt.execute();
			stmt.close();
	
	} catch (SQLException e) {
		e.printStackTrace();	
	}finally {
		con.close();
	}


	}
}
