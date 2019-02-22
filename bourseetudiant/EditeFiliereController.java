/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bourseetudiant;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class EditeFiliereController implements Initializable {

    @FXML
    private JFXButton update;
    @FXML
    private JFXTextField nomFiliere;
    @FXML
    private JFXTextField nbrAnne;

    /**
     * Initializes the controller class.
     */
    
    static int idFiliere ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Update(ActionEvent event) {
    }
    
}
