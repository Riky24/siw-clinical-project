package it.uniroma3.modelli;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prerequisito {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String chiave;
	
	@Column(nullable = false)
	private String valore;
	
	public Prerequisito() {}
	
	public Prerequisito(String chiave, String valore){
		this.chiave = chiave;
		this.valore = valore;
	}

	public String getChiave() {
		return chiave;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chiave == null) ? 0 : chiave.hashCode());
		result = prime * result + ((valore == null) ? 0 : valore.hashCode());
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
		Prerequisito other = (Prerequisito) obj;
		if (chiave == null) {
			if (other.chiave != null)
				return false;
		} else if (!chiave.equals(other.chiave))
			return false;
		if (valore == null) {
			if (other.valore != null)
				return false;
		} else if (!valore.equals(other.valore))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
