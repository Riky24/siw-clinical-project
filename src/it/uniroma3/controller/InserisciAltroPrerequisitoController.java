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

/**
 * Servlet implementation class InserisciAltroPrerequisitoController
 */
@WebServlet("/inserisciAltroPrerequisitoController")
public class InserisciAltroPrerequisitoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciAltroPrerequisitoController() {
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
		
		String nextpage = "/inserisciAltroPrerequisito.jsp";
		
		InserisciAltroPrerequisitoAction iapAction = new InserisciAltroPrerequisitoAction();
		InserisciAltroPrerequisitoHelper iapHelper = new InserisciAltroPrerequisitoHelper();
			
		HttpSession s = request.getSession();
		TipologiaEsame tipologiaEsame = (TipologiaEsame)s.getAttribute("tip");
		
		
		//determina quale bottone è stato premuto
		String bt = request.getParameter("bt");
		
		if(bt.equals("salva")) {
			if(iapHelper.validate(request,response)) {
				nextpage = iapAction.execute(request, tipologiaEsame);
			}
		}
		
		if(bt.equals("inserisciAltroPrerequisito")) {
			if(iapHelper.validate(request,response)) {
				Prerequisito prerequisito = 
						new Prerequisito(request.getParameter("chiavePrerequisito"), request.getParameter("valorePrerequisito"));
				tipologiaEsame.addPrerequisito(prerequisito);
				request.setAttribute("prerequisitoAggiunto", "Il prerequisito è stato aggiunto");
			}
		}
		
		
		request.setAttribute("tipologiaEsame", tipologiaEsame);
		
		nextpage = response.encodeURL(nextpage);
		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(nextpage);
		rd.forward(request, response);
	}

}
