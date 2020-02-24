package model;

import java.util.ArrayList;

public class squadra_giocatore {
	private String nome;
	private ArrayList<giocatore1> giocatori=new ArrayList<giocatore1>();
	private int i=0;
	public squadra_giocatore(String nome)
	{
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
   public void add(giocatore1 g)
   {
	   giocatori.add(g);
   }
   public ArrayList<giocatore1> getGiocatori(){
	   return giocatori;
   }
   public giocatore1 getGiocatore() {
	   if(i==giocatori.size())
		   i=0;
	   return giocatori.get(i++);
   }
}
