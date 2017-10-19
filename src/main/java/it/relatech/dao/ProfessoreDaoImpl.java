package it.relatech.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import it.relatech.model.Corso;
import it.relatech.model.Professore;

public class ProfessoreDaoImpl extends HibernateDao implements ProfessoreDao {

	public Professore saveProfessore(Professore professore) {
		return (Professore) persist(professore);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Professore> getListProfessori(String queryHQL) {
		return (ArrayList<Professore>) getAll(queryHQL);
	}

	public Professore updateProfessore(Professore professore) {
		return (Professore) update(professore);
	}

	public Professore deleteProfessore(Professore professore) {
		return (Professore) delete(professore);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Professore> getByCriteria() {
		return (ArrayList<Professore>) getSession().createCriteria(Professore.class).list();
	}

	//Torna uno studente per ID
	public Professore getByIdByCriteria(int id) {
		Criteria criteria = getSession().createCriteria(Professore.class);
		criteria.add(Restrictions.eq("id", id));
		return (Professore) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Professore> getAllProfessoriByNamedQuery() {
		return (ArrayList<Professore>) getSession().getNamedQuery("findAllProfessori").list();
	}

	public Professore findByName(String firstName) {
		Query namedQuery = getSession().createQuery("SELECT p FROM Professore p WHERE p.nome LIKE '"+firstName+"'");
		return (Professore) namedQuery.uniqueResult();
		
	}

}
