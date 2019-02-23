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
import java.sql.SQLException;
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
public class InsertFiliereController implements Initializable {

    @FXML
    private JFXTextField NumFiliere;
    @FXML
    private JFXTextField nomFiliere;
    @FXML
    private JFXTextField nbrAnne;
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
    private void insertFiliere(ActionEvent event) throws SQLException {
        
        int nFiliere = Integer.valueOf(NumFiliere.getText());
        String nomF = nomFiliere.getText();
        int nbryear = Integer.valueOf(nbrAnne.getText());
        
        Filiere filiere = new Filiere();
        
        filiere.setNumFiliere(nFiliere);
        filiere.setNomFiliere(nomF);
        filiere.setNbrAnne(nbryear);
        
        int status = FiliereDB.insert(filiere);
        
        NumFiliere.setText(" ");
        nomFiliere.setText(" ");
        nbrAnne.setText(" ");
    }
    
        @FXML
    void back(ActionEvent event) throws IOException {
        Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("viewsFiliere.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
    }
    
}
