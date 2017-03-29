package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;

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
	
}
