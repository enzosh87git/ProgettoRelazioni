package it.relatech.service;

import java.util.ArrayList;

import it.relatech.dao.CorsoDao;
import it.relatech.dao.CorsoDaoImpl;
import it.relatech.model.Corso;


public class CorsoServiceImpl implements CorsoService {

	CorsoDao dao = new CorsoDaoImpl();

	public Corso saveCorso(Corso corso) {
		return dao.saveCorso(corso);
	}

	public ArrayList<Corso> getListCorsi(String queryHQL) {
		return dao.getListCorsi(queryHQL);
	}

	public Corso updateCorso(Corso corso) {
		return dao.updateCorso(corso);
	}

	public Corso deleteCorso(Corso corso) {
		return dao.deleteCorso(corso);
	}

	public ArrayList<Corso> getByCriteria() {
		return dao.getByCriteria();
	}

	public ArrayList<Corso> getAllCorsiByNamedQuery() {
		return dao.getAllCorsiByNamedQuery();
	}

	public Corso findByNameCorso(String firstName) {
		return dao.findByNameCorso(firstName);
	}

}
