/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bourseetudiant;

import static bourseetudiant.AdminDB.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
}
