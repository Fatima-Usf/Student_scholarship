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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

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
     
        Filiere filiere;
        try{
        filiere =FiliereDB.SearchEtudiantId(idFiliere);
        nomFiliere.setText(filiere.getNomFiliere());
        nbrAnne.setText(String.valueOf(filiere.getNbrAnne()));
        
        } catch (Exception ex) {
            Logger.getLogger(EditeFiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void Update(ActionEvent event) throws Exception {
        
            
       /*int myterme = Integer.parseInt(terme.getText());
       int NEtudiant = Integer.parseInt(NumEtudiant.getText());
       int mont = Integer.parseInt(montant.getText());
       
       Bourse bourse = new Bourse();
       
       bourse.setTerme(myterme);
       bourse.setNumEtudiant(NEtudiant);
       bourse.setMontant(mont);
       bourse.setAnneUniv(id);
       int status = BourseDB.updateBourse(bourse);
       
           if (status>0){System.out.println("uppdate succeful");}else{System.out.println(" update failed");}
           //close the previous windows
           ((Node)event.getSource()).getScene().getWindow().hide();*/
       
       
       String name = nomFiliere.getText();
       int nbrYear = Integer.parseInt(nbrAnne.getText());
       Filiere filiere= new Filiere();
       filiere.setNomFiliere(name);
       filiere.setNbrAnne(nbrYear);
       filiere.setNumFiliere(idFiliere);
       
       int status = FiliereDB.update(filiere);
       if (status>0){System.out.println("uppdate succeful");}else{System.out.println(" update failed");}
           //close the previous windows
           ((Node)event.getSource()).getScene().getWindow().hide();
       
       
    }
    
    
}
