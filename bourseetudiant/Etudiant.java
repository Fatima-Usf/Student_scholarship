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
public class Etudiant {
    /* "create table Etudiant ( "
      + "   NumEtudiant INT PRIMARY KEY AUTO_INCREMENT, nom VARCHAR(20), prenom VARCHAR(20), "
      + "   dataNaissance VARCHAR(20), NumCCP INT, FOREING KEY (NumFiliere) REFERENCES Filiere(NumFiliere)"; */
    
    
    private int NumEtudiant;
    private String nom;
    private String prenom;
    private int numCCP;
    private String dateNaissance;
    private int numFiliere; 
    private int montant;
    private String nomFiliere;



    public Etudiant() {
        super();
    }

    
    public Etudiant(int NumEtudiant, String nom, String prenom, int numCCP, String dateNaissance, int numFiliere) {
        this.NumEtudiant = NumEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.numCCP = numCCP;
        this.dateNaissance = dateNaissance;
        this.numFiliere = numFiliere;
    }
    
     public Etudiant(int NumEtudiant, String nom, String prenom, int numCCP, String dateNaissance, int numFiliere, String nomFiliere) {
        this.NumEtudiant = NumEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.numCCP = numCCP;
        this.dateNaissance = dateNaissance;
        this.numFiliere = numFiliere;
        this.nomFiliere= nomFiliere;
    }

    public Etudiant(String nom, String prenom, int numCCP, String dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.numCCP = numCCP;
        this.dateNaissance = dateNaissance;
    }

    public Etudiant(String nom, String prenom, int numCCP, String dateNaissance, int montant) {
        this.nom = nom;
        this.prenom = prenom;
        this.numCCP = numCCP;
        this.dateNaissance = dateNaissance;
        this.montant= montant;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

   
    
    
    
    public int getNumEtudiant() {
        return NumEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public int getNumCCP() {
        return numCCP;
    }

    public int getNumFiliere() {
        return numFiliere;
    }

    public void setNumEtudiant(int NumEtudiant) {
        this.NumEtudiant = NumEtudiant;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setNumCCP(int numCCP) {
        this.numCCP = numCCP;
    }

    public void setNumFiliere(int numFiliere) {
        this.numFiliere = numFiliere;
    }
    
        public void setMontant(int montant) {
        this.montant = montant;
    }

    public int getMontant() {
        return montant;
    }
}
