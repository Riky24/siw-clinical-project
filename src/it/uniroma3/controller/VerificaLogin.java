package it.uniroma3.controller;

import java.util.LinkedList;
import java.util.List;

import it.uniroma3.modelli.Utente;

public class VerificaLogin {
	
	private Utente u = new Utente();
	private Utente a = new Utente();
	private List<Utente> list;
	
	public VerificaLogin(){
		list = new LinkedList<>();
		
		this.a.setUsername("mario");
		this.a.setPassword("rossi");
		this.a.setRuolo("admin");
		
		this.u.setUsername("rossi");
		this.u.setPassword("mario");
		this.u.setRuolo("user");
		
		list.add(this.a);
		list.add(this.u);
	}
	
	public Utente login(String username,String password){
		Utente utente = null;
		for(Utente x: this.list){
			if(x.getUsername().equals(username) && x.getPassword().equals(password)){
				Utente u = new Utente();
				u.setUsername(x.getUsername());
				u.setPassword(x.getPassword());
				u.setRuolo(x.getRuolo());
				// ...cosi per ogni valore...
				utente = u;
			}
		}
		return utente;
	}
}
