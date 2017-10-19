package it.relatech.dao;

import java.util.ArrayList;

import it.relatech.model.CodFisc;


public interface CodFiscDao {
	CodFisc saveCodFisc(CodFisc codFisc);

	ArrayList<CodFisc> getListCodFisc(String queryHQL);

	ArrayList<CodFisc> getByCriteria();
	
	ArrayList<CodFisc> getAllCodFiscByNamedQuery();
	
	CodFisc findByName(String firstName);
	
	CodFisc getByIdByCriteria(int id);

	CodFisc updateCodFisc(CodFisc codFisc);

	CodFisc deleteCodFisc(CodFisc codFisc);
}
