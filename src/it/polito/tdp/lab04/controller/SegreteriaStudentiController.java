/**
 * Sample Skeleton for 'SegreteriaStudenti.fxml' Controller Class
 */

package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	
	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cbxCorso"
    private ComboBox<String> cbxCorso; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaIscrittiCorso"
    private Button btnCercaIscrittiCorso; // Value injected by FXMLLoader

    @FXML // fx:id="txtMatricola"
    private TextField txtMatricola; // Value injected by FXMLLoader

    @FXML // fx:id="btnV"
    private Button btnV; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtCognome"
    private TextField txtCognome; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaCorsi"
    private Button btnCercaCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnIscrivi"
    private Button btnIscrivi; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	String matricola = txtMatricola.getText();
    	if(matricola.length()<6){
    		txtResult.appendText("Matricola non valida\n");
    		return;
    	}
    	Studente s= model.trovaStudente(matricola);
    	
    	if(s==null){
    		txtResult.appendText("Matricola "+matricola+" non trovata \n");
    	}
    	else{
    		for(Corso c : model.getCorsiDiStudente(matricola)){
    			txtResult.appendText(c.getCondins()+" "+c.getCrediti()+" "+c.getNome()+" "+c.getPd()+"\n");
    		}
    	}
    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	String nomeCorso=cbxCorso.getValue();
    	if(nomeCorso.length()>2){
    	for(Studente s: model.getStudentiCorso(nomeCorso)){
    		txtResult.appendText(+s.getMatricola()+"      "+s.getNome()+"      "+s.getCognome()+"\n");
    	}
    	}else{
    		txtResult.setText("Corso selezionato non valido"+"\n");
    	}
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doV(ActionEvent event) {
    	String matricola = txtMatricola.getText();
    	if(matricola.length()<6){
    		txtResult.appendText("Matricola non valida\n");
    		return;
    	}
    	Studente s= model.trovaStudente(matricola);
    	
    	if(s==null){
    		txtResult.appendText("Matricola "+matricola+" non trovata \n");
    	}else {
    		if(cbxCorso.getValue().equals("")){
	    		txtResult.appendText("Matricola "+matricola+" trovata \n");
	    		txtNome.setText(s.getNome());
	    		txtCognome.setText(s.getCognome());}
    		else{
    			String nomeCorso= cbxCorso.getValue();
    			if(model.controlStudenteiscritto(matricola, nomeCorso)){
    				txtResult.setText("Studente già iscritto al corso selezionato"+"\n");
    				txtNome.setText(s.getNome());
    	    		txtCognome.setText(s.getCognome());}
    			else{
    				txtResult.setText("Studente non iscritto al corso selezionato"+"\n");
    				txtNome.setText(s.getNome());
    	    		txtCognome.setText(s.getCognome());
    			}
    		}	
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cbxCorso != null : "fx:id=\"cbxCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnV != null : "fx:id=\"btnV\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
       
    }

	public void setModel(Model model) {
		this.model=model;
		// TODO Auto-generated method stub
		
		 cbxCorso.getItems().addAll(model.getCorsi());
	}
}

