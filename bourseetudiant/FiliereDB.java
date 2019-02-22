/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bourseetudiant;

import static bourseetudiant.AdminDB.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fatima
 */
public class FiliereDB {
       
    public static Connection getConnection() {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        String url= "jdbc:mysql://localhost:3306/bourse";
        con = DriverManager.getConnection(url,"root","");
          
        } catch(ClassNotFoundException|SQLException e){
        
        }
        return con;
    }
    
    
    //requette
    public static int insert (Filiere filiere) throws SQLException{
         
        int s =0;
        try{
            String sql = "insert into Filiere (NumFiliere, nomFiliere, NbrAnne) values (?,?,?)";
            Connection con = FiliereDB.getConnection();
            PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
            stm.setInt(1, filiere.getNumFiliere());
            stm.setString(2, filiere.getNomFiliere());
            stm.setInt(3, filiere.getNbrAnne());
            s= stm.executeUpdate();
            con.close();
        }catch(SQLException e){
      e.printStackTrace();
      }
      return s;
    
    }
    
    
    
    //Update
  
  public static int update(Filiere filiere) throws SQLException, Exception{
     int s=0;
      try{
          String sql = "UPDATE Filiere SET `nomFiliere`=? ,`NbrAnne`=? WHERE `NumFiliere`=?";
            PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
            
            stm.setString(1, filiere.getNomFiliere());
            stm.setInt(2, filiere.getNbrAnne());
            stm.setInt(3, filiere.getNumFiliere());
            s= stm.executeUpdate();
            con.close();
         
      }catch(SQLException e){
      e.printStackTrace();
      }return s;
  }
  
  //DELETE
  public static int delete(int id) throws SQLException, Exception{
     int s=0;
      try{
          String sql = "DELETE FROM Filiere WHERE `NumFiliere`=?";
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
  
    public static Filiere SearchEtudiantId(int id) throws SQLException, Exception{
    Filiere filiere = new Filiere();
      try{
          String sql = "SELECT * FROM Filiere WHERE `NumFiliere`=?";
          Connection con = DbEtudiant.getConnection();
          PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
          stm.setInt(1, id);
          ResultSet result =stm.executeQuery();
          
          if(result.next()){
              
              filiere.setNumFiliere(result.getInt(1));
              filiere.setNomFiliere(result.getString(2));
              filiere.setNbrAnne(result.getInt(3));
          
           
          }
          
          con.close();
      }catch(SQLException e){
      e.printStackTrace();
      }return filiere;
  }
    
    
    
    
 
  
  
}
