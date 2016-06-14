package it.uniroma3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma3.modelli.TipologiaEsame;
import it.uniroma3.modelli.Utente;

/**
 * Servlet implementation class VisualizzaTipologieEsamiController
 */
@WebServlet("/visualizzaTipologieEsamiController")
public class VisualizzaTipologieEsamiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaTipologieEsamiController() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextpage = "/elencoTipologieEsami.jsp";
		
		VisualizzaTipologieEsamiAction vtea = new VisualizzaTipologieEsamiAction();
		
		PaginaInizialeAction pia = new PaginaInizialeAction();
		try {
			pia.inizializzaDatabase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession s = request.getSession();
//		Utente utente = (Utente)s.getAttribute("utente");
		
		List<TipologiaEsame> r = vtea.execute();
		s.setAttribute("tipologie", r);
		
		nextpage = response.encodeURL(nextpage);
		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextpage);
		rd.forward(request, response);
	}

}
