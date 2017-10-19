package it.relatech.dao;

import java.util.ArrayList;

import it.relatech.model.Professore;

public interface ProfessoreDao {
	Professore saveProfessore(Professore professore);

	ArrayList<Professore> getListProfessori(String queryHQL);

	ArrayList<Professore> getByCriteria();
	
	ArrayList<Professore> getAllProfessoriByNamedQuery();
	
	Professore findByName(String firstName);
	
	Professore getByIdByCriteria(int id);

	Professore updateProfessore(Professore professore);

	Professore deleteProfessore(Professore professore);
}
