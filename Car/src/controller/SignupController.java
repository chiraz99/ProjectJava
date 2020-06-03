package controller;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import com.jfoenix.validation.RequiredFieldValidator;

import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import DBConnection.Singleton;

public class SignupController implements Initializable {
	@FXML
	private AnchorPane parentPane;
	@FXML
	 private JFXTextField EntrerPrenom ;
	@FXML
	 private JFXPasswordField EntrerMotdepasse;
	@FXML
	private JFXRadioButton Homme;
	@FXML
	private JFXRadioButton Femme;
	@FXML
	private JFXButton signup;
	@FXML
	private JFXButton login;
	@FXML
	private JFXTextField Pays ;
	@FXML
	private ToggleGroup gender;
	
	Connection conn = Singleton.getConn();
	
	private PreparedStatement pst;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		RequiredFieldValidator validator= new RequiredFieldValidator();
		RequiredFieldValidator val= new RequiredFieldValidator();
		
		
		EntrerPrenom.getValidators().add(validator);
		validator.setMessage("Aucune valeur entrée !");
		EntrerPrenom.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				
			if( !newValue) {
				EntrerPrenom.validate();			}
			
			}
		});
		
		EntrerMotdepasse.getValidators().add(val);
		val.setMessage(" caractéres spéciaux interdits !");
		EntrerMotdepasse.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(!newValue) {
					
	            if(!EntrerMotdepasse.getText().matches("[a-zA-Z0-9]*")){
	                
	            	
	            	EntrerMotdepasse.validate();
	            	EntrerMotdepasse.setText("");
	            }
	        }

		}});
	
			
		
		
		
		
	}
@FXML
public void SignUP(ActionEvent ae1) {
	
	
	
	PauseTransition pt = new PauseTransition();
	pt.setDuration(Duration.seconds(3));
	pt.setOnFinished(ev ->{
		
		System.out.print(EntrerPrenom.getText());
	
});
	pt.play();

	String insert="INSERT INTO person(nom,mdp,pays,genre)"+
	"VALUES(?,?,?,?)";
	
	try {
		pst = conn.prepareStatement(insert);
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	try {
		
		pst.setString(1,EntrerPrenom.getText());
		pst.setString(2,EntrerMotdepasse.getText());
		pst.setString(3,Pays.getText());
		pst.setString(4,getGender());
		pst.executeUpdate();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	
}
@FXML
public void loginAction(ActionEvent ae2) throws IOException  {
	signup.getScene().getWindow().hide();
	Stage login = new Stage();
	Parent root=FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
    Scene scene = new Scene(root);
    login.setScene(scene);
    login.show();
    login.setResizable(false);


}
public String getGender() {
	String gen="";
	if(Homme.isSelected()) {
		gen="Homme";
	}
	else  {
		gen ="Femme";
	}
	return gen;
	
}
}

