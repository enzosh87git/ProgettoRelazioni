package it.relatech.service;

import java.util.ArrayList;

import it.relatech.model.CodFisc;


public interface CodFiscService {

	CodFisc saveCodFisc(CodFisc codFisc);

	ArrayList<CodFisc> getListCodFisc(String queryHQL);
	
	ArrayList<CodFisc> getAllCodFiscByNamedQuery();
	
	ArrayList<CodFisc> getByCriteria();
	
	CodFisc findByName(String firstName);

	CodFisc updateCodFisc(CodFisc codFisc);

	CodFisc deleteCodFisc(CodFisc codFisc);

}
