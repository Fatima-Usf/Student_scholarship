/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bourseetudiant;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class InsertStudentController implements Initializable {

    final ObservableList data = FXCollections.observableArrayList();
    @FXML
    private JFXComboBox<Filiere> Nfiliere;
  
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
        try{
        String sql= "SELECT NumFiliere, nomFiliere FROM Filiere";
        Connection con =FiliereDB.getConnection();
        PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
        ResultSet result =stm.executeQuery();
        while(result.next()){
           
            data.add(new Filiere(result.getInt(1),result.getString("nomFiliere")).getNomFiliere());
           
            }
        con.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        } 
        
        Nfiliere.setItems(data);
    }
     @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXTextField NumCCP;

    @FXML
    private JFXTextField dateNaissaince;

    @FXML
    private JFXTextField NumFiliere;

    
    @FXML
    private JFXTextField id;
    
    @FXML
    void getId() {
         /*   Nfiliere.setOnKeyReleased((KeyEvent event1) -> {
                if (event1.getCode().equals(KeyCode.ENTER)) {
                    Filiere filiere = Nfiliere.getSelectionModel().getSelectedItem();
                    System.out.println(filiere.getNumFiliere());
                }else System.out.println("coucou");
            });*/
           int filiere = Nfiliere.getSelectionModel().getSelectedIndex();
            System.out.println( filiere);
         
        /* Nfiliere.valueProperty().addListener((obs, oldval, newval) -> {
         if(newval != null)
         System.out.println("filiere " + newval.getNomFiliere()
            + ". ID: " + newval.getNumFiliere());
}); */
       /* Nfiliere.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try{
                    String sql= "SELECT numFiliere FROM Filiere where nomFiliere=? ";
                    Connection con =FiliereDB.getConnection();
                    PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
                    stm.setInt(1, Nfiliere.getSelectionModel().getSelectedItem().getNumFiliere());
                    ResultSet result =stm.executeQuery();
                  
                    con.close();
                }catch (Exception ex) {
                    ex.printStackTrace();
                }   }
        });*/
        }

    @FXML
            
    public void insertStudent(ActionEvent e) throws IOException, Exception{
    // all in String
    String name = nom.getText();
    String lastname = prenom.getText();
    String nCCP = NumCCP.getText();
    String naissance = dateNaissaince.getText();
    int numccp1= Integer.parseInt(nCCP);
    int filiere = Nfiliere.getSelectionModel().getSelectedIndex();
   // int filiere = Integer.parseInt(nFiliere);
    
    //set data
    Etudiant etudiant = new Etudiant();
    etudiant.setNom(name);
    etudiant.setPrenom(lastname);
    etudiant.setNumCCP(numccp1);
    etudiant.setDateNaissance(naissance);
    etudiant.setNumFiliere(filiere);
    
    
    int status =DbEtudiant.insert(etudiant);
    
    nom.setText("");
    prenom.setText("");
    NumCCP.setText("");
    dateNaissaince.setText("");
//    NumFiliere.setText("");
    
   
    
     }
    
     @FXML
    private JFXButton view;

    @FXML
    void ViewStudent(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
      

    }
    
    
    
    
    @FXML
    void back(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("win2.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
    }
   

    
}