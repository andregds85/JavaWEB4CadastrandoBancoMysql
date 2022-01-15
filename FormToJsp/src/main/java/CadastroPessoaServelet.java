import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CadastroPessoaServelet")
public class CadastroPessoaServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroPessoaServelet() {
        super();

    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		
		Connection con;
		try {
			
			con = Conecta.getConexao();
		
			pessoa in = new pessoa();
			in.setNome(nome);
			in.setIdade(idade);
			
			pessoaModelDao dao = new pessoaModelDao(con);
			dao.adicionar(in);
			
			request.setAttribute("msg", "Cadastrado Efetuado com sucesso!");		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}




















