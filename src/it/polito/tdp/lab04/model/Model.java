package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	List<Corso>corsi = new LinkedList<Corso>();
	List<String> studenticorso = new LinkedList<String>();
	
	public List<String> getCorsi() {
		List<String>corsiN = new LinkedList<String>();
		CorsoDAO dao= new CorsoDAO();
		 corsiN.add("");
		for(Corso s: dao.getTuttiICorsi()){
			corsi.add(s);
			corsiN.add(s.getNome());
		}
		return corsiN;
	}
	public Studente trovaStudente(String matricola){
		StudenteDAO dao =new StudenteDAO();
		
		Studente s=dao.find(matricola);
		
		return s;
	}
	public List<Studente> getStudentiCorso(String nomeCorso) {
		Corso corso=null;
		CorsoDAO dao= new CorsoDAO();
		
		for(Corso c : corsi){
			if(c.getNome().compareTo(nomeCorso)==0){
				corso=c;
				break;
			}
		}
		return dao.getStudentiIscrittiAlCorso(corso);
	}
	
	public List<Corso> getCorsiDiStudente(String matricola) {
		List<Corso> corsiDiStu = new LinkedList<Corso>();
		CorsoDAO dao= new CorsoDAO();
		Corso c=null;
		if(dao.corsiPerStudente(matricola)!=null){
			for(String codC : dao.corsiPerStudente(matricola)){
				c=dao.getCorso(codC);
				corsiDiStu.add(c);
			}
			return corsiDiStu;
		}
		return null;
	}
}

