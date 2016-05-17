package it.uniroma3.modelli;

import java.util.HashMap;
import java.util.Map;

//prova di commit.
public class EsamiOfferti {
	private String codice;
	private String nome;
	private String descrizione;
	private String costo;
	private String prerequisiti;
	private Map<String, String> prerequisitiMap;

	public EsamiOfferti(){
		this.prerequisitiMap = new HashMap<>();
		prerequisiti = null;
	}


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

	public String getPrerequisiti(){
		return this.prerequisiti;
	}

	public Map<String, String> getPrerequisitiMap(){
		return this.prerequisitiMap;
	}

	public void setPrerequisito(String chiave, String valore){
		this.prerequisitiMap.put(chiave, valore);
		if (this.prerequisiti==null) this.prerequisiti = valore + " \n";
		else this.prerequisiti = this.prerequisiti + valore + " \n";
	}

	public String toString() {
		return "[" + this.getCodice() + ", " + 
				this.getNome() + ", " + 
				this.getDescrizione() + ", " + 
				this.getCosto();

	}
}
