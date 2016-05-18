package it.uniroma3.modelli;

//import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class PazienteRegistrato {
	
	public PazienteRegistrato(){
		//this.prerequisiti = new ArrayList<>();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private String codiceFiscale;
				
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	@JoinColumn(name = "prerequisiti_id")
	private List<Prerequisito> prerequisiti;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String newNome) {
		this.nome = newNome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale(){
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale){
		this.codiceFiscale = codiceFiscale;
	}


	@Override
	public String toString() {
		return "EsamiOfferti [nome=" + nome + ", cocognome=" + cognome + ", codice fiscale=" + codiceFiscale + "]";
	}

}