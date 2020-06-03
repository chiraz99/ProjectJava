package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminController implements Initializable {
	 @FXML
	    private Text bienvunuetxt;

	    @FXML
	    private JFXButton updateclient;

	    @FXML
	    private JFXButton updatecar;
	    @FXML
	    private JFXButton  quitbtn;
	    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void CarUpdateAction(ActionEvent event) {
		 updatecar.getScene().getWindow().hide();
	    	Stage carbtn = new Stage();
	    	Parent root;
	    	try {
	    		root = FXMLLoader.load(getClass().getResource("/FXML/CrudAdminCar.fxml"));
	    	
	       Scene scene = new Scene(root);
	       carbtn.setScene(scene);
	       carbtn.show();
	       carbtn.setResizable(false);
	    	} catch (IOException e) {
	    		
	    		e.printStackTrace();
	    	}

	    }
	   public void ClientUpdteAction(ActionEvent event) {
	    	updateclient.getScene().getWindow().hide();
	    	Stage clientbtn = new Stage();
	    	Parent root;
	    	try {
	    		root = FXMLLoader.load(getClass().getResource("/FXML/CrudAdminClt.fxml"));
	    	
	       Scene scene = new Scene(root);
	       clientbtn.setScene(scene);
	       clientbtn.show();
	       clientbtn.setResizable(false);
	    	} catch (IOException e) {
	    		
	    		e.printStackTrace();
	    	}}
	    	
	    	@FXML
	    public void	QuitterAction (ActionEvent e1) {
	    		quitbtn.getScene().getWindow().hide();
		    	Stage clientbtn = new Stage();
		    	Parent root;
		    	try {
		    		root = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
		    	
		       Scene scene = new Scene(root);
		       clientbtn.setScene(scene);
		       clientbtn.show();
		       clientbtn.setResizable(false);
		    	} catch (IOException e) {
		    		
		    		e.printStackTrace();
		    	}
	    	 
	    }
	    


}
