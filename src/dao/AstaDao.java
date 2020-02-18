package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.DataSource;
import model.Asta;

public class AstaDao {
	private DataSource dataSource;
		
	private AstaDao() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			dataSource=new DataSource("jdbc:postgresql://localhost:5432/SitoAsta","postgres","Accettare7");
		} catch (Exception e) {
			System.out.println("MySQLDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}

	}
	private static AstaDao instance= null;
	public static AstaDao getInstance() {
		if (instance==null)
			instance= new AstaDao();
		return instance;
	}
	public List<String> findAll() {
		return null;
	}
	public void add(Asta asta) {
		Connection connection = this.dataSource.getConnection();
		try {
			String query = "INSERT INTO asta( name, password,nTeam) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, asta.getName());
			statement.setString(2, asta.getPassword());
			statement.setInt(3, asta.getnTeam());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	public int getId(Asta asta) {
		Connection connection = this.dataSource.getConnection();
		try {
			String query = "select id from asta where name=? and password=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, asta.getName());
			statement.setString(2, asta.getPassword());
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				return result.getInt("id");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return -1;
	}
}
