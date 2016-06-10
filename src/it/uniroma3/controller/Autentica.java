//package it.uniroma3.controller;
//
//import java.io.*;
//import javax.servlet.*;
//import javax.servlet.http.*;
//
//public class Autentica extends HttpServlet {
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//    					throws IOException, ServletException {
//
//		String prossimaPagina = "/fallimento.jsp";
//		ServletContext application  = getServletContext();
//		RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
//		rd.forward(request, response);
//	}
//
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//    					throws IOException, ServletException {
//		String prossimaPagina = "/fallimento.jsp";
//		LoginAction login = new LoginAction();
//		String esito = login.esegui(request);
//		if (esito.equals("OK"))
//			prossimaPagina = "/risorsaProtetta.jsp";
//		ServletContext application  = getServletContext();
//		RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
//		rd.forward(request, response);
//	}
//}
//
