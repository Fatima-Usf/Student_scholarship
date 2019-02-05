/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bourseetudiant;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class ViewStudentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Etudiant> table;
    @FXML
    private TableColumn<Etudiant, Integer>  numEtudiant;

    @FXML
    private TableColumn<Etudiant, String> nom;

    @FXML
    private TableColumn<Etudiant, String> prenom;

    @FXML
    private TableColumn<Etudiant, Integer> NumCCP;

    @FXML
    private TableColumn<Etudiant, String> dateNaissance;

    @FXML
    private TableColumn<Etudiant, Integer> NumFiliere;
    
    public ObservableList<Etudiant> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
        String sql= "SELECT * FROM `Etudiant` WHERE 1";
        Connection con =DbEtudiant.getConnection();
        PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
        ResultSet result =stm.executeQuery();
        
        while(result.next()){
        data.add(new Etudiant(result.getInt(1),result.getString(2),result.getString(3),result.getInt(4),result.getString(5),result.getInt(6)));
        }
        con.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        numEtudiant.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer> ("numEtudiant"));
        nom.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("prenom"));
        NumCCP.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer> ("NumCCP"));
        dateNaissance.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("dateNaissance"));
        NumFiliere.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer> ("NumFiliere"));
        
        table.setItems(data);
    }    
    
    
}
