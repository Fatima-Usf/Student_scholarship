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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
    
    @FXML
    private Label succed;
    
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
    
    

    @FXML
    void login(ActionEvent event) throws SQLException, IOException {
        
        List<Admin> list =AdminDB.getAdmins(); //from database
        Map<String, String> map = new HashMap<String,String>();

        for (Admin a:list){
        map.put(a.getUsername(), a.getPassword());
        }
        if(map.containsKey(user.getText())){
            String val =map.get(user.getText());
            if(val.equals(pass.getText())){
            succed.setText(" Success  !!");
            AdminDB.getConnection();
            
            Stage stage = new Stage();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("win2.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            }else{
        succed.setText(" Wrong account!!");}
            
        }else{
        succed.setText(" Wrong account!!");}
    }
}
