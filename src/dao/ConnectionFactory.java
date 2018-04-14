package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	// Obt�m conex�o com o banco de dados
	static Connection obtemConexao() throws SQLException {
		System.out.println("teste");
		return DriverManager
				.getConnection("jdbc:mysql://localhost/praticaProgramacao?user=root&password=");
	}
}