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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author fatima
 */
public class FXMLDocumentController implements Initializable {
    
   
    @FXML
    private JFXButton checkdb;


    @FXML
    private JFXTextField status;

    @FXML
    private JFXTextField user;

    @FXML
    private JFXTextField pass;

    @FXML
    private JFXButton submit;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void statusDB(ActionEvent event)throws IOException, SQLException{
       if(!AdminDB.getConnection().isClosed()){
           status.setText("connected");
       }else{
           status.setText("not connected");}
    }
    
}
