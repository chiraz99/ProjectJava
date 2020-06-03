package controller;

import java.io.IOException;



import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;



import javafx.stage.Stage;

public class GUIDetailsVehicules {
	
 public GUIDetailsVehicules() {
	 

		Stage retourner = new Stage();
    	Parent root;
    	try {
    		root = FXMLLoader.load(getClass().getResource("/FXML/Reservation.fxml"));
    	
       Scene scene = new Scene(root);
       retourner.setScene(scene);
       retourner.show();
       retourner.setResizable(false);
    	} catch (IOException e) {
    		
    		e.printStackTrace();
    	}
		
	
 }}
