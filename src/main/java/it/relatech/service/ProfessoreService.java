package it.relatech.service;

import java.util.ArrayList;

import it.relatech.model.Professore;



public interface ProfessoreService {

	Professore saveProfessore(Professore professore);

	ArrayList<Professore> getListProfessori(String queryHQL);
	
	ArrayList<Professore> getAllProfessoriByNamedQuery();
	
	ArrayList<Professore> getByCriteria();
	
	Professore findByName(String firstName);

	Professore updateProfessore(Professore professore);

	Professore deleteProfessore(Professore professore);

}
