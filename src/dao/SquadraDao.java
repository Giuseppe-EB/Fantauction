package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Squadra;

public class SquadraDao {
	private DataSource dataSource;
		
	private SquadraDao() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			dataSource=new DataSource("jdbc:postgresql://localhost:5432/SitoAsta","postgres","Accettare7");
		} catch (Exception e) {
			System.out.println("MySQLDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}

	}
	private static SquadraDao instance= null;
	public static SquadraDao getInstance() {
		if (instance==null)
			instance= new SquadraDao();
		return instance;
	}
	public List<Squadra> findAll(int id) {
		Connection connection = null;
		List<Squadra> squadre = new LinkedList<>();
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select * from squadra where idAsta=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				 squadre.add(new Squadra(result.getInt("id"),result.getInt("idAsta"),result.getString("nome"),result.getInt("crediti")));
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
		return squadre;
	}
	public void add(LinkedList<Squadra> squadre) {
		Connection connection = this.dataSource.getConnection();
		for(int i=0; i<squadre.size();i++) {
		try {
			String query="INSERT INTO squadra( id, idAsta, nome, crediti) values (?,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, squadre.get(i).getId());
			statement.setInt(2, squadre.get(i).getIdAsta());
			statement.setString(3, squadre.get(i).getNome());
			statement.setInt(4, squadre.get(i).getCrediti());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		}
		try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
	}
}
