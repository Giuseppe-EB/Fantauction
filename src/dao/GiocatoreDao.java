package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Giocatore;
import model.Squadra;
import model.giocatore1;

public class GiocatoreDao {
	private DataSource dataSource;
	
	private GiocatoreDao() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			dataSource=new DataSource("jdbc:postgresql://rogue.db.elephantsql.com:5432/rjzafrnh","rjzafrnh","a4FVbMrfxMeTqhbxaXHtuvyOn_WKgWyw");
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
	public List<Giocatore> findAll() {
		Connection connection = null;
		List<Giocatore> giocatori = new ArrayList<>();
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select * from giocatore order by  ruolo desc, cognome asc ";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				 giocatori.add(new Giocatore(result.getInt("id"),result.getString("nome"),result.getString("cognome"),result.getString("squadra"),result.getString("ruolo"), result.getString("path")));
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
	public giocatore1 getLastBuying(Squadra squadra) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select g.nome as nome, g.cognome as cognome, gs.prezzo as prezzo, s.nome as nomeSquadra, s.id as idSquadra, s.crediti as crediti \r\n" + 
					"from giocatore_squadra gs, giocatore g, squadra s \r\n" + 
					"where s.id= gs.idsquadra and gs.idasta=? and gs.idasta=s.idasta and g.id=idgiocatore \r\n" + 
					"order by g.ruolo asc, g.cognome desc\r\n" + 
					"limit 1";
			statement = connection.prepareStatement(query);
			statement.setInt(1, squadra.getIdAsta());
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				return new giocatore1(result.getString("nome"), result.getString("cognome"), result.getInt("prezzo"), result.getString("nomeSquadra"), result.getInt("idSquadra"), result.getInt("crediti"));
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
		return null;
	}
}
