package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";
			
		List<Corso> corsi = new LinkedList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo Corso alla lista
				Corso s = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				corsi.add(s);
			}

			return corsi;
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public Corso getCorso(String codins) {
		
		Corso c=null;
		
		final String sql = "SELECT * "+
							"FROM corso "+
							"WHERE codins=?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, codins);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
					c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
			}
			//conn.close();
			return c;
			} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
			}
		
//		Corso cn=null;
//		for(Corso c : corsi){
//			if(c.getCondins().compareTo(codins)==0){
//				cn=c;
//				return cn;
//			}	
//		}
//		return null;
//		// TODO
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		
		final String sql="SELECT * "+
                          "FROM studente "+
                          "WHERE matricola IN (SELECT DISTINCT matricola "+
						                       "FROM iscrizione "+
						                       "WHERE codins=?)";
		
		List<Studente> studenti = new LinkedList<Studente>();
		
		
		try {
			Connection conn = ConnectDB.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, corso.getCondins());
			
			ResultSet res = st.executeQuery();
			while(res.next()){
			
				Studente s = new Studente(res.getInt("matricola"), res.getString("nome"), res.getString("cognome"), res.getString("CDS"));
				studenti.add(s);
			}
			//conn.close();
			return studenti;
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		// TODO
	}
	/*
	 * Data una matricola ed il codice insegnamento,
	 * iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		return false;
	}
	
	public List<String> corsiPerStudente(String matricola) {
	
		
		final String sql="SELECT codins "+
						"FROM iscrizione "+
						"WHERE matricola=?";
		
		List<String> codCorsi = new LinkedList<String>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, matricola);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
			
				String c =rs.getString("codins");
				codCorsi.add(c);
			}
			//conn.close();
			return codCorsi;
			} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
			}
		}
}
