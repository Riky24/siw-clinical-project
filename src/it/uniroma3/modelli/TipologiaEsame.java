package it.uniroma3.modelli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity
public class TipologiaEsame {
	
	public TipologiaEsame(){
		this.prerequisiti = new HashMap<>();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String codice;
	
	@Column(nullable = false)
	private String descrizione;
	
	@Column(nullable = false)
	private String costo;
	
//	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
//	@JoinColumn(name = "prerequisiti_id")
//	private List<Prerequisito> prerequisiti;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "prerequisiti_id")
	private Map<String,Prerequisito> prerequisiti;
	
	public Long getId() {
		return id;
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

	public void addPrerequisito(Prerequisito p){
		if (p != null)
		this.prerequisiti.put(p.getChiave(), p);
	}
	
	public Map<String, Prerequisito> getPrerequisiti() {
		return prerequisiti;
	}

	public void setPrerequisiti(Map<String, Prerequisito> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}


	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	@Override
	public String toString() {
		return "EsamiOfferti [nome=" + nome + ", codice=" + codice + ", descrizione=" + descrizione + ", costo=" + costo
				+ ", prerequisiti=" + prerequisiti + "]";
	}

}