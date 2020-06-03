package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToolbar;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HomeController  implements Initializable {
	@FXML AnchorPane holderPane;
	@FXML
	private Text Bienvu;
	@FXML
	private AnchorPane anchor;
	@FXML
	private JFXToolbar toolBar;

	@FXML
	private AnchorPane anchoo;
	@FXML
	private JFXButton Audicar;
	@FXML
	private JFXButton Nissancar;
	
	@FXML
	private JFXButton Citroencar;
	
	@FXML
	private JFXButton quitter;
	@FXML
	private JFXButton sedeco;
	@FXML
	private JFXButton propos;
	@FXML
	private JFXButton voiture;

	
	AnchorPane home;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setPrenom(LoginController.getInstance().Prenom());
		}
	public void setPrenom(String user) {
		this.Bienvu.setText("Bienvenue,"+user);
	}
	
	@FXML
	public void homeAction(ActionEvent ae2) throws IOException  {
		voiture.getScene().getWindow().hide();
		Stage btnhome = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/FXML/Bienvenue.fxml"));
		
	    Scene scene = new Scene(root);
	    btnhome.setScene(scene);
	    btnhome.show();
	    btnhome.setResizable(false);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		


	}
	 @FXML
	    void QuittAction(ActionEvent event) {
		 Platform.exit();

	    }   
@FXML    
     public  void DecoAction(ActionEvent event) {
	sedeco.getScene().getWindow().hide();
	Stage login = new Stage();
	Parent root;
	try {
		root = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
	
    Scene scene = new Scene(root);
    login.setScene(scene);
    login.show();
    login.setResizable(false);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
		
	}
public  void AudiAction(ActionEvent event) {
	Audicar.getScene().getWindow().hide();
	Stage btnAudi = new Stage();
	Parent root;
	try {
		root = FXMLLoader.load(getClass().getResource("/FXML/AudiCar.fxml"));
	
   Scene scene = new Scene(root);
   btnAudi.setScene(scene);
   btnAudi.show();
   btnAudi.setResizable(false);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
		
	}
public  void CitroenAction(ActionEvent event) {
	Citroencar.getScene().getWindow().hide();
	Stage btncitroen = new Stage();
	Parent root;
	try {
		root = FXMLLoader.load(getClass().getResource("/FXML/CitroenCar.fxml"));
	
   Scene scene = new Scene(root);
   btncitroen.setScene(scene);
   btncitroen.show();
   btncitroen.setResizable(false);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
		
	}
public  void NissanAction(ActionEvent event) {
	Nissancar.getScene().getWindow().hide();
	Stage btnnissan = new Stage();
	Parent root;
	try {
		root = FXMLLoader.load(getClass().getResource("/FXML/NissanCar.fxml"));
	
   Scene scene = new Scene(root);
   btnnissan.setScene(scene);
   btnnissan.show();
   btnnissan.setResizable(false);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
		
	}


}
