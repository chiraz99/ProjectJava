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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class AudiController  implements Initializable {
	@FXML
	private JFXButton btnreturn;
	@FXML
	private JFXButton resrevebtn;
	@FXML
	private TableView <rendezvs> table;
	@FXML
	private TableColumn <rendezvs,String>colpuiss;
    @FXML
	private TableColumn <rendezvs,String> colnom;
	@FXML
	private TableColumn <rendezvs,String> colporte;
	@FXML
	private TableColumn <rendezvs,String> colplace;
	@FXML
	private TableColumn<rendezvs,String> colprix;
	@FXML
	private TableColumn <rendezvs,String> colnature;
	@FXML
	private TableColumn <rendezvs,String> colid;
	@FXML
	private TableColumn <rendezvs,String> colcarb;
    @FXML
    private TableColumn<rendezvs, TextField> colreserver;

   
	
    ObservableList<rendezvs> obList=FXCollections.observableArrayList();
    
	
	
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	
			try {
				Connection conn = Singleton.getConn();

				ResultSet rs=conn.createStatement().executeQuery("SELECT * from voiture where naturevoiture='Audi' ");
				while(rs.next()) { 
					
				
				obList.add(new rendezvs(rs.getString("idvoiture"),rs.getString("nomvoiture"), rs.getString("carburant"), rs.getString("puissance"), rs.getString("nbporte"), rs.getString("nbplace"), rs.getString("prix"),rs.getString("naturevoiture")));
			
			}} catch (SQLException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		
    	
    	colid.setCellValueFactory(new PropertyValueFactory<>("idvoiture"));
    	colnom.setCellValueFactory(new PropertyValueFactory<>("nomvoiture"));
    	colcarb.setCellValueFactory(new PropertyValueFactory<>("carburant"));
    	colpuiss.setCellValueFactory(new PropertyValueFactory<>("puissance"));
    	colporte.setCellValueFactory(new PropertyValueFactory<>("nbporte"));
    	colplace.setCellValueFactory(new PropertyValueFactory<>("nbplace"));
    	colprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
    	colnature.setCellValueFactory(new PropertyValueFactory<>("naturevoiture"));
    	colreserver.setCellValueFactory(new PropertyValueFactory<>("Nombre Jour"));
    	table.setItems(obList);
    	
		
    	
		
	}
  
	public void ReturnAction(ActionEvent event) {
    	btnreturn.getScene().getWindow().hide();
    	Stage retourner = new Stage();
    	Parent root;
    	try {
    		root = FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
    	
       Scene scene = new Scene(root);
       retourner.setScene(scene);
       retourner.show();
       retourner.setResizable(false);
    	} catch (IOException e) {
    		
    		e.printStackTrace();
    	}
    		
    	}
	public void ReserveAction(ActionEvent event) throws IOException {
		Stage retourner = new Stage();
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(getClass().getResource("/FXML/Res.fxml"));
		Parent root=loader.load();
		 Scene scene = new Scene(root);
		 
	       retourner.setScene(scene);
	       retourner.show();
	       retourner.setResizable(false);
	       
        ReservationController controller=loader.getController();
        controller.initData(table.getSelectionModel().getSelectedItem());
        
        btnreturn.getScene().getWindow().hide();
    	
      
        
    		
    	}
    		
    	
    	
    	
    
	   
  
 
}