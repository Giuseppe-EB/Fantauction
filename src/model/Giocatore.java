package model;

public class Giocatore {
private int id;
protected String nome;
protected String cognome;
private String squadra;
private String ruolo;
private String path;
public Giocatore() {}
public Giocatore(int id,String nome,String cognome,String squadra,String ruolo, String path)
{
	this.id=id;
	this.nome=nome;
	this.cognome=cognome;
	this.squadra=squadra;
	this.ruolo=ruolo;
	this.path=path;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public String getRuolo() {
	return ruolo;
}
public void setRuolo(String ruolo) {
	this.ruolo = ruolo;
}
public String getSquadra() {
	return squadra;
}
public void setSquadra(String squadra) {
	this.squadra = squadra;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}

}
