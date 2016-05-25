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

import it.uniroma3.modelli.Utente;

@WebServlet("/logoutcontroller")
public class LogoutController extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessione = request.getSession();
		Utente u  = (Utente) sessione.getAttribute("utente");
		if(u!=null){
			sessione.removeAttribute("utente");
		}
		ServletContext s = request.getServletContext();
		RequestDispatcher d = s.getRequestDispatcher("/effettuaLogin.jsp");
		d.forward(request, response);
	}
}