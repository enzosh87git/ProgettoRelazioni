package it.relatech.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import it.relatech.model.CodFisc;
import it.relatech.model.Corso;

public class CodFiscDaoImpl extends HibernateDao implements CodFiscDao {

	public CodFisc saveCodFisc(CodFisc codFisc) {
		return (CodFisc) persist(codFisc);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<CodFisc> getListCodFisc(String queryHQL) {
		return (ArrayList<CodFisc>) getAll(queryHQL);
	}

	public CodFisc updateCodFisc(CodFisc codFisc) {
		return (CodFisc) update(codFisc);
	}

	public CodFisc deleteCodFisc(CodFisc codFisc) {
		return (CodFisc) delete(codFisc);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<CodFisc> getByCriteria() {
		return (ArrayList<CodFisc>) getSession().createCriteria(CodFisc.class).list();
	}

	//Torna uno studente per ID
	public CodFisc getByIdByCriteria(int id) {
		Criteria criteria = getSession().createCriteria(CodFisc.class);
		criteria.add(Restrictions.eq("id", id));
		return (CodFisc) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<CodFisc> getAllCodFiscByNamedQuery() {
		return (ArrayList<CodFisc>) getSession().getNamedQuery("findAllCodFisc").list();
	}

	public CodFisc findByName(String firstName) {
		Query namedQuery = getSession().createQuery("SELECT c FROM CodFisc c WHERE c.codFisc LIKE '"+firstName+"'");
		return (CodFisc) namedQuery.uniqueResult();
	}

}
