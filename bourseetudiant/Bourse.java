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
    private int NumEtudiant;
    private int MontantTerme;
    
    public Bourse(){
    super();
    }

    public Bourse(int anneUniv, int terme, int NumEtudiant, int MontantTerme) {
        this.anneUniv = anneUniv;
        this.terme = terme;
        this.NumEtudiant = NumEtudiant;
        this.MontantTerme = MontantTerme;
    }

    public int getAnneUniv() {
        return anneUniv;
    }

    public int getTerme() {
        return terme;
    }

    public int getNumEtudiant() {
        return NumEtudiant;
    }

    public int getMontantTerme() {
        return MontantTerme;
    }

    public void setAnneUniv(int anneUniv) {
        this.anneUniv = anneUniv;
    }

    public void setTerme(int terme) {
        this.terme = terme;
    }

    public void setNumEtudiant(int NumEtudiant) {
        this.NumEtudiant = NumEtudiant;
    }

    public void setMontantTerme(int MontantTerme) {
        this.MontantTerme = MontantTerme;
    }
    
    
    
  

 
    
    
    
}
