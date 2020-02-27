package model;

public class giocatore1 extends Giocatore {
    private int prezzo;
    private int crediti;
	public giocatore1(int id, String nome, String cognome, String squadra, String ruolo,int prezzo,String path) {
		super(id, nome, cognome, squadra, ruolo, path);
		this.setPrezzo(prezzo);
	}
	public giocatore1(String nome, String cognome, int prezzo)
	{	
		super();
		this.nome=nome;
		this.cognome=cognome;
		this.prezzo=prezzo;
	}
	public giocatore1(String nome, String cognome, int prezzo, String squadra, int idSquadra, int crediti)
	{	
		super();
		this.nome=nome;
		this.cognome=cognome;
		this.prezzo=prezzo;
		this.setSquadra(squadra);
		this.setId(idSquadra);
		this.setCrediti(crediti);
	}
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	public int getCrediti() {
		return crediti;
	}
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}


}
