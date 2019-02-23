/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bourseetudiant;

/**
 *
 * @author fatima
 */
public class Bourse {
    
    private int anneUniv;
    private int terme;
    private int numEtudiant;
    private int montant;
    
    public Bourse(){
    super();
    }

    public Bourse(int anneUniv, int terme, int numEtudiant, int montant) {
        this.anneUniv = anneUniv;
        this.terme = terme;
        this.numEtudiant = numEtudiant;
        this.montant = montant;
    }

    public Bourse(int terme, int montant) {
        this.terme = terme;
        this.montant = montant;
    }
    
    

    public int getAnneUniv() {
        return anneUniv;
    }

    public int getTerme() {
        return terme;
    }

    public int getNumEtudiant() {
        return numEtudiant;
    }

    public int getMontant() {
        return montant;
    }

    public void setAnneUniv(int anneUniv) {
        this.anneUniv = anneUniv;
    }

    public void setTerme(int terme) {
        this.terme = terme;
    }

    public void setNumEtudiant(int numEtudiant) {
        this.numEtudiant = numEtudiant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    
  

 
    
    
    
}
