package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import DBConnection.Singleton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CrudAdCltController implements Initializable {
	@FXML
	private JFXButton btnreturn;
    @FXML
    private TableColumn<Client, String> colgender;

    @FXML
    private TableColumn<Client, String> colpays;

    @FXML
    private TableColumn<Client, String> colprenom;

    @FXML
    private TableView<Client> tablePerson;

    @FXML
    private TableColumn<Client, String> colmdp;

    @FXML
    private TableColumn<Client, String> colId;
    ObservableList<Client> List=FXCollections.observableArrayList();
    



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Connection conn = Singleton.getConn();

			ResultSet rs=conn.createStatement().executeQuery("SELECT * from person ");
			while(rs.next()) { 
				
			
			List.add(new Client(rs.getString("idperson"),rs.getString("nom"), rs.getString("mdp"), rs.getString("pays"), rs.getString("genre")));
		
		}} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		colId.setCellValueFactory(new PropertyValueFactory<>("idperson"));
		colprenom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		colmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
		colpays.setCellValueFactory(new PropertyValueFactory<>("pays"));
		colgender.setCellValueFactory(new PropertyValueFactory<>("genre"));
		tablePerson.setItems(List);
	}
	  public void ReturnAction(ActionEvent event) {
	    	btnreturn.getScene().getWindow().hide();
	    	Stage retourner = new Stage();
	    	Parent root;
	    	try {
	    		root = FXMLLoader.load(getClass().getResource("/FXML/Admin.fxml"));
	    	
	       Scene scene = new Scene(root);
	       retourner.setScene(scene);
	       retourner.show();
	       retourner.setResizable(false);
	    	} catch (IOException e) {
	    		
	    		e.printStackTrace();
	    	}

	    }
	
	

}
