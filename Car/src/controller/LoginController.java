package controller;

import javafx.event.ActionEvent;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


import com.jfoenix.controls.*;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.util.Duration;
import DBConnection.Singleton; 



public class LoginController implements Initializable {

	@FXML
	 private JFXButton signup ;
	@FXML
	 private JFXTextField prenom;
	@FXML
	 private JFXButton login ;

	@FXML
	 private JFXPasswordField Motdepasse;
	Connection conn = Singleton.getConn();
	private PreparedStatement sam;
	private static LoginController instance;
	public LoginController() {
		instance=this;
	}
	public static LoginController getInstance() {
		return (instance);
	}
	public String Prenom() {
		return prenom.getText();
	}
	
	

 @Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}
	@FXML
public void LoginAction(ActionEvent e) { 
	
	PauseTransition pt = new PauseTransition();
	pt.setDuration(Duration.seconds(3));
	pt.setOnFinished(ev ->{
		
	});
	pt.play();
	if((prenom.getText().equals("aa")) && (Motdepasse.getText().equals("ll"))) { 
		   login.getScene().getWindow().hide();
		   Stage home=new Stage();
		   try {
			Parent root =FXMLLoader.load(getClass().getResource("/FXML/Admin.fxml"));
			Scene scene=new Scene(root);
			home.setScene(scene);
			home.show();
			
		} catch (IOException e1) {
		e1.printStackTrace();
		} 
	  }
	
	else {
   String ho=" SELECT * from person where  nom=? and mdp=?" ;
   try {
   sam=conn.prepareStatement(ho);
   sam.setString(1,prenom.getText());
   sam.setString(2,Motdepasse.getText());
   ResultSet rst=sam.executeQuery();
   int count=0;
   while(rst.next()) {
	   count=+1;
	   
   }
	   
  if (count==1) {
	   login.getScene().getWindow().hide();
	   Stage home=new Stage();
	   try {
		Parent root =FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
		Scene scene=new Scene(root);
		home.setScene(scene);
		home.show();
		
	} catch (IOException e1) {
	e1.printStackTrace();
	}  
   }
   else {
	   Alert alert=new Alert(Alert.AlertType.ERROR);
   alert.setHeaderText(null);
   alert.setContentText("vérifier le mot de passe et l'email");
   alert.show();}
   
   }catch (SQLException ea) {
	   ea.printStackTrace();
   }
   
   finally {
	   try {
		conn.close();
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
   }
   }}
  
   
	
 @FXML
    public void signUp(ActionEvent e1) throws IOException  {
   login.getScene().getWindow().hide();
    	Stage signup= new Stage();
    	Parent root=FXMLLoader.load(getClass().getResource("/FXML/SignUP.fxml"));
        Scene scene = new Scene(root);
        signup.setScene(scene);
        signup.show();
        signup.setResizable(false);}
  

      
    	
    	
    	
    	
    }
    










