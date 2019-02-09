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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class InsertStudentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private JFXButton add;
    
    
    @FXML
            
    public void insertStudent(ActionEvent e) throws IOException, Exception{
    // all in String
    String name = nom.getText();
    String lastname = prenom.getText();
    String nCCP = NumCCP.getText();
    String naissance = dateNaissaince.getText();
    String nFiliere = NumFiliere.getText();
    
    //to int
    int numccp1= Integer.parseInt(nCCP);
    int filiere = Integer.parseInt(nFiliere);
    
    //get data
    Etudiant etudiant = new Etudiant();
    etudiant.setNom(name);
    etudiant.setPrenom(lastname);
    etudiant.setNumCCP(numccp1);
    etudiant.setDateNaissance(naissance);
    etudiant.setNumFiliere(filiere);
    
    
    int status =DbEtudiant.insert(etudiant);
   
    
     }
    
     @FXML
    private JFXButton view;

    @FXML
    void ViewStudent(ActionEvent event) throws IOException {
        Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ViewStudent.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

    }

    
    
}
