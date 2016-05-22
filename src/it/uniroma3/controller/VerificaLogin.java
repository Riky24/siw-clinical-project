package it.uniroma3.controller;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.modelli.EsamiOfferti;
import it.uniroma3.modelli.Prerequisito;
import it.uniroma3.modelli.Utente;
import it.uniroma3.persistence.EsamiOffertiDaoJPA;

public class VerificaLogin {
	
	private Utente u = new Utente();
	private Utente a = new Utente();
	private List<Utente> list;
	
	public VerificaLogin(){
		this.list = new LinkedList<>();
		
		this.a.setUsername("mario");
		this.a.setPassword("rossi");
		this.a.setRuolo("admin");
		
		this.u.setUsername("rossi");
		this.u.setPassword("mario");
		this.u.setRuolo("user");
		
		this.list.add(this.a);
		this.list.add(this.u);
		
	}
	
	public Utente login(String username,String password){
		Utente utente = null;
		for(Utente x: this.list){
			if(x.getUsername().equals(username) && x.getPassword().equals(password)){
				Utente corrente = new Utente();
				corrente.setUsername(x.getUsername());
				corrente.setPassword(x.getPassword());
				corrente.setRuolo(x.getRuolo());
				// ...cosi per ogni valore...
				utente = corrente;
			}
		}
		return utente;
	}
}
