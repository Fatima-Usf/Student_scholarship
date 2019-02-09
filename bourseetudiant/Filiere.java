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
public class Filiere {
    
    private int NumFiliere;
    private String nomFiliere;
    private int NbrAnne;

    public Filiere() {
        super();
    }

    public Filiere(int NumFiliere, String nomFiliere, int NbrAnne) {
        this.NumFiliere = NumFiliere;
        this.nomFiliere = nomFiliere;
        this.NbrAnne = NbrAnne;
    }

   
    
    
    public int getNumFiliere() {
        return NumFiliere;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public int getNbrAnne() {
        return NbrAnne;
    }

    public void setNumFiliere(int NumFiliere) {
        this.NumFiliere = NumFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

    public void setNbrAnne(int NbrAnne) {
        this.NbrAnne = NbrAnne;
    }
    
    
    
    
    
    
}
