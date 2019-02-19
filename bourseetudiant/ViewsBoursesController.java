/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bourseetudiant;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
public class ViewsBoursesController implements Initializable {

    @FXML
    private JFXButton vs1;
    @FXML
    private JFXButton vs2;
    @FXML
    private JFXButton vs3;
    @FXML
    private TableView<Bourse> table;
    @FXML
    private TableColumn<Bourse, Integer> anneUniv;
    @FXML
    private TableColumn<Bourse, Integer> terme;
 
    @FXML
    private TableColumn<Bourse, Integer> NumEtudiant;
    @FXML
    private TableColumn<Bourse, Integer> montant;

    
    public ObservableList<Bourse> data = FXCollections.observableArrayList();
    private InvalidationListener listener;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try{
        String sql= "SELECT * FROM `bourse` WHERE 1";
        Connection con =BourseDB.getConnection();
        PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
        ResultSet result =stm.executeQuery();
        
        while(result.next()){
        data.add(new Bourse(result.getInt(1),result.getInt(2),result.getInt(3),result.getInt(4)));
        }
        con.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
        anneUniv.setCellValueFactory(new PropertyValueFactory<Bourse, Integer> ("anneUniv"));
        terme.setCellValueFactory(new PropertyValueFactory<Bourse, Integer> ("terme"));
        NumEtudiant.setCellValueFactory(new PropertyValueFactory<Bourse, Integer> ("numEtudiant"));
        montant.setCellValueFactory(new PropertyValueFactory<Bourse, Integer> ("montant"));
        table.setItems(data);
    }    

    @FXML
    private void back(ActionEvent event) {
           System.out.println(" cc ");
    }

    @FXML
    private void EditeBourse(ActionEvent event) {
        System.out.println(" cc ");
    }

    @FXML
    private void DeleteBourse(ActionEvent event) {
        System.out.println(" cc ");
    }

    @FXML
    private void insertBourse(ActionEvent event) {
        System.out.println(" cc ");
    }
    
}
