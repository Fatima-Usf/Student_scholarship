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
public class BourseDB {
   
    public static Connection getConnection() {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        String url= "jdbc:mysql://localhost:3306/bourse";
        con = DriverManager.getConnection(url,"root","");
          
        } catch(ClassNotFoundException|SQLException e){
        
        }
        return con;
    } 
    
    /*    
    private int anneUniv;
    private int terme;
    private int NumEtudiant;
    private int MontantTerme;*/
   
    
    //Insertion d'une bourse
    
    public static int insertBourse(Bourse bourse) throws SQLException, Exception{
      int s =0;
      
      try{
          String sql =" INSERT INTO `bourse`.`bourse` (`anneUniv`, `terme`, `NumEtudiant`, `MontantTerme`) VALUES (?,?,?,?)";
          Connection con =DbEtudiant.getConnection();
          PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
          stm.setInt(1, bourse.getAnneUniv());
          stm.setInt(2, bourse.getTerme());
          stm.setInt(3, bourse.getNumEtudiant());
          stm.setInt(4, bourse.getMontant());
          
          s=stm.executeUpdate();
          
          con.close();
      }catch(SQLException e){
      e.printStackTrace();
      }
      return s;
  }
    
    //delete bourse by Anne
    
    public static int deleteBourse(int id) throws SQLException, Exception{
     int s=0;
      try{
          String sql = "DELETE FROM `bourse`.`bourse` WHERE `AnneeUniv`='?'";
          Connection con = DbEtudiant.getConnection();
          PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
          stm.setInt(1, id);
          s=stm.executeUpdate();
          con.close();
      }catch(SQLException e){
      e.printStackTrace();
      }return s;
  }
    
    
    //delete bourse by student
    
    public static int deleteBourseStudent(int id) throws SQLException, Exception{
     int s=0;
      try{
          String sql = "DELETE FROM `bourse`.`bourse` WHERE `NumEtudiant`='?'";
          Connection con = DbEtudiant.getConnection();
          PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
          stm.setInt(1, id);
          s=stm.executeUpdate();
          con.close();
      }catch(SQLException e){
      e.printStackTrace();
      }return s;
  }
    
    public static List<Bourse> getbourse() throws Exception{
    List<Bourse> list = new ArrayList<Bourse>();
    try{
         String sql= "SELECT * FROM `bourse` WHERE 1";
         Connection con = DbEtudiant.getConnection();
         PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
         ResultSet result =stm.executeQuery();
    
         while(result.next()){
         Bourse etudiant = new Bourse();
         etudiant.setAnneUniv(1);
         etudiant.setTerme(2);
         etudiant.setNumEtudiant(result.getInt(3));
         etudiant.setMontant(4);
         list.add(etudiant);
         }
         con.close();
    }catch(SQLException e){
    e.printStackTrace();}
    return list;
    }
  
    
}
