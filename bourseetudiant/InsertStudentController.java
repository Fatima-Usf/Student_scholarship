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
import javafx.scene.Node;
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
    private JFXTextField id;

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
    NumFiliere.setText("");
    
   
    
     }
    
     @FXML
    private JFXButton view;

    @FXML
    void ViewStudent(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ViewStudent.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

    }
    

   

    /*@FXML
    void DeleteStudent(ActionEvent event) throws Exception {
        String myid= id.getText();
        int idEtudiant =Integer.parseInt(myid);
      //  DbEtudiant.delete(idEtudiant);
        int status = DbEtudiant.delete(idEtudiant);
     if (status>0){System.out.println("delet succeful");}else{System.out.println("delet failed");}
        

    }
*/
    /*@FXML
    void UpdateStudent(ActionEvent event) throws IOException, Exception  {
        String myid= id.getText();
        int idEtudiant =Integer.parseInt(myid);
        
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
            etudiant.setNumEtudiant(idEtudiant);
            int status = DbEtudiant.update(etudiant);
           if (status>0){System.out.println("succeful");}else{System.out.println("failed");}
    }
*/
 

   /* @FXML
    void getStudentById(ActionEvent event) throws Exception {
        
        String myid= id.getText();
        int idEtudiant =Integer.parseInt(myid);
        //get from data base
        Etudiant etudiant = DbEtudiant.SearchEtudiantId(idEtudiant);
        //modifie le contenu du gui en mettant le contenu de l'étudiant qui dans la fxt search qui provient du BD
        nom.setText(etudiant.getNom());
        prenom.setText(etudiant.getPrenom());
        NumCCP.setText(String.valueOf(etudiant.getNumCCP()));
        dateNaissaince.setText(etudiant.getDateNaissance());
        NumFiliere.setText(String.valueOf(etudiant.getNumFiliere()));
        
    }*/
    
    
    
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