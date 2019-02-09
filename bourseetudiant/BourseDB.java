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
import java.sql.SQLException;

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
          stm.setInt(4, bourse.getMontantTerme());
          
          s=stm.executeUpdate();
          
          con.close();
      }catch(SQLException e){
      e.printStackTrace();
      }
      return s;
  }
    
    //delete bourse 
    
    public static int deleteBourse(int id) throws SQLException, Exception{
     int s=0;
      try{
          String sql = "DELETE FROM `bourse`.`bourse` WHERE `AnneeUniv`='?' and`NumEtudiant`='?' and`terme`='?'";
          Connection con = DbEtudiant.getConnection();
          PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
          stm.setInt(1, id);
          s=stm.executeUpdate();
          con.close();
      }catch(SQLException e){
      e.printStackTrace();
      }return s;
  }
    
    
    
}
