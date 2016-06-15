package it.uniroma3.controller;

import javax.servlet.http.*;
import it.uniroma3.modelli.Facade;
import it.uniroma3.modelli.Utente;

public class LoginAction {

	public LoginAction(){}

	public Utente esegui(HttpServletRequest request) throws Exception {
		
		Facade facade = new Facade();
		facade.istanziaEntityManager();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Utente utente = new Utente();
		utente.setUsername(username);
		utente.setPassword(password);

		for (Utente u : facade.getAllUtenti()) {
			if(u.equals(utente))
				return u;
		}
		
		facade.closeEm();
		
		return null;
		
	}
}

