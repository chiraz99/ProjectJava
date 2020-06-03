package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javafx.scene.control.Alert;



import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;

public class CrudAdmCarController implements Initializable {
	 @FXML
	    private JFXButton add;
	
	    
	    @FXML
	    private JFXButton delete;
		@FXML
		private JFXButton btnreturn;
		@FXML
		private TableView <Voiture> table;
		
		
		
		@FXML
		private TableColumn <Voiture,String>colpuiss;
	    @FXML
		private TableColumn <Voiture,String> colnom;
		@FXML
		private TableColumn <Voiture,String> colporte;
		@FXML
		private TableColumn <Voiture,String> colplace;
		@FXML
		private TableColumn<Voiture,String> colprix;
		@FXML
		private TableColumn <Voiture,String> colnature;
		//@FXML
	   // private TableColumn<Voiture, Button> coledit;
		  @FXML
		    private TableColumn<Voiture,String> coldateD;
		  @FXML
		    private TableColumn<Voiture,String> coldateF;
		  @FXML
		    private TableColumn<Voiture,String> colId;
		  @FXML
		  private JFXButton Update;
		  
		
	    @FXML
	    private TableColumn <Voiture,String> colcarb;
		    @FXML
		    private TextField txtnomvo;
		    @FXML
		    private TextField txtcarb;
		    @FXML
		    private TextField txtID;

		    @FXML
		    private TextField txtpui;
		    @FXML
		    private TextField txtprix;
            @FXML
		    private TextField txtnaturev;
		    @FXML
		    private TextField txtnbporte;
		    @FXML
		    private TextField txtdateD;
		    
		    @FXML
		    private TextField txtdateF;
		    @FXML
		    private TextField txtnbplace;
		    
		    private PreparedStatement pst;
		    Connection conn = Singleton.getConn();
		   public static ObservableList<Voiture> VList=FXCollections.observableArrayList();
		 
		  
		  
		    
		    @Override
			public void initialize(URL location, ResourceBundle resources) {
		    
		    	        
		       
		    	
		    	
					try {


						ResultSet rs=conn.createStatement().executeQuery("SELECT * from voiture ");
						while(rs.next()) { 
							
						
			VList.add(new Voiture(rs.getString("idvoiture"),rs.getString("nomvoiture"), rs.getString("carburant"), rs.getString("puissance"), rs.getString("nbporte"), rs.getString("nbplace"), rs.getString("prix"),rs.getString("naturevoiture")));
					
					}} catch (SQLException e) { 
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					} 
					
				     colnom.setCellValueFactory(new PropertyValueFactory<Voiture,String>("nomvoiture"));
				     colcarb.setCellValueFactory(new PropertyValueFactory<Voiture,String>("carburant"));
				     colpuiss.setCellValueFactory(new PropertyValueFactory<Voiture,String>("puissance"));
				     colporte.setCellValueFactory(new PropertyValueFactory<Voiture,String>("nbporte"));
				     colplace.setCellValueFactory(new PropertyValueFactory<Voiture,String>("nbplace"));
				     colprix.setCellValueFactory(new PropertyValueFactory<Voiture,String>("prix"));
				     colnature.setCellValueFactory(new PropertyValueFactory<Voiture,String>("naturevoiture"));
				     coldateD.setCellValueFactory(new PropertyValueFactory<Voiture,String>("datedebut"));
				     coldateF.setCellValueFactory(new PropertyValueFactory<Voiture,String>("datefin"));
				     colId.setCellValueFactory(new PropertyValueFactory<Voiture,String>("idvoiture"));
				     
				     table.setItems(VList);
		    	
		    	}
		    public void DeleteAction(ActionEvent event) {
		    	//DELETE
		    	VList.remove(selectedIndex);
		    String del="DELETE FROM voiture WHERE idvoiture=?";// WHERE idvoiture=?";

		    try {
		    	
		    	pst=conn.prepareStatement(del);
		   
		    }catch (SQLException e1) {
				e1.printStackTrace();}
		    try {
		    	
		    	pst.setInt(1,1);
			pst.executeUpdate();
		    	
		    }catch (SQLException e1) {
				e1.printStackTrace();}
		    
}
		    
		    //
		    
		    public void AddAction( ActionEvent event) {
		    	
		    	System.out.print(txtnomvo.getText());
		    	String elu="INSERT INTO voiture (idvoiture,nomvoiture,carburant,puissance,nbporte,nbplace,prix,naturevoiture)"+
		    	"VALUES(?,?,?,?,?,?,?,?) ";
		    	try {
		    		
		    		pst=conn.prepareStatement(elu);
					
				}  catch (SQLException e1) {
					e1.printStackTrace();
				}
					try {
						
						pst.setString(1,txtID.getText());
						pst.setString(2,txtnomvo.getText());
						pst.setString(3,txtcarb.getText());
						pst.setString(4,txtpui.getText());
						pst.setString(5,txtnbporte.getText());
						pst.setString(6,txtnbplace.getText());
						pst.setString(7,txtprix.getText());
						pst.setString(8,txtnaturev.getText());
						pst.executeUpdate();
						
						
						
						Alert alert=new Alert(Alert.AlertType.INFORMATION);
						alert.setContentText("Modification effectuée");
						 alert.show();
						
						 VList.add(selectedIndex,new Voiture( txtID.getText(),txtnomvo.getText(),txtcarb.getText(),txtpui.getText(),txtnbporte.getText(),txtnbplace.getText(),txtprix.getText(),txtnaturev.getText()));
						 
						txtID.clear(); txtnomvo.clear(); txtcarb.clear(); txtpui.clear(); txtnbporte.clear(); txtnbplace.clear(); txtprix.clear(); txtnaturev.clear();
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
				}
		    private int selectedIndex=1;
		   public void TableItemSelected(){
			   
		    
		  Voiture voit;
		  
		    	voit=table.getSelectionModel().getSelectedItem();
		    	selectedIndex=table.getSelectionModel().getSelectedIndex();
		    	txtID.setText(voit.getIdvoiture());
		    	txtnomvo.setText(voit.getNomvoiture());
		    	
		    	txtcarb.setText(voit.getCarburant());
		    	txtpui.setText(voit.getPuissance());
		    	txtnbporte.setText(voit.getNbporte());
		    	txtnbplace.setText(voit.getNbplace());
		    	txtprix.setText(voit.getPrix());
		    	txtnaturev.setText(voit.getNaturevoiture());}
		 
			 @FXML
		    public void UpdateAction(ActionEvent event) {
			 
				 String up="UPDATE voiture SET nomvoiture=?,carburant=?,puissance=?,nbporte=?,nbplace=?,prix=?,naturevoiture=?  WHERE idvoiture=?";
				 try {
				 pst=conn.prepareStatement(up);
				 }  catch (SQLException e1) {
						e1.printStackTrace();
				 }
					try {
						
				   
					pst.setString(1,txtnomvo.getText());
					pst.setString(2,txtcarb.getText());
					pst.setString(3,txtpui.getText());
					pst.setString(4,txtnbporte.getText());
					pst.setString(5,txtnbplace.getText());
					pst.setString(6,txtprix.getText());
					pst.setString(7,txtnaturev.getText());
					
					
					
					pst.setInt(8,1);
					pst.executeUpdate();
				
					
			 
			Alert alert=new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("Modification effectuée");
			 alert.show();
			VList.remove(selectedIndex);
			 VList.add(new Voiture( txtID.getText(),txtnomvo.getText(),txtcarb.getText(),txtpui.getText(),txtnbporte.getText(),txtnbplace.getText(),txtprix.getText(),txtnaturev.getText()));
			 
			txtID.clear(); txtnomvo.clear(); txtcarb.clear(); txtpui.clear(); txtnbporte.clear(); txtnbplace.clear(); txtprix.clear(); txtnaturev.clear();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
		    	
		    }
		    
		    public void ReturnAction(ActionEvent event) {
				try {


					ResultSet rs=conn.createStatement().executeQuery("SELECT * from voiture ");
					while(rs.next()) { 
						
					
	
				
				}} catch (SQLException e) { 
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				} 
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

		    }}
