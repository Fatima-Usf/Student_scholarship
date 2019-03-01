/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bourseetudiant;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class SpeedSearchBourseController implements Initializable {

    @FXML
    private AnchorPane year;
    @FXML
    private JFXTextField nomfil;
    @FXML
    private TableView<Bourse> table;
    @FXML
    private TableColumn<Bourse, Integer> term;
    @FXML
    private TableColumn<Bourse, Integer> montant;
    @FXML
    private JFXTextField y;
    @FXML
    private JFXButton find11;

    public ObservableList<Bourse> data = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void find(ActionEvent event) {
        
        try{
        String sql= "select terme, MontantTerme from Etudiant, bourse, Filiere  where Etudiant.NumEtudiant = bourse.NumEtudiant and Etudiant.Numfiliere = Filiere.NumFiliere and nomFiliere =? and AnneeUniv =?";
        Connection con =BourseDB.getConnection();
        PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
        stm.setString(1,nomfil.getText());
        stm.setInt(2,Integer.parseInt(y.getText()));
        ResultSet result =stm.executeQuery();
        
        while(result.next()){
        data.add(new Bourse(result.getInt(1),result.getInt(2)));
        }
        con.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        term.setCellValueFactory(new PropertyValueFactory<Bourse, Integer> ("terme"));
        montant.setCellValueFactory(new PropertyValueFactory<Bourse, Integer> ("montant"));
        table.setItems(data);
    }
}
