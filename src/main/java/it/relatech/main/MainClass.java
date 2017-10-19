package it.relatech.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.relatech.config.HibernateUtil;
import it.relatech.dao.HibernateDao;
import it.relatech.model.CodFisc;
import it.relatech.model.Corso;
import it.relatech.model.Professore;
import it.relatech.model.Studente;
import it.relatech.service.CodFiscService;
import it.relatech.service.CodFiscServiceImpl;
import it.relatech.service.CorsoService;
import it.relatech.service.CorsoServiceImpl;
import it.relatech.service.ProfessoreService;
import it.relatech.service.ProfessoreServiceImpl;
import it.relatech.service.StudentService;
import it.relatech.service.StudentServiceImpl;

/*
 * 1. Creare uno Studente (e CodFisc assieme)
 * 2. Creare un Profesore
 * 3. Creare un Corso
 * 4. Associare un Corso ad uno Studente (tramite la lista interna della classe)
 * 5. Associare un Prof ad un Corso
 * 6. Stampare lista Studenti
 * 7. Stampare lista Studenti e Professori dato il Corso
 * */



public class MainClass {
	
	static Scanner key = new Scanner(System.in);
	
	static StudentService studentService;
	static CodFiscService codFiscService;
	static ProfessoreService professoreService;
	static CorsoService corsoService;
	
	public static void main(String[] args) {
		
		HibernateDao.getSession();
		studentService = new StudentServiceImpl();
		codFiscService = new CodFiscServiceImpl();
		professoreService = new ProfessoreServiceImpl();
		corsoService = new CorsoServiceImpl();
		
		boolean escape = false;
		
		while(!escape) {			
			System.out.println("Menù");
			System.out.println("1. Inserire Studente (e codice fiscale)");
			System.out.println("2. Inserire Professore");
			System.out.println("3. Inserire Corso");
			System.out.println("4. Associa Corso -> Studente");
			System.out.println("5. Associa Professore -> Corso");
			System.out.println("6. Stampa Studenti");
			System.out.println("7. Stampa Studenti per Corso e Professore");
			System.out.println("8. Termina programma");
			
			int scelta = key.nextInt();
			key.nextLine();
			
			switch(scelta) {
			case(1):
				creaStudenteECodFisc();
			break;
			
			case(2):
				creaProfessore();
			break;
			
			case(3):
				creaCorso();
			break;
			
			case(4):
				linkCorso_Studente();
			break;
			
			case(5):
				linkProfessore_Corso();
			break;
			
			case(6):
				printListStudente();
			break;
			
			case(7):
				printListStudente_Corso_Professore();
			break;
			
			case(8):
				HibernateDao.closeSession();
				HibernateUtil.shutdown();
				System.exit(0);
			break;
			
			default:
				System.out.println("Inserimento non valido, riprovare");
				System.out.println();
				System.out.println();
			break;
			}
		}
			
					
	}

	private static void creaStudenteECodFisc() {
		try {
			Studente studente = new Studente();
			CodFisc codFisc = new CodFisc();
			
			System.out.print("Inserire nome: ");
			studente.setNome(key.nextLine());
			
			System.out.print("Inserire codice fiscale: ");
			codFisc.setCodFisc(key.nextLine());
			
			//Setta il OneToOne
			studente.setCodFisc(codFisc);			
			codFisc.setStudente(studente);
			
			System.out.println(studente);
			
			//Salva le righe nelle tabelle del database
			studentService.saveStudent(studente);
//			codFiscService.saveCodFisc(codFisc);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void creaProfessore() {
		try {
			
			Professore prof = new Professore();
			
			System.out.print("Inserire nome: ");
			prof.setNome(key.nextLine());
			
			professoreService.saveProfessore(prof);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void creaCorso() {
		try {
			
			Corso corso = new Corso();
			
			System.out.print("Inserire nome: ");
			corso.setNome(key.nextLine());
			
			corsoService.saveCorso(corso);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void linkCorso_Studente() {		
		boolean escape = false;
		
		Studente studente = null;
		Corso corso = null;
		
		
		List<Corso> listCorso = corsoService.getListCorsi("SELECT c FROM Corso c");
		if(listCorso.isEmpty()) {
			System.out.println("Non ci sono corsi nel database");
			return;
		}
		listCorso.forEach(System.out::println);
		
		do {
			System.out.print("Inserire nome corso: ");
			corso = corsoService.findByNameCorso(key.nextLine());
			if(corso == null) System.out.println("Nome corso non trovato. Riprova.\n\n");
			else escape = true;
		}while(!escape);
		
		do {
			System.out.print("Inserire nome studente a cui collegare il corso: ");
			studente = studentService.findByName(key.nextLine());
			if(studente == null) System.out.println("Nome studente non trovato. Riprova.\n\n");
			else escape = true;
		}while(!escape);
		
		corso.getListStudenti().add(studente);
		studente.getListCorsi().add(corso);
		
		corsoService.updateCorso(corso);
		studentService.updateStudent(studente);
		
		System.out.println("Corsi dello studente " + studente.getNome() + ": ");
		studente.getListCorsi().forEach(System.out::println);
		
	}

	private static void linkProfessore_Corso() {
		
		List<Professore> listProf = professoreService.getListProfessori("SELECT p FROM Professore p");
		if(listProf.isEmpty()) {
			System.out.println("Non ci sono professori nel database");
			return;
		}
		else {
			System.out.println("\n\n");
			listProf.forEach(System.out::println);
			
			Professore prof = null;
			Corso corso = null;
			
			while(prof == null) {
				System.out.print("Inserire nome professore: ");
				prof = professoreService.findByName(key.nextLine());
				if(prof == null) System.out.println("Errore nell'inserimento");
			}
			
			System.out.println("\n\n");
			
			
			List<Corso> listCorso = corsoService.getListCorsi("SELECT c FROM Corso c");
			if(listCorso.isEmpty()) {
				System.out.println("Non ci sono corsi nel database");
				return;
			}
			else {
				while(corso == null) {
					System.out.print("Inserire nome corso: ");
					corso = corsoService.findByNameCorso(key.nextLine());
					if(corso == null) System.out.println("Errore nell'inserimento");
				}
				
				corso.setProfessore(prof);
				prof.getListCorsi().add(corso);
				corsoService.updateCorso(corso);
				professoreService.updateProfessore(prof);
				
				System.out.println("\n\nCorsi del professore " + prof.getNome() + ": ");
				prof.getListCorsi().forEach(System.out::println);
			}
			
		}
		
	}

	private static void printListStudente() {
		List<Studente> listStudenti = studentService.getListStudents("SELECT s FROM Studente s");
		if(listStudenti.isEmpty()) {
			System.out.println("Non ci sono studenti nel database");
			return;
		}
		else listStudenti.forEach(System.out::println);
	}

	private static void printListStudente_Corso_Professore() {
		
		//Dato un corso, stampo la lista degli studenti e dei professori
		List<Corso> listCorso = corsoService.getListCorsi("SELECT c FROM Corso c");
		if(listCorso.isEmpty()) {
			System.out.println("Non ci sono corsi nel database");
			return;
		}
		else {
			listCorso.forEach(System.out::println);
			
			Corso corso = null;

			while(corso == null) {
				System.out.println("\n\nInserire nome corso: ");
				corso = corsoService.findByNameCorso(key.nextLine());
				if(corso == null) System.out.println("Errore nell'inserimento");
			}
			
			System.out.println("\nIl corso di " + corso.getNome() + " ha i seguenti Studenti: ");
			corso.getListStudenti().forEach(System.out::println);
			System.out.println("Ed il seguente professore: " + corso.getProfessore());
			
		}
		
	}
}









































