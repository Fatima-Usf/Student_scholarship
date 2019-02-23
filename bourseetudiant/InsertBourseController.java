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
public class InsertBourseController implements Initializable {

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
        // TODO
    }    

      @FXML
            
    public void insertBourse(ActionEvent e) throws IOException, Exception{
   
       int year = Integer.parseInt(anneUniv.getText());
       int myterme = Integer.parseInt(terme.getText());
       int NEtudiant = Integer.parseInt(NumEtudiant.getText());
       int mont = Integer.parseInt(montant.getText());

        Bourse bourse = new Bourse();
        bourse.setAnneUniv(year);
        bourse.setTerme(myterme);
        bourse.setNumEtudiant(NEtudiant);
        bourse.setMontant(mont);
    
        int status = BourseDB.insertBourse(bourse);
    
        anneUniv.setText("");
        terme.setText("");
        NumEtudiant.setText("");
        montant.setText("");

   
    
     }
    
         @FXML
    void back(ActionEvent event) throws IOException {
        Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ViewsBourses.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
    }
    
}
