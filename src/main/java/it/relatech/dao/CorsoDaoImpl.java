package it.relatech.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import it.relatech.model.Corso;

public class CorsoDaoImpl extends HibernateDao implements CorsoDao {

	public Corso saveCorso(Corso corso) {
		return (Corso) persist(corso);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Corso> getListCorsi(String queryHQL) {
		return (ArrayList<Corso>) getAll(queryHQL);
	}

	public Corso updateCorso(Corso corso) {
		return (Corso) update(corso);
	}

	public Corso deleteCorso(Corso corso) {
		return (Corso) delete(corso);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Corso> getByCriteria() {
		return (ArrayList<Corso>) getSession().createCriteria(Corso.class).list();
	}

	//Torna uno studente per ID
	public Corso getByIdByCriteria(int id) {
		Criteria criteria = getSession().createCriteria(Corso.class);
		criteria.add(Restrictions.eq("id", id));
		return (Corso) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Corso> getAllCorsiByNamedQuery() {
		return (ArrayList<Corso>) getSession().getNamedQuery("findAllCorsi").list();
	}

	@Override
	public Corso findByNameCorso(String firstName) {
	
		Query namedQuery = getSession().createQuery("SELECT c FROM Corso c WHERE c.nome LIKE '"+firstName+"'");
		return (Corso) namedQuery.uniqueResult();
		
//		Query namedQuery = getSession().getNamedQuery("findByNameCorso");
//		namedQuery.setParameter("firstName", firstName);
//		Corso uniqueResult = (Corso) namedQuery.uniqueResult();
//		return uniqueResult;
	}

}
