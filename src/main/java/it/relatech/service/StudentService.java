package it.relatech.service;

import java.util.ArrayList;

import it.relatech.model.Studente;


public interface StudentService {

	Studente saveStudent(Studente studente);

	ArrayList<Studente> getListStudents(String queryHQL);
	
	ArrayList<Studente> getAllStudentsByNamedQuery();
	
	ArrayList<Studente> getByCriteria();
	
	Studente findByName(String firstName);

	Studente updateStudent(Studente student);

	Studente deleteStudent(Studente student);

}
