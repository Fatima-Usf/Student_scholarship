/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bourseetudiant;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class ViewStudentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Etudiant> table;
    @FXML
    private TableColumn<Etudiant, Integer>  numEtudiant;

    @FXML
    private TableColumn<Etudiant, String> nom;

    @FXML
    private TableColumn<Etudiant, String> prenom;

    @FXML
    private TableColumn<Etudiant, Integer> NumCCP;

    @FXML
    private TableColumn<Etudiant, String> dateNaissance;

    @FXML
    private TableColumn<Etudiant, Integer> NumFiliere;
    @FXML
    private TableColumn<Etudiant, String> NomFiliere;
    
    public ObservableList<Etudiant> data = FXCollections.observableArrayList();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
        String sql= "select NumEtudiant, nom, prenom, NumCCP, dateNaissance, Etudiant.Numfiliere, nomFiliere from Etudiant, Filiere where Etudiant.Numfiliere=Filiere.NumFiliere";
        Connection con =DbEtudiant.getConnection();
        PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
        ResultSet result =stm.executeQuery();
        
        while(result.next()){
        data.add(new Etudiant(result.getInt(1),result.getString(2),result.getString(3),result.getInt(4),result.getString(5),result.getInt(6), result.getString(7)));
        }
        con.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        numEtudiant.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer> ("numEtudiant"));
        nom.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("prenom"));
        NumCCP.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer> ("NumCCP"));
        dateNaissance.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("dateNaissance"));
        NumFiliere.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer> ("NumFiliere"));
        NomFiliere.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("nomFiliere"));
        
        table.setItems(data);
    }    
    
          @FXML
    void insertStudent(ActionEvent event) throws IOException, Exception {
 
            Stage stage = new Stage();
             Parent root = FXMLLoader.load(getClass().getResource("insertStudent.fxml"));
            Scene scene = new Scene(root);
        //    ComboBox comobox = new ComboBox();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
            refreshTable();
            
      

    }
    
    @FXML
    void search (ActionEvent event) throws Exception {
         Stage stage = new Stage();
           
            Parent root = FXMLLoader.load(getClass().getResource("ViewStudentFiliere.fxml"));
            Scene scene = new Scene(root);
        //    ComboBox comobox = new ComboBox();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
    }
    
    
       //delet
    
         @FXML
    void DeleteStudent(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confimation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure to delete? ");
        Optional <ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK){
     Etudiant etudiant= new Etudiant();
        int idEtudiant =table.getSelectionModel().getSelectedItem().getNumEtudiant();
      //  DbEtudiant.delete(idEtudiant);
        int status = DbEtudiant.delete(idEtudiant);
     if (status>0){System.out.println("delet succeful");}else{System.out.println("delet failed");}
      //  table.setItems(data);
      refreshTable();
      
    }}
    
           @FXML
    void EditeStudent(ActionEvent event) throws IOException {
     
    
            EditeController.id= table.getSelectionModel().getSelectedItem().getNumEtudiant();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Edite.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
            refreshTable();
   
           
            

    }
    @FXML

    public void refreshTable(){
    data.clear();

        try{
        String sql= "select NumEtudiant, nom, prenom, NumCCP, dateNaissance, Etudiant.Numfiliere, nomFiliere from Etudiant, Filiere where Etudiant.Numfiliere=Filiere.NumFiliere";
        Connection con =DbEtudiant.getConnection();
        PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
        ResultSet result =stm.executeQuery();
        
        while(result.next()){
        data.add(new Etudiant(result.getInt(1),result.getString(2),result.getString(3),result.getInt(4),result.getString(5),result.getInt(6), result.getString(7)));
        }
        con.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        numEtudiant.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer> ("numEtudiant"));
        nom.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("prenom"));
        NumCCP.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer> ("NumCCP"));
        dateNaissance.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("dateNaissance"));
        NumFiliere.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer> ("NumFiliere"));
        NomFiliere.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("nomFiliere"));
        
        table.setItems(data);
    } 
   
   
    
  
    
    @FXML
    void back(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
      
    }
   
    
}
