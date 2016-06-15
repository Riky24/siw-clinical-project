package it.uniroma3.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.uniroma3.modelli.RisultatoEsame;

/**
 * Servlet implementation class DettagliRisultatoEsameController
 */
@WebServlet("/dettagliRisultatoEsameController")
public class DettagliRisultatoEsameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DettagliRisultatoEsameController() {
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
		// TODO Auto-generated method stub
		
		String nextpage = "/dettagliRisultatoEsame.jsp";
		
		DettagliRisultatoEsameAction drea = new DettagliRisultatoEsameAction();
		
		Long ris = Long.parseLong(request.getParameter("nomeRis"));
		
		RisultatoEsame r = drea.execute(ris);
		
		request.setAttribute("risultatoo", r);
		
		
		
		nextpage = response.encodeURL(nextpage);
		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextpage);
		rd.forward(request, response);
		
	}

}
