/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bourseetudiant;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class ViewsBoursesController implements Initializable {

    @FXML
    private JFXButton vs1;
    @FXML
    private JFXButton vs2;
    @FXML
    private JFXButton vs3;
    @FXML
    private TableView<Bourse> table;
    @FXML
    private TableColumn<Bourse, Integer> anneUniv;
    @FXML
    private TableColumn<Bourse, Integer> terme;
 
    @FXML
    private TableColumn<Bourse, Integer> NumEtudiant;
    @FXML
    private TableColumn<Bourse, Integer> montant;

    
    public ObservableList<Bourse> data = FXCollections.observableArrayList();
    private InvalidationListener listener;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try{
        String sql= "SELECT * FROM `bourse` WHERE 1";
        Connection con =BourseDB.getConnection();
        PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
        ResultSet result =stm.executeQuery();
        
        while(result.next()){
        data.add(new Bourse(result.getInt(1),result.getInt(2),result.getInt(3),result.getInt(4)));
        }
        con.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
        anneUniv.setCellValueFactory(new PropertyValueFactory<Bourse, Integer> ("anneUniv"));
        terme.setCellValueFactory(new PropertyValueFactory<Bourse, Integer> ("terme"));
        NumEtudiant.setCellValueFactory(new PropertyValueFactory<Bourse, Integer> ("numEtudiant"));
        montant.setCellValueFactory(new PropertyValueFactory<Bourse, Integer> ("montant"));
        table.setItems(data);
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
            ((Node)event.getSource()).getScene().getWindow().hide();
          
    }

    @FXML
    private void Edite(ActionEvent event)  throws IOException {
     
           
            EditeBourseController.idbourse= table.getSelectionModel().getSelectedItem().getAnneUniv();
            EditeBourseController.term=table.getSelectionModel().getSelectedItem().getTerme();
            EditeBourseController.numEtud=table.getSelectionModel().getSelectedItem().getNumEtudiant();
            Stage stage = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("EditeBourse.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
            refreshTable();
            

    }

    @FXML
    private void DeleteBourse(ActionEvent event)throws Exception {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confimation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure to delete? ");
        Optional <ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK){
        
        
     Bourse bourse = new Bourse();
     int anneBourse = table.getSelectionModel().getSelectedItem().getAnneUniv();
     int trm = table.getSelectionModel().getSelectedItem().getTerme();
     int numE = table.getSelectionModel().getSelectedItem().getNumEtudiant();

        int status = BourseDB.deleteBourse(anneBourse, trm, numE);
     if (status>0){System.out.println("delet succeful");}else{System.out.println("delet failed");}
    
     refreshTable();
      
    }}

    @FXML
    private void insertBourse(ActionEvent event) throws IOException {
        Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("InsertBourse.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
            refreshTable();
        
    }
    
    public void refreshTable(){
    data.clear();
     try{
        String sql= "SELECT * FROM `bourse` WHERE 1";
        Connection con =BourseDB.getConnection();
        PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
        ResultSet result =stm.executeQuery();
        
        while(result.next()){
        data.add(new Bourse(result.getInt(1),result.getInt(2),result.getInt(3),result.getInt(4)));
        }
        con.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
        anneUniv.setCellValueFactory(new PropertyValueFactory<Bourse, Integer> ("anneUniv"));
        terme.setCellValueFactory(new PropertyValueFactory<Bourse, Integer> ("terme"));
        NumEtudiant.setCellValueFactory(new PropertyValueFactory<Bourse, Integer> ("numEtudiant"));
        montant.setCellValueFactory(new PropertyValueFactory<Bourse, Integer> ("montant"));
        table.setItems(data);
    
    }
    
      @FXML
        void search(ActionEvent event) throws IOException {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("SpeedSearchBourse.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            refreshTable();
        

    }
    
}
