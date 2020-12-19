/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mayar
 */
public class ConnectionFactory {
    
     ResultSet rs;
     
     Statement stmt;
     Connection con;
    public Connection getConnection() throws ClassNotFoundException {
		 try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?useTimezone=true&serverTimezone=UTC","root","zgD$#WdZb2Dqr7!p");
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
     }
    
   

  
}