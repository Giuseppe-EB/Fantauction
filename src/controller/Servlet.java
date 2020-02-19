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


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("form1"))
				{	
					if(request.getSession().getAttribute("form")==null)
						request.getSession().setAttribute("form", "1");
					RequestDispatcher rd = request.getRequestDispatcher("/createAsta.jsp");
					rd.forward(request, response);
					return;
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("form2")) {
					RequestDispatcher rd = request.getRequestDispatcher("/createAsta.jsp");
					rd.forward(request, response);
					return;
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("partecipa")) {
					if(request.getSession().getAttribute("form")==null)
						request.getSession().setAttribute("form", "4");
					RequestDispatcher rd = request.getRequestDispatcher("/createAsta.jsp");
					rd.forward(request, response);
					return;
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("seleziona")) {
					System.out.println("switch");
					RequestDispatcher rd = request.getRequestDispatcher("/AttesaAsta.jsp");
					rd.forward(request, response);
					return;
				}
				else if(request.getParameter("key")!=null&&request.getParameter("key").equalsIgnoreCase("check")) {
					ArrayList<Giocatore> giocatori = (ArrayList<Giocatore>) GiocatoreDao.getInstance().findAll();
					request.getSession().setAttribute("giocatori", giocatori);
					request.getSession().setAttribute("currentPlayer", 0);
					RequestDispatcher rd = request.getRequestDispatcher("/astaAdmin.jsp");
					rd.forward(request, response);
					return;
				}
				RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
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
					LinkedList<Squadra> squadre = (LinkedList<Squadra>) SquadraDao.getInstance().
							findAll(AstaDao.getInstance().
									getId(new Asta(request.getParameter("nome"), 
											request.getParameter("password"), 0)));
					request.getSession().setAttribute("squadre", squadre);
					request.getSession().setAttribute("form", "3");
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
					currentPlayer++;
					request.getSession().setAttribute("currentPlayer", currentPlayer);
					AstaDao.getInstance().setCurrentPlayer(currentPlayer, squadra.getIdAsta());
					@SuppressWarnings("unchecked")
					ArrayList<Giocatore> giocatori= (ArrayList<Giocatore>) request.getSession().getAttribute("giocatori");
					response.getWriter().print(giocatori.get(currentPlayer).getNome()+" "+giocatori.get(currentPlayer).getCognome());
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
}