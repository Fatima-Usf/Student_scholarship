/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bourseetudiant;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class EditeController implements Initializable {
    public static int id;

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
    private JFXButton update;
    @FXML
    private JFXButton delete;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        
              
       
        //get from data base
        Etudiant etudiant;
        try {
        etudiant = DbEtudiant.SearchEtudiantId(id);
        nom.setText(etudiant.getNom());
        prenom.setText(etudiant.getPrenom());
        NumCCP.setText(String.valueOf(etudiant.getNumCCP()));
        dateNaissaince.setText(etudiant.getDateNaissance());
        NumFiliere.setText(String.valueOf(etudiant.getNumFiliere()));
        } catch (Exception ex) {
            Logger.getLogger(EditeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    
        @FXML
    void UpdateStudent(ActionEvent event) throws IOException, Exception  {
       // String myid= id.getText();
       // int idEtudiant =Integer.parseInt(myid);
        
        String name = nom.getText();
        String lastname = prenom.getText();
        int nCCP = Integer.parseInt(NumCCP.getText());
        String naissance = dateNaissaince.getText();
        int nFiliere = Integer.parseInt(NumFiliere.getText());
      
    
        Etudiant etudiant = new Etudiant();
            
            etudiant.setNom(name);
            etudiant.setPrenom(lastname);
            etudiant.setNumCCP(nCCP);
            etudiant.setDateNaissance(naissance);
            etudiant.setNumFiliere(nFiliere);
            etudiant.setNumEtudiant(id);
            int status = DbEtudiant.update(etudiant);
           if (status>0){System.out.println("uppdate succeful");}else{System.out.println(" update failed");}
           //close the previous windows
           ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ViewStudent.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
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
