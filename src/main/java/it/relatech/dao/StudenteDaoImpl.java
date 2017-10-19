package it.relatech.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import it.relatech.model.Studente;

public class StudenteDaoImpl extends HibernateDao implements StudentDao {

	public Studente saveStudent(Studente studente) {
		return (Studente) persist(studente);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Studente> getListStudents(String queryHQL) {
		return (ArrayList<Studente>) getAll(queryHQL);
	}

	public Studente updateStudent(Studente studente) {
		return (Studente) update(studente);
	}

	public Studente deleteStudent(Studente student) {
		return (Studente) delete(student);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Studente> getByCriteria() {
		return (ArrayList<Studente>) getSession().createCriteria(Studente.class).list();
	}

	//Torna uno studente per ID
	public Studente getByIdByCriteria(int id) {
		Criteria criteria = getSession().createCriteria(Studente.class);
		criteria.add(Restrictions.eq("id", id));
		return (Studente) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Studente> getAllStudentsByNamedQuery() {
		return (ArrayList<Studente>) getSession().getNamedQuery("findAllStudents").list();
	}

	public Studente findByName(String firstName) {
		
		Query namedQuery = getSession().createQuery("SELECT s FROM Studente s WHERE s.nome LIKE '"+firstName+"'");
		return (Studente) namedQuery.uniqueResult(); 
		
		
//		Query namedQuery = getSession().getNamedQuery("findByName");
//		namedQuery.setParameter("firstName", firstName);
//		Studente uniqueResult = (Studente) namedQuery.uniqueResult();
//		return uniqueResult;
	}

}
