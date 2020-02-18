package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.DataSource;

public class PersonaDaoJDBC {
	private DataSource dataSource;
		
	private PersonaDaoJDBC() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			System.out.println("LOCALHOST||||||");
			dataSource=new DataSource("jdbc:postgresql://localhost:5432/postgres","postgres","Accettare7");
		} catch (Exception e) {
			System.out.println("MySQLDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}

	}
	private static PersonaDaoJDBC instance= null;
	public static PersonaDaoJDBC getInstance() {
		if (instance==null)
			instance= new PersonaDaoJDBC();
		return instance;
	}
	public List<String> findAll() {
		Connection connection = null;
		List<String> persone = new LinkedList<>();
		try {
			System.out.println("1");
			connection = this.dataSource.getConnection();
			System.out.println("2");
			PreparedStatement statement;
			String query = "select * from persona";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				persone.add(result.getString("nome"));
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return persone;
	}
}
