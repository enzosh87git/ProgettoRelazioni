package it.relatech.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professore {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	
	@OneToMany(mappedBy = "professore")
//	@JoinColumn(name = "PROF_ID")
	private List<Corso> listCorsi;
	
	public Professore() {
		listCorsi = new ArrayList<>();
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

	public List<Corso> getListCorsi() {
		return listCorsi;
	}

	public void setListCorsi(List<Corso> listCorsi) {
		this.listCorsi = listCorsi;
	}

	@Override
	public String toString() {
		return "Professore [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
}
