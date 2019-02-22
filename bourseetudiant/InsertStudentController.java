/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bourseetudiant;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class InsertStudentController implements Initializable {

    final ObservableList data = FXCollections.observableArrayList();
    @FXML
    private JFXComboBox<Filiere> Nfiliere;
    /**
     * Initializes the controller class.
     * 
     *     public void initialize(URL url, ResourceBundle rb) {
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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
        try{
        String sql= "SELECT NumFiliere, nomFiliere FROM Filiere";
        Connection con =FiliereDB.getConnection();
        PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
        ResultSet result =stm.executeQuery();
        while(result.next()){
           
            data.add(new Filiere(result.getInt(1),result.getString("nomFiliere")).getNomFiliere());
           
            }
        con.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        } 
        
   
        /*
        Nfiliere.setConverter(new StringConverter<Filiere>() {

    @Override
    public String toString(Filiere object) {
        return object.getNomFiliere();
    }

    @Override
    public Filiere fromString(String string) {
        return Nfiliere.getItems().stream().filter(ap -> 
            ap.getNomFiliere().equals(string)).findFirst().orElse(null);
    }
});
        */
        
       /* Nfiliere.setConverter(new StringConverter<Filiere>() {

            @Override
            public String toString(Filiere object) {
                return object.getNomFiliere();
            }

            @Override
            public Filiere fromString(String string) {
                // TODO Auto-generated method stub
                return null;
            }
        });*/
        Nfiliere.setItems(data);
    }
     @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXTextField NumCCP;

    @FXML
    private JFXTextField dateNaissaince;

    @FXML
    private JFXTextField NumFiliere;

    
    @FXML
    private JFXTextField id;
    
    @FXML
    void getId() {
         /*   Nfiliere.setOnKeyReleased((KeyEvent event1) -> {
                if (event1.getCode().equals(KeyCode.ENTER)) {
                    Filiere filiere = Nfiliere.getSelectionModel().getSelectedItem();
                    System.out.println(filiere.getNumFiliere());
                }else System.out.println("coucou");
            });*/
            int filiere = Nfiliere.getSelectionModel().getSelectedIndex();
            System.out.println( filiere);
         
        /* Nfiliere.valueProperty().addListener((obs, oldval, newval) -> {
         if(newval != null)
         System.out.println("filiere " + newval.getNomFiliere()
            + ". ID: " + newval.getNumFiliere());
}); */
       /* Nfiliere.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try{
                    String sql= "SELECT * FROM Filiere where nomFiliere=? ";
                    Connection con =FiliereDB.getConnection();
                    PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
                    stm.setInt(1, Nfiliere.getSelectionModel().getSelectedItem());
                    ResultSet result =stm.executeQuery();
                    
                    con.close();
                }catch (Exception ex) {
                    ex.printStackTrace();
                }   }
        });*/
        }

    @FXML
            
    public void insertStudent(ActionEvent e) throws IOException, Exception{
    // all in String
    String name = nom.getText();
    String lastname = prenom.getText();
    String nCCP = NumCCP.getText();
    String naissance = dateNaissaince.getText();
   // String nFiliere = NumFiliere.getText();
    //int filiere = Nfiliere.getSelectionModel().getSelectedItem().getNumFiliere();
    //to int
    int numccp1= Integer.parseInt(nCCP);
    int filiere = Nfiliere.getSelectionModel().getSelectedIndex();
   // int filiere = Integer.parseInt(nFiliere);
    
    //set data
    Etudiant etudiant = new Etudiant();
    etudiant.setNom(name);
    etudiant.setPrenom(lastname);
    etudiant.setNumCCP(numccp1);
    etudiant.setDateNaissance(naissance);
    etudiant.setNumFiliere(filiere);
    
    
    int status =DbEtudiant.insert(etudiant);
    
    nom.setText("");
    prenom.setText("");
    NumCCP.setText("");
    dateNaissaince.setText("");
    NumFiliere.setText("");
    
   
    
     }
    
     @FXML
    private JFXButton view;

    @FXML
    void ViewStudent(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ViewStudent.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

    }
    

   

    /*@FXML
    void DeleteStudent(ActionEvent event) throws Exception {
        String myid= id.getText();
        int idEtudiant =Integer.parseInt(myid);
      //  DbEtudiant.delete(idEtudiant);
        int status = DbEtudiant.delete(idEtudiant);
     if (status>0){System.out.println("delet succeful");}else{System.out.println("delet failed");}
        

    }
*/
    /*@FXML
    void UpdateStudent(ActionEvent event) throws IOException, Exception  {
        String myid= id.getText();
        int idEtudiant =Integer.parseInt(myid);
        
        String name = nom.getText();
        String lastname = prenom.getText();
        int nCCP = Integer.parseInt(NumCCP.getText());
        String naissance = dateNaissaince.getText();
        int nFiliere = Integer.parseInt(NumFiliere.getText());
      
    
        Etudiant etudiant = new Etudiant();
            
            etudiant.setNom(name);
            etudiant.setPrenom(lastname);
            etudiant.setNumCCP(nCCP);
            etudiant.setDateNaissance(naissance);
            etudiant.setNumFiliere(nFiliere);
            etudiant.setNumEtudiant(idEtudiant);
            int status = DbEtudiant.update(etudiant);
           if (status>0){System.out.println("succeful");}else{System.out.println("failed");}
    }
*/
 

   /* @FXML
    void getStudentById(ActionEvent event) throws Exception {
        
        String myid= id.getText();
        int idEtudiant =Integer.parseInt(myid);
        //get from data base
        Etudiant etudiant = DbEtudiant.SearchEtudiantId(idEtudiant);
        //modifie le contenu du gui en mettant le contenu de l'étudiant qui dans la fxt search qui provient du BD
        nom.setText(etudiant.getNom());
        prenom.setText(etudiant.getPrenom());
        NumCCP.setText(String.valueOf(etudiant.getNumCCP()));
        dateNaissaince.setText(etudiant.getDateNaissance());
        NumFiliere.setText(String.valueOf(etudiant.getNumFiliere()));
        
    }*/
    
    
    
    @FXML
    void back(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("win2.fxml"));
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
    }
   

    
}