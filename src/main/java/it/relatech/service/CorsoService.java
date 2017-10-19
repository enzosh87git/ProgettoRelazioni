package it.relatech.service;

import java.util.ArrayList;

import it.relatech.model.Corso;



public interface CorsoService {

	Corso saveCorso(Corso corso);

	ArrayList<Corso> getListCorsi(String queryHQL);
	
	ArrayList<Corso> getAllCorsiByNamedQuery();
	
	ArrayList<Corso> getByCriteria();
	
	Corso findByNameCorso(String firstName);

	Corso updateCorso(Corso corso);

	Corso deleteCorso(Corso corso);

}
