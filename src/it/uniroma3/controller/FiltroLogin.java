package it.uniroma3.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import it.uniroma3.modelli.Utente;

public class FiltroLogin implements Filter {
	private ServletContext application;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		if (((Utente)session.getAttribute("utente"))!= null){
			System.out.println("trovato");
			chain.doFilter(request, response);	
		}else{
			System.out.println("niente da fare :(");
			request.setAttribute("loginError", "Effettua il login");
			RequestDispatcher rd  = this.application.getRequestDispatcher("/effettuaLogin.jsp");
			rd.forward(request, response);
		}
	}  

	public void init(FilterConfig fConfig) throws ServletException {		
		this.application = fConfig.getServletContext();
	}

	public void destroy() {		
	}
}
