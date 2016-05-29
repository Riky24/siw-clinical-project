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

import it.uniroma3.modelli.Prerequisito;
import it.uniroma3.modelli.TipologiaEsame;

@WebServlet("/inserisciTipologiaEsameController")
public class InserisciTipologiaEsameController extends HttpServlet  {

    public InserisciTipologiaEsameController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextpage = "/inserisciTipologiaEsame.jsp";
		
		TipologiaEsame tipologiaEsame = new TipologiaEsame();
		
		InserisciTipologiaEsameAction iteAction = new InserisciTipologiaEsameAction();
		InserisciTipologiaEsameHelper iteHelper = new InserisciTipologiaEsameHelper();
		
		//determina quale bottone è stato premuto
		String bt = request.getParameter("bt");
		
		
		
		//salva l'oggetto 'tipologiaEsame' nel database
		if(bt.equals("salva")) {
			if(iteHelper.validate(request,response)) {
				nextpage = iteAction.execute(request, tipologiaEsame);
			}
		}
		
		//lega la 'tipologiaEsame' con l'oggetto 'prerequisito' per poi salvarlo nella sessione
		if(bt.equals("inserisciAltriPrerequisiti")) {
			if(iteHelper.validate(request,response)) {
				tipologiaEsame.setCodice(request.getParameter("codice"));
				tipologiaEsame.setNome(request.getParameter("nome"));
				tipologiaEsame.setCosto(request.getParameter("costo"));
				tipologiaEsame.setDescrizione(request.getParameter("descrizione"));
				Prerequisito prerequisito = 
						new Prerequisito(request.getParameter("chiavePrerequisito"), request.getParameter("valorePrerequisito"));
				tipologiaEsame.addPrerequisito(prerequisito);
				nextpage = "/inserisciAltroPrerequisito.jsp";
			}
		}
		
		//salva l'oggetto 'tipologiaEsame' nella sessione
		HttpSession s = request.getSession();
		s.setAttribute("tip", tipologiaEsame);
		
		// inoltro la richiesta alla pagina jsp dedicata
		nextpage = response.encodeURL(nextpage);
		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextpage);
		rd.forward(request, response);
		
	}
}
