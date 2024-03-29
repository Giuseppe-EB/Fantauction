package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AstaDao;
import dao.GiocatoreDao;
import dao.SquadraDao;
import model.Asta;
import model.Giocatore;
import model.Squadra;
import model.giocatore1;


@WebServlet("/auction")
public class Auction extends HttpServlet {
	
	private static final long serialVersionUID = 2L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("form1"))
				{	
					if(request.getSession().getAttribute("form")==null)
						request.getSession().setAttribute("form", "1");
					RequestDispatcher rd = request.getRequestDispatcher("/building.jsp");
					rd.forward(request, response);
					return;
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("form2")) {
					RequestDispatcher rd = request.getRequestDispatcher("/building.jsp");
					rd.forward(request, response);
					return;
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("partecipa")) {
					if(request.getSession().getAttribute("form")==null)
						request.getSession().setAttribute("form", "4");
					RequestDispatcher rd = request.getRequestDispatcher("/building.jsp");
					rd.forward(request, response);
					return;
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("seleziona")) {
					
					ArrayList<Giocatore> giocatori = (ArrayList<Giocatore>) GiocatoreDao.getInstance().findAll();
					request.getSession().setAttribute("giocatori", giocatori);
					if(request.getSession().getAttribute("summary")!=null)
					{	
						RequestDispatcher rd = request.getRequestDispatcher("/auction?key=fine");
						rd.forward(request, response);
						return;
					}
					RequestDispatcher rd = request.getRequestDispatcher("/waitingroom.jsp");
					rd.forward(request, response);
					return;
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("check")) {
					ArrayList<Giocatore> giocatori = (ArrayList<Giocatore>) GiocatoreDao.getInstance().findAll();
					request.getSession().setAttribute("giocatori", giocatori);
					int i=0;
					request.getSession().setAttribute("currentPlayer", i);
					RequestDispatcher rd = request.getRequestDispatcher("/auction.jsp");
					rd.forward(request, response);
					return;
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("fine")) {
					Squadra squadra = (Squadra) request.getSession().getAttribute("squadra");
					if((boolean) request.getSession().getAttribute("admin"))
						AstaDao.getInstance().setCurrentPlayer(-1, squadra.getIdAsta());
					request.getSession().setAttribute("giocatori_squadra", SquadraDao.getInstance().tabella(squadra.getIdAsta()));
					RequestDispatcher rd = request.getRequestDispatcher("/summary.jsp");
					rd.forward(request, response);
					return;
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("faq"))
				{	
				
					RequestDispatcher rd = request.getRequestDispatcher("/faq.html");
					rd.forward(request, response);
					return;
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("summary")) {
					if(request.getSession().getAttribute("squadra")==null) {
						request.getSession().setAttribute("summary", "per visualizzare il riepilogo � necessario accedere ad un'asta e selezionare la tua squadra");
						RequestDispatcher rd = request.getRequestDispatcher("/auction?key=partecipa");
						rd.forward(request, response);
						return;
					}
					RequestDispatcher rd = request.getRequestDispatcher("/auction?key=fine");
					rd.forward(request, response);
					return;
						
					
				}
				if(request.getSession().getAttribute("summary")!=null)
				{
					request.getSession().setAttribute("summary", null);
				}
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.forward(request, response);
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("form1")) {
					int nTeam=Integer.parseInt(request.getParameter("nTeam"));
					Asta asta=new Asta( request.getParameter("name"), request.getParameter("password"),nTeam);
					AstaDao.getInstance().add(asta);
					asta.setId(AstaDao.getInstance().getId(asta));
					LinkedList<Squadra> squadre = new LinkedList<Squadra>();
					for(int i=1;i<=nTeam;i++)
					{
						squadre.add(new Squadra(i,asta.getId(),"",0));
					}
					request.getSession().setAttribute("admin", true);
					request.getSession().setAttribute("squadre", squadre);
					request.getSession().setAttribute("form", "2");
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("form2")) {
					LinkedList<Squadra> squadre = extracted(request);
					for(int i=0; i<squadre.size();i++) {
						squadre.get(i).setNome(request.getParameter("nome"+String.valueOf(i+1).toString()));
						squadre.get(i).setCrediti(Integer.parseInt(request.getParameter("crediti"+String.valueOf(i+1).toString())));
					}
					request.getSession().setAttribute("squadre", squadre);
					request.getSession().setAttribute("form", "3");
					SquadraDao.getInstance().add(squadre);
					
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("partecipa")) {
					String nome=request.getParameter("name");
					if(request.getParameter("name").equalsIgnoreCase("Asta1*")) {
						request.getSession().setAttribute("admin", true);
						nome = "Asta1";
					}
					else
						request.getSession().setAttribute("admin", false);
					LinkedList<Squadra> squadre = (LinkedList<Squadra>) SquadraDao.getInstance().
							findAll(AstaDao.getInstance().
									getId(new Asta(nome, 
											request.getParameter("password"), 0)));
					request.getSession().setAttribute("squadre", squadre);
					request.getSession().setAttribute("form", "3");
					if(squadre==null) throw new RuntimeException("credenziali_errate");
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("seleziona")) {
					int id=Integer.parseInt(request.getParameter("id"));
					LinkedList<Squadra> squadre = extracted(request);
					request.getSession().setAttribute("squadra", getSquadraByID(id, squadre));					
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("check")) {
					Squadra squadra = (Squadra) request.getSession().getAttribute("squadra");
					LinkedList<Integer> ID = SquadraDao.getInstance().getConnectedTeam(squadra.getIdAsta());
					ID.addFirst(-1);
					ID.addLast(-1);
					response.getWriter().print(ID);
					return;
				
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("skip")) {
					int currentPlayer =  (int) request.getSession().getAttribute("currentPlayer");
					Squadra squadra = (Squadra) request.getSession().getAttribute("squadra");
					if(!(boolean)request.getSession().getAttribute("admin"))
						currentPlayer=AstaDao.getInstance().getCurrentPlayer(squadra.getIdAsta());
					else
					{	currentPlayer++;
						AstaDao.getInstance().setCurrentPlayer(currentPlayer, squadra.getIdAsta());
					}
					request.getSession().setAttribute("currentPlayer", currentPlayer);
					@SuppressWarnings("unchecked")
					ArrayList<Giocatore> giocatori= (ArrayList<Giocatore>) request.getSession().getAttribute("giocatori");
					response.getWriter().print("<img id=\"imObjectImage_7_05\" src=\""+giocatori.get(currentPlayer).getPath()+"\" title=\"\" alt=\"\" />\r\n" + 
							"					    <label class=\"player_\" id=\"currentPlayerId\" >"+giocatori.get(currentPlayer).getId()+"</label><br>\r\n" + 
							"					    <label class=\"player\">"+giocatori.get(currentPlayer).getNome()+"</label>\r\n" + 
							"					    <label class=\"player-S\">"+giocatori.get(currentPlayer).getCognome()+"</label>");
					return;
				
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("acquista")) {
					int crediti = Integer.parseInt(request.getParameter("crediti"));
					int idSquadra = Integer.parseInt(request.getParameter("selected"));
					int idGiocatore = Integer.parseInt(request.getParameter("player"));
					Squadra squadra = (Squadra) request.getSession().getAttribute("squadra");
					SquadraDao.getInstance().addPlayer(idSquadra, squadra.getIdAsta(), idGiocatore, crediti);
					LinkedList<Squadra> squadre = (LinkedList<Squadra>) SquadraDao.getInstance().findAll(squadra.getIdAsta());
					request.getSession().setAttribute("squadre", squadre);
					request.getSession().setAttribute("ultimoAcquisto", squadre.get(idSquadra-1).getCrediti() );
					return;
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("refresh")) {
					int crediti = (int) request.getSession().getAttribute("ultimoAcquisto");
					response.getWriter().print(crediti);
					return;
				}

				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("fine")) {
					Squadra squadra = (Squadra) request.getSession().getAttribute("squadra");
					request.getSession().setAttribute("giocatori_squadra", SquadraDao.getInstance().tabella(squadra.getIdAsta()));
					
				}

				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("refreshS")) {
					Squadra squadra = (Squadra) request.getSession().getAttribute("squadra");
					giocatore1 giocatore = GiocatoreDao.getInstance().getLastBuying(squadra);
					response.getWriter()
						.print(giocatore.getId()+ "," 
								+giocatore.getCrediti()+ "," 
									+"La Squadra "+ giocatore.getSquadra() 
										+" ha acquistato" +giocatore.getNome() 
											+ "&#32;" + giocatore.getCognome() 
												+ "per " + giocatore.getPrezzo() + ".");
					return;
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("syncro")) {
					LinkedList<Squadra> squadre = extracted(request);
					int currentPlayer = (int) request.getSession().getAttribute("currentPlayer");
					if(currentPlayer==-1) {
						response.getWriter().print("end");
						return;
					}	
					if(AstaDao.getInstance().getCurrentPlayer(squadre.get(0).getIdAsta())!=currentPlayer) {
							if(equals(squadre, (LinkedList<Squadra>) SquadraDao.getInstance().findAll(squadre.get(0).getIdAsta())))
							{	response.getWriter().print("skip");
								return;
							}
							
							response.getWriter().print("refresh");
							return;
					}
					return;
				}
				doGet(request, response);
			}
	@SuppressWarnings("unchecked")
	private LinkedList<Squadra> extracted(HttpServletRequest request) {
		return (LinkedList<Squadra>) request.getSession().getAttribute("squadre");
	}	
	
	private Squadra getSquadraByID(int id, LinkedList<Squadra> squadre) {
		for (int i=0; i<squadre.size(); i++) {
			if(squadre.get(i).getId()==id) {
				SquadraDao.getInstance().connect(squadre.get(i));
				squadre.get(i).setConnected(true);
				return squadre.get(i);
			}	
		}
		return null;
	}
	private boolean equals(LinkedList<Squadra> S1, LinkedList<Squadra> S2) {
		for(int i=0; i<S1.size(); i++) {
			if(S1.get(i).getCrediti()!=S2.get(i).getCrediti())
				return false;
		}
		return true;
	}
	private Squadra modify(LinkedList<Squadra> S1, LinkedList<Squadra> S2) {
		for(int i=0; i<S1.size(); i++) {
			if(S1.get(i).getCrediti()!=S2.get(i).getCrediti())
				return S2.get(i);
		}
		return null;
	}
}