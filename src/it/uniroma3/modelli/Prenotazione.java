package it.uniroma3.modelli;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Utente utente;
	
	@OneToOne
	private TipologiaEsame tipologiaEsame;
	
	@Column(nullable=false)
	private String dataPrenotazione;
	
	public Prenotazione(){
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
		this.dataPrenotazione = sdf.format(gc.getTime());
	}
	
	public Long getId(){
		return this.id;
	}
	
	public void setTipologiaEsame(TipologiaEsame t){
		this.tipologiaEsame = t;
	}
	
	public void setUtente(Utente u){
		this.utente = u;
	}
	
	public String getData(){
		return this.dataPrenotazione;
	}
	
	@Override
	public boolean equals(Object o){
		Prenotazione p = (Prenotazione) o;
		boolean e = this.getId()==p.getId();
		return e;
	}
	

}
