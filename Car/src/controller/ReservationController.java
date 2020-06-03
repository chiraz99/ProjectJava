package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToolbar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class ReservationController implements Initializable{
	@FXML
	private JFXButton validbtn;
	 @FXML
	    private AnchorPane ancho;
	 @FXML
	 private Label nomvlabel;
	 @FXML
	 private Label montantlabel;
	 @FXML
	    private DatePicker dated;
	    @FXML
	    private DatePicker datef;
	@FXML 
	private TextField nbjour;
	@FXML 
	private JFXToolbar tool;
	@FXML
	private Text welcome;
	
	
	public void setPrenom(String user) {
		this.welcome.setText(" "+user);
	}
	    
	    @FXML
	    private  int showJour() {
	    	
	    	
	    	long debutL=dated.getValue().toEpochDay();
	    	long finL=datef.getValue().toEpochDay();
	    	int jour=(int) Math.abs(finL - debutL);
	    	nbjour.setText(Integer.toString(jour));
	    	return(jour);
	    
	    }
	 
	 
	 
	 
private rendezvs selectedrendezvs;
public void initData(rendezvs vehicule) {
	selectedrendezvs= vehicule;
	nomvlabel.setText(selectedrendezvs.getNomvoiture());
	montantlabel.setText(selectedrendezvs.getPrix());
	
}
	 
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	setPrenom(LoginController.getInstance().Prenom());
    
		
	}

    public void ValidAction( ActionEvent event) {
    	JOptionPane.showMessageDialog(null, "Réservation voiture effectué ,passer par l'agence pour recevoir ta voiture");

}}
