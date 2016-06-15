package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma3.modelli.Facade;
import it.uniroma3.modelli.Prenotazione;
import it.uniroma3.modelli.TipologiaEsame;
import it.uniroma3.modelli.Utente;

@WebServlet("/prenotazioneController")
public class PrenotazioneController extends HttpServlet  {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher("/effettuaLogin.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		HttpSession s = request.getSession();
		String nextpage;
		
		Utente utente = (Utente)s.getAttribute("utente");
		if(utente==null || utente.getRuolo().equals("user")){
			if (utente.getRuolo().equals("user")) {
				request.setAttribute("loginError", "Effettua il login come amministratore");
			} else
				request.setAttribute("loginError", "Effettua il login");
			nextpage = "/effettuaLogin.jsp";
		}else{

			nextpage = "/creaPrenotazione.jsp";

			Facade f = new Facade();
			f.istanziaEntityManager();
			String str = f.generaSelectTipologia();
			request.setAttribute("string", str);

			String codFis = request.getParameter("codFis");
			String idTipologiaEsame = request.getParameter("tipologia");

			if(idTipologiaEsame!=null){
				boolean errore = false;
				if(codFis.equals("")){
					request.setAttribute("pazienteError", "Selezionare un paziente");
					errore = true;
				}
				if(!errore){
					Utente u = f.getByCodFiscale(codFis);
					if(!(idTipologiaEsame.equals(""))){
						Long tipId = Long.parseLong(idTipologiaEsame);
						TipologiaEsame t = f.getTipologiaByID(tipId);

						Prenotazione p = new Prenotazione();
						p.setUtente(u);
						p.setTipologiaEsame(t);

						f.inserisciPrenotazione(p);

						nextpage = "/confermaPrenotazione.jsp";
					}
				}
			}


		}
		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextpage);
		rd.forward(request, response);

	}
}