package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Squadra;
import model.giocatore1;
import model.squadra_giocatore;

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
		if(id==-1) return null;
		Connection connection = null;
		List<Squadra> squadre = new LinkedList<>();
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select * from squadra where idAsta=? order by id";
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
	public LinkedList<Integer> getConnectedTeam(int id){
		Connection connection = null;
		LinkedList<Integer> connected = new LinkedList<>();
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select id from squadra where idAsta=? and connected=true order by id";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				 connected.add(result.getInt("id"));
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
		return connected;		
	}
	public void connect(Squadra squadra) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update squadra SET connected = true where id=? and idAsta=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, squadra.getId());
			statement.setInt(2, squadra.getIdAsta());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}
	public void addPlayer(int idSquadra, int idAsta, int idGiocatore, int crediti) {
		Connection connection = this.dataSource.getConnection();
		try {
			String query = "insert into giocatore_squadra(idGiocatore, idSquadra, idAsta, prezzo) values(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idGiocatore);
			statement.setInt(2, idSquadra);
			statement.setInt(3, idAsta);
			statement.setInt(4, crediti);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}
	public LinkedList<squadra_giocatore> tabella(int idasta)
	{	
		LinkedList<squadra_giocatore> giocatori_squadra= new LinkedList<>();
		Connection connection = this.dataSource.getConnection();
		try {
			String query = "select s.nome as NomeSquadra, g.nome as NomeGiocatore,  g1.prezzo, g.cognome as Cognome from squadra s, giocatore g, giocatore_squadra g1 where g.id=g1.idgiocatore and s.id=g1.idsquadra and g1.idasta=? and s.idasta=g1.idasta group by s.nome,g.nome,g.cognome,g1.prezzo, g.ruolo order by s.nome, g.ruolo desc, g.cognome asc";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idasta);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
					if(giocatori_squadra.isEmpty())
					giocatori_squadra.add(new squadra_giocatore(result.getString("NomeSquadra")));
				if(giocatori_squadra.getLast().getNome().equalsIgnoreCase(result.getString("NomeSquadra")))
					giocatori_squadra.getLast().add(new giocatore1(result.getString("NomeGiocatore"),result.getString("Cognome"),result.getInt("prezzo")));
				else
				{
					giocatori_squadra.add(new squadra_giocatore(result.getString("NomeSquadra")));
					giocatori_squadra.getLast().add(new giocatore1(result.getString("NomeGiocatore"),result.getString("Cognome"), result.getInt("prezzo")));
				}
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
		return giocatori_squadra;
	}
	
}
