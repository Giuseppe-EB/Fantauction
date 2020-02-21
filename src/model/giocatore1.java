package model;

public class giocatore1 extends Giocatore {
    private int prezzo;
	public giocatore1(int id, String nome, String cognome, String squadra, String ruolo,int prezzo) {
		super(id, nome, cognome, squadra, ruolo);
		// TODO Auto-generated constructor stub
		this.setPrezzo(prezzo);
	}
	public giocatore1(String nome, String cognome, int prezzo)
	{	
		super();
		this.nome=nome;
		this.cognome=cognome;
		this.prezzo=prezzo;
	}
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}


}
