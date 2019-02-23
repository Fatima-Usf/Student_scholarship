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

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class ViewStudentFiliereController implements Initializable {

    @FXML
    private JFXTextField nomfil;

     @FXML
    private JFXTextField t;
        
    @FXML
    private JFXTextField y;
   @FXML
    private TableView<Etudiant> table;
 
    @FXML
    private TableColumn<Etudiant, String> nom;

    @FXML
    private TableColumn<Etudiant, String> prenom;

    @FXML
    private TableColumn<Etudiant, Integer> NumCCP;

    @FXML
    private TableColumn<Etudiant, String> dateNaissance;

    
    public ObservableList<Etudiant> data = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
   
    @FXML
    private void getStudentByFiliere(ActionEvent event) {
        t.setText("");
        y.setText("");
        data.clear();
          try{
        String sql= "select nom, prenom, NumCCP, dateNaissance  from Etudiant, Filiere where Etudiant.Numfiliere = Filiere.NumFiliere   and nomFiliere LIKE ?";
        Connection con =DbEtudiant.getConnection();
        PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
         stm.setString(1,nomfil.getText());
        ResultSet result =stm.executeQuery();
        
        while(result.next()){
        data.add(new Etudiant(result.getString(1),result.getString(2),result.getInt(3),result.getString(4)));
        }
        con.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
     //   numEtudiant.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer> ("numEtudiant"));
        nom.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("prenom"));
        NumCCP.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer> ("NumCCP"));
        dateNaissance.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("dateNaissance"));
      //  NumFiliere.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer> ("NumFiliere"));
        
        table.setItems(data);
       // nomfil.setText(" ");
    
    }
    
    
   @FXML 
   private void getStudentByTerme(ActionEvent event) {
    nomfil.setText("");
   data.clear();
    try{
        String sql= "select nom, prenom, NumCCP, dateNaissance from Etudiant, bourse where Etudiant.NumEtudiant = bourse.NumEtudiant and terme=? and AnneeUniv=?";
        Connection con =DbEtudiant.getConnection();
        PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
         stm.setInt(1,Integer.parseInt(t.getText()));
         stm.setInt(2,Integer.parseInt(y.getText()));
        ResultSet result =stm.executeQuery();
        
        while(result.next()){
        data.add(new Etudiant(result.getString(1),result.getString(2),result.getInt(3),result.getString(4)));
        }
        con.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        

        nom.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("prenom"));
        NumCCP.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer> ("NumCCP"));
        dateNaissance.setCellValueFactory(new PropertyValueFactory<Etudiant, String> ("dateNaissance"));

        
        table.setItems(data);
       /* t.setText("");
        y.setText("");*/
   }
   
}
