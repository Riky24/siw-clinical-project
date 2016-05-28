package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		InserisciTipologiaEsameAction ac = new InserisciTipologiaEsameAction();
		InserisciTipologiaEsameHelper hp = new InserisciTipologiaEsameHelper();
		
		
		if(hp.validate(request,response)) {
			nextpage = ac.execute(request);
		}
		
		// inoltro la richiesta alla pagina jsp dedicata
		nextpage = response.encodeURL(nextpage);
		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextpage);
		rd.forward(request, response);
		
	}
}
