package it.relatech.service;

import java.util.ArrayList;

import it.relatech.dao.StudentDao;
import it.relatech.dao.StudenteDaoImpl;
import it.relatech.model.Studente;


public class StudentServiceImpl implements StudentService {

	StudentDao dao = new StudenteDaoImpl();

	public Studente saveStudent(Studente studente) {
		return dao.saveStudent(studente);
	}

	public ArrayList<Studente> getListStudents(String queryHQL) {
		return dao.getListStudents(queryHQL);
	}

	public Studente updateStudent(Studente studente) {
		return dao.updateStudent(studente);
	}

	public Studente deleteStudent(Studente studente) {
		return dao.deleteStudent(studente);
	}

	public ArrayList<Studente> getByCriteria() {
		return dao.getByCriteria();
	}

	public ArrayList<Studente> getAllStudentsByNamedQuery() {
		return dao.getAllStudentsByNamedQuery();
	}

	public Studente findByName(String firstName) {
		return dao.findByName(firstName);
	}

}
