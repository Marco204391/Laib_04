package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	List<String> corsi = new LinkedList<String>();
	
	public List<String> getCorsi() {
		CorsoDAO dao= new CorsoDAO();
		 corsi.add("");
		for(Corso s: dao.getTuttiICorsi()){
			corsi.add(s.getNome());
		}
		return corsi;
	}
	public Studente trovaStudente(String matricola){
		StudenteDAO dao =new StudenteDAO();
		
		Studente s=dao.find(matricola);
		
		return s;
	}
}
