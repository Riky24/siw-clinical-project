package it.uniroma3.controller;

import java.math.*;
import java.security.*;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.modelli.EsamiOfferti;
import it.uniroma3.modelli.Prerequisito;
import it.uniroma3.modelli.Utente;
import it.uniroma3.persistence.EsamiOffertiDaoJPA;
import it.uniroma3.persistence.UtenteDaoJPA;

public class VerificaLogin {
	
	private Utente u = new Utente();
	private Utente a = new Utente();
	private List<Utente> list;
	//private EntityManager em;
	
	public VerificaLogin() throws Exception{
		this.list = new LinkedList<>();
		
		this.a.setUsername("mario");
		this.a.setPassword("rossi");
		this.a.setRuolo("admin");
		
		this.u.setUsername("rossi");
		this.u.setPassword("mario");
		this.u.setRuolo("user");
		
		this.list.add(this.a);
		this.list.add(this.u);
		
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		//em = emf.createEntityManager();
		
	}
	
	/*public List<Utente> getList(){
		UtenteDaoJPA u = new UtenteDaoJPA(this.em);
		List<Utente> lista = u.findAll();
		return lista;
	}*/
	
	public Utente login(String username,String p) throws Exception{
		
		//cripto la password inserita
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(p.getBytes(),0,p.length());
		String password = (new BigInteger(1,md5.digest()).toString(16));
		
		
		Utente utente = null;
		//List<Utente> lista = this.getList();
		for(Utente x: list){
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
