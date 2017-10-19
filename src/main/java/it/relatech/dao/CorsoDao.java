package it.relatech.dao;

import java.util.ArrayList;

import it.relatech.model.Corso;

public interface CorsoDao {
	Corso saveCorso(Corso corso);

	ArrayList<Corso> getListCorsi(String queryHQL);

	ArrayList<Corso> getByCriteria();
	
	ArrayList<Corso> getAllCorsiByNamedQuery();
	
	Corso findByNameCorso(String firstName);
	
	Corso getByIdByCriteria(int id);

	Corso updateCorso(Corso student);

	Corso deleteCorso(Corso student);
}
