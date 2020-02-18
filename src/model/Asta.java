package model;

public class Asta {

	private int id;
	private String name;
	private String password;
	private int nTeam;
	public Asta(String name, String password,int nTeam) {
		this.setId(0);
		this.setName(name);
		this.setPassword(password);
		this.setnTeam(nTeam);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getnTeam() {
		return nTeam;
	}
	public void setnTeam(int nTeam) {
		this.nTeam = nTeam;
	}
	
}
