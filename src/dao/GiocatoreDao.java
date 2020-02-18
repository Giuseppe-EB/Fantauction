package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Giocatore;
import model.Squadra;

public class GiocatoreDao {
	private DataSource dataSource;
	
	private GiocatoreDao() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			dataSource=new DataSource("jdbc:postgresql://localhost:5432/SitoAsta","postgres","Accettare7");
		} catch (Exception e) {
			System.out.println("MySQLDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}

	}
	private static GiocatoreDao instance= null;
	public static GiocatoreDao getInstance() {
		if (instance==null)
			instance= new GiocatoreDao();
		return instance;
	}
	public List<Giocatore> findAll(int id) {
		Connection connection = null;
		List<Giocatore> giocatori = new LinkedList<>();
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select * from giocatore";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				 giocatori.add(new Giocatore(result.getInt("id"),result.getString("nome"),result.getString("cognome"),result.getString("squadra"),result.getString("ruolo")));
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
		return giocatori;
	}
	public void add(LinkedList<Giocatore> giocatori) {
		Connection connection = this.dataSource.getConnection();
		for(int i=0; i<giocatori.size();i++) {
		try {
			String query="INSERT INTO giocatore( id, nome, cognome, squadra,ruolo) values (?,?,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, giocatori.get(i).getId());
			statement.setString(2, giocatori.get(i).getNome());
			statement.setString(3, giocatori.get(i).getCognome());
			statement.setString(4, giocatori.get(i).getSquadra());
			statement.setString(5, giocatori.get(i).getRuolo());
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
