package it.uniroma3.modelli;

//import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.security.*;
import java.math.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Utente.findAll", query = "select c from Utente c")
public class Utente {
	
	public Utente(){
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
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String ruolo;        //  admin o user
				
	
//	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
//	@JoinColumn(name = "prerequisiti_id")
//	private List<Prerequisito> prerequisiti;

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
	
	public String getUsername(){
		return this.username;
	}

	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password) throws Exception{
		//cripto la password
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(password.getBytes(),0,password.length());
		this.password = (new BigInteger(1,md5.digest()).toString(16));
	}
	
	public String getRuolo(){
		return this.ruolo;
	}

	public void setRuolo(String ruolo){
		this.ruolo = ruolo;
	}

	@Override
	public String toString() {
		return "EsamiOfferti [nome=" + nome + ", cocognome=" + cognome + ", codice fiscale=" + codiceFiscale + "]";
	}

	//username e password
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}