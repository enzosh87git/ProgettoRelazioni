package it.relatech.service;
import java.util.ArrayList;

import it.relatech.dao.ProfessoreDao;
import it.relatech.dao.ProfessoreDaoImpl;
import it.relatech.model.Professore;

public class ProfessoreServiceImpl implements ProfessoreService {

	ProfessoreDao dao = new ProfessoreDaoImpl();

	public Professore saveProfessore(Professore professore) {
		return dao.saveProfessore(professore);
	}

	public ArrayList<Professore> getListProfessori(String queryHQL) {
		return dao.getListProfessori(queryHQL);
	}

	public Professore updateProfessore(Professore professore) {
		return dao.updateProfessore(professore);
	}

	public Professore deleteProfessore(Professore professore) {
		return dao.deleteProfessore(professore);
	}

	public ArrayList<Professore> getByCriteria() {
		return dao.getByCriteria();
	}

	public ArrayList<Professore> getAllProfessoriByNamedQuery() {
		return dao.getAllProfessoriByNamedQuery();
	}

	public Professore findByName(String firstName) {
		return dao.findByName(firstName);
	}

}
