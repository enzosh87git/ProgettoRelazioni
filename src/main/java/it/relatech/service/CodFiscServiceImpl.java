package it.relatech.service;

import java.util.ArrayList;

import it.relatech.dao.CodFiscDao;
import it.relatech.dao.CodFiscDaoImpl;
import it.relatech.model.CodFisc;

public class CodFiscServiceImpl implements CodFiscService {

	CodFiscDao dao = new CodFiscDaoImpl();

	public CodFisc saveCodFisc(CodFisc codFisc) {
		return dao.saveCodFisc(codFisc);
	}

	public ArrayList<CodFisc> getListCodFisc(String queryHQL) {
		return dao.getListCodFisc(queryHQL);
	}

	public CodFisc updateCodFisc(CodFisc codFisc) {
		return dao.updateCodFisc(codFisc);
	}

	public CodFisc deleteCodFisc(CodFisc codFisc) {
		return dao.deleteCodFisc(codFisc);
	}

	public ArrayList<CodFisc> getByCriteria() {
		return dao.getByCriteria();
	}

	public ArrayList<CodFisc> getAllCodFiscByNamedQuery() {
		return dao.getAllCodFiscByNamedQuery();
	}

	public CodFisc findByName(String firstName) {
		return dao.findByName(firstName);
	}

}
