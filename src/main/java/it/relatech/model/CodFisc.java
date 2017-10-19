package it.relatech.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CodFisc {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String codFisc;
	
	@OneToOne(mappedBy = "codFisc")
	private Studente studente;
	
	public CodFisc() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodFisc() {
		return codFisc;
	}

	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}

	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	@Override
	public String toString() {
		return "CodFisc [id=" + id + ", codFisc=" + codFisc + "]";
	}
	
	
	
}
