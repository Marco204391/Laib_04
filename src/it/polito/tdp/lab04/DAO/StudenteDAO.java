package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

public Studente find (String matricola){
		
		final String sql=
			"SELECT matricola,nome,cognome "+
			"FROM studente "+
			"WHERE matricola=?";
		
		Studente result=null;
		
		try{
			Connection conn= ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			
			st.setString(1, matricola);
			ResultSet res= st.executeQuery();
			if(res.next()){
				
				Studente s = new Studente(res.getInt("matricola"), res.getString("nome"), res.getString("cognome"));
				result= s;
				
			} else{
				result=null;
			}
			conn.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
}
}
