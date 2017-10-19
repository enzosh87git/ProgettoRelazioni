package it.relatech.dao;

import java.util.ArrayList;

import it.relatech.model.Studente;

public interface StudentDao {
	
	Studente saveStudent(Studente student);

	ArrayList<Studente> getListStudents(String queryHQL);

	ArrayList<Studente> getByCriteria();
	
	ArrayList<Studente> getAllStudentsByNamedQuery();
	
	Studente findByName(String firstName);
	
	Studente getByIdByCriteria(int id);

	Studente updateStudent(Studente student);

	Studente deleteStudent(Studente student);
	
}
