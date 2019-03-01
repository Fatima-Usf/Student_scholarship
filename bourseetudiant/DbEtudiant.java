/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bourseetudiant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fatima
 */
public class DbEtudiant {



private static final String STUDENT = "CREATE TABLE `bourse`.`Etudiant` (\n" +
"  `NumEtudiant` INT NOT NULL AUTO_INCREMENT,\n" +
"  `nom` VARCHAR(45) NULL,\n" +
"  `prenom` VARCHAR(45) NULL,\n" +
"  `NumCCP` INT NULL,\n" +
"  `dateNaissance` VARCHAR(45) NULL,\n" +
"  `Numfiliere` INT NOT NULL,\n" +
"  PRIMARY KEY (`NumEtudiant`),\n" +
"  INDEX `Numfiliere_idx` (`Numfiliere` ASC),\n" +
"  CONSTRAINT `Numfiliere`\n" +
"    FOREIGN KEY (`Numfiliere`)\n" +
"    REFERENCES `bourse`.`Filiere` (`NumFiliere`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION)";

  public static Connection getConnection() throws Exception {
    String driver = "org.gjt.mm.mysql.Driver";
    String url= "jdbc:mysql://localhost:3306/bourse";
    String username = "root";
    String password = "";
    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }
  
 /* public static void main(String args[]) {
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = getConnection();
      stmt = conn.createStatement();
      stmt.executeUpdate(STUDENT);
      System.out.println(" table etudiant created.");
    } catch (ClassNotFoundException e) {
      System.out.println(" pb de MySQL driver.");
    } catch (SQLException e) {
      System.out.println("pb de connection ");
    } catch (Exception e) {
      System.out.println("other error:");
    } finally {
      try {
        stmt.close();
        conn.close();        
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }*/
  
  // insert
  public static int insert(Etudiant etudiant) throws SQLException, Exception{
      int s =0;
      
      try{
          String sql =" INSERT INTO `bourse`.`Etudiant` (`nom`, `prenom`, `NumCCP`, `dateNaissance`, `Numfiliere`) VALUES (?,?,?,?,?)";
          Connection con =DbEtudiant.getConnection();
          PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
          stm.setString(1, etudiant.getNom());
          stm.setString(2, etudiant.getPrenom());
          stm.setInt(3, etudiant.getNumCCP());
          stm.setString(4, etudiant.getDateNaissance());
          stm.setInt(5, etudiant.getNumFiliere());
          
          s=stm.executeUpdate();
          
          con.close();
      }catch(SQLException e){
      e.printStackTrace();
      }
      return s;
  }
  
  
  //Update
  
  public static int update(Etudiant etudiant) throws SQLException, Exception{
     int s=0;
      try{
          String sql = "UPDATE `bourse`.`Etudiant` SET `nom`=?, `prenom`=?, `NumCCP`=?, `dateNaissance`=?, `Numfiliere`=? WHERE `NumEtudiant`=?";
          Connection con = DbEtudiant.getConnection();
          PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
          
          stm.setString(1, etudiant.getNom());
          stm.setString(2, etudiant.getPrenom());
          stm.setInt(3, etudiant.getNumCCP());
          stm.setString(4, etudiant.getDateNaissance());
          stm.setInt(5, etudiant.getNumFiliere());
          stm.setInt(6, etudiant.getNumEtudiant());
          s=stm.executeUpdate();
          
          con.close();
      }catch(SQLException e){
      e.printStackTrace();
      }return s;
  }
  
  //DELETE
  public static int delete(int id) throws SQLException, Exception{
     int s=0;
      try{
          String sql = "DELETE FROM `bourse`.`Etudiant` WHERE `NumEtudiant`=?";
          Connection con = DbEtudiant.getConnection();
          PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
          stm.setInt(1, id);
          s=stm.executeUpdate();
          con.close();
      }catch(SQLException e){
      e.printStackTrace();
      }return s;
  }
  
  //Search about student using his id
  
    public static Etudiant SearchEtudiantId(int id) throws SQLException, Exception{
     Etudiant etudiant = new Etudiant();
      try{
          String sql = "SELECT * FROM `bourse`.`Etudiant` WHERE `NumEtudiant`=?";
          Connection con = DbEtudiant.getConnection();
          PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
          stm.setInt(1, id);
          ResultSet result =stm.executeQuery();
          
          if(result.next()){
          
              etudiant.setNumEtudiant(result.getInt(1));
              etudiant.setNom(result.getString(2));
              etudiant.setPrenom(result.getString(3));
              etudiant.setNumCCP(result.getInt(4));
              etudiant.setDateNaissance(result.getString(5));
              etudiant.setNumFiliere(result.getInt(6));
          }
          
          con.close();
      }catch(SQLException e){
      e.printStackTrace();
      }return etudiant;
  }
    
    //select nom, prenom  from Etudiant, Filiere where Etudiant.Numfiliere = Filiere.NumFiliere   and nomFiliere ="AI";
    
    
    public static List<Etudiant> getEtudiant() throws Exception{
    List<Etudiant> list = new ArrayList<Etudiant>();
    try{
         String sql= "SELECT * FROM `users` WHERE 1";
         Connection con = DbEtudiant.getConnection();
         PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
         ResultSet result =stm.executeQuery();
    
         while(result.next()){
         Etudiant etudiant = new Etudiant();
         etudiant.setNumEtudiant(result.getInt(1));
         etudiant.setNom(result.getString(2));
         etudiant.setPrenom(result.getString(3));
         etudiant.setNumCCP(result.getInt(4));
         etudiant.setDateNaissance(result.getString(5));
         etudiant.setNumFiliere(result.getInt(6));
         list.add(etudiant);
         }
         con.close();
    }catch(SQLException e){
    e.printStackTrace();}
    return list;
    }
  
  
  
  
}
  
  
  
  


      
       
        

    

