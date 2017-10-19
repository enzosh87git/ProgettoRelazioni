package it.relatech.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class Corso {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	
	@ManyToMany(mappedBy = "listCorsi")
	private List<Studente> listStudenti;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PROF_ID")
	private Professore professore;
	
	public Corso() {
		listStudenti = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Studente> getListStudenti() {
		return listStudenti;
	}

	public void setListStudenti(List<Studente> listStudenti) {
		this.listStudenti = listStudenti;
	}

	public Professore getProfessore() {
		return professore;
	}

	public void setProfessore(Professore professore) {
		this.professore = professore;
	}

	@Override
	public String toString() {
		return "Corso [id=" + id + ", nome=" + nome + ", listStudenti=" + listStudenti + ", professore=" + professore
				+ "]";
	}
	
	
	
}
