package it.uniroma3.modelli;

import java.util.Map;

public class Servizio {
	private String codice;
	private String nome;
	private String descrizione;
	//gdsgds
	private String costo;
	private Map<String, String> prerequisiti;

	public Servizio(){}

	
	public String getCodice() {
		return codice;
	}

	public void setCodice(String newCodice) {
		this.codice = newCodice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String newNome) {
		this.nome = newNome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String newDescrizione) {
		this.descrizione = newDescrizione;
	}
	
	public String getCosto(){
		return this.costo;
	}
	
	public void setCosto(String newCosto){
		this.costo = newCosto;
	}
	
	public Map<String, String> getPrerequisiti(){
		return this.prerequisiti;
	}
	
	public void setPrerequisito(String chiave, String valore){
		this.prerequisiti.put(chiave, valore);
	}
	
	public String toString() {
		return "[" + this.getCodice() + ", " + 
				this.getNome() + ", " + 
					this.getDescrizione() + ", " + 
				        this.getCosto();
		
	}
}
