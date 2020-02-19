package model;

public class Squadra {
private int id;
private int idAsta;
private String Nome;
private int crediti;
private boolean connected;
public Squadra(int id, int idAsta, String nome, int crediti) {
	super();
	this.id = id;
	Nome = nome;
	this.crediti = crediti;
	this.idAsta=idAsta;
	this.setConnected(false);
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return Nome;
}
public void setNome(String nome) {
	Nome = nome;
}
public int getCrediti() {
	return crediti;
}
public void setCrediti(int crediti) {
	this.crediti = crediti;
}
public int getIdAsta() {
	return idAsta;
}
public void setIdAsta(int idAsta) {
	this.idAsta = idAsta;
}
public boolean isConnected() {
	return connected;
}
public void setConnected(boolean connected) {
	this.connected = connected;
}

}
