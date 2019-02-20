/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bourseetudiant;


import static bourseetudiant.EditeController.id;
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
public class EditeBourseController implements Initializable {

    public static int id;
    @FXML
    private JFXTextField anneUniv;
    @FXML
    private JFXTextField terme;
    @FXML
    private JFXTextField NumEtudiant;
    @FXML
    private JFXTextField montant;
    @FXML
    private JFXButton add;
    @FXML
    private JFXButton view;

    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
          //get from data base
        Bourse bourse;
        try {
        bourse = BourseDB.SearchEtudiantAnne(id);
        
        anneUniv.setText(String.valueOf(bourse.getAnneUniv()));
        terme.setText(String.valueOf(bourse.getTerme()));
        NumEtudiant.setText(String.valueOf(bourse.getNumEtudiant()));
        montant.setText(String.valueOf(bourse.getMontant()));
         } catch (Exception ex) {    
            Logger.getLogger(EditeBourseController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    
}
@FXML
 public void Update(ActionEvent event) throws IOException, Exception  {
     
      
       int myterme = Integer.parseInt(terme.getText());
       int NEtudiant = Integer.parseInt(NumEtudiant.getText());
       int mont = Integer.parseInt(montant.getText());
       
       Bourse bourse = new Bourse();
       
       bourse.setTerme(myterme);
       bourse.setNumEtudiant(NEtudiant);
       bourse.setMontant(mont);
       bourse.setAnneUniv(id);
       int status = BourseDB.updateBourse(bourse);
       
           if (status>0){System.out.println("uppdate succeful");}else{System.out.println(" update failed");}
           //close the previous windows
           ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ViewsBourses.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            
 

}




 

}