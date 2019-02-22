/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bourseetudiant;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class ViewsFiliereCon implements Initializable {

    @FXML
    private JFXButton vs1;
    @FXML
    private JFXButton vs2;
    @FXML
    private JFXButton vs3;
    @FXML
    private JFXButton vs;
    @FXML
    private TableView<Filiere> table;
    @FXML
    private TableColumn<Filiere, Integer> numfiliere;
    @FXML
    private TableColumn<Filiere, String> nomfiliere;
    @FXML
    private TableColumn<Filiere, Integer> nbrAnne;
    
    public ObservableList<Filiere> data = FXCollections.observableArrayList();
    private InvalidationListener listener;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try{
        String sql= "SELECT * FROM `Filiere` WHERE 1";
        Connection con =FiliereDB.getConnection();
        PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
        ResultSet result =stm.executeQuery();
        
       while(result.next()){
        data.add(new Filiere(result.getInt(1),result.getString(2),result.getInt(3)));
        }
        con.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        numfiliere.setCellValueFactory(new PropertyValueFactory<Filiere, Integer> ("NumFiliere"));
        nomfiliere.setCellValueFactory(new PropertyValueFactory<Filiere, String> ("nomFiliere"));
        nbrAnne.setCellValueFactory(new PropertyValueFactory<Filiere, Integer> ("NbrAnne"));
        table.setItems(data);
    }    

    @FXML
    private void back(ActionEvent event) {
    }

    @FXML
    private void Edite(ActionEvent event) {
    }

    @FXML
    private void Delete(ActionEvent event) throws Exception {
            // Etudiant etudiant= new Etudiant();
             Filiere filiere = new Filiere();
      //  int idEtudiant =table.getSelectionModel().getSelectedItem().getNumEtudiant();
        int idFiliere = table.getSelectionModel().getSelectedItem().getNumFiliere();
      //  DbEtudiant.delete(idEtudiant);
        int status = FiliereDB.delete(idFiliere);
     if (status>0){System.out.println("delet succeful");}else{System.out.println("delet failed");}
      //  table.setItems(data);
      refreshTable();
        
    }

    @FXML
    private void insert(ActionEvent event) {
    }

    @FXML
    private void refreshTable() {
     data.clear();
        try{
        String sql= "SELECT * FROM `Filiere` WHERE 1";
        Connection con =FiliereDB.getConnection();
        PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
        ResultSet result =stm.executeQuery();
        
       while(result.next()){
        data.add(new Filiere(result.getInt(1),result.getString(2),result.getInt(3)));
        }
        con.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        numfiliere.setCellValueFactory(new PropertyValueFactory<Filiere, Integer> ("NumFiliere"));
        nomfiliere.setCellValueFactory(new PropertyValueFactory<Filiere, String> ("nomFiliere"));
        nbrAnne.setCellValueFactory(new PropertyValueFactory<Filiere, Integer> ("NbrAnne"));
        table.setItems(data);
    }
    
}
