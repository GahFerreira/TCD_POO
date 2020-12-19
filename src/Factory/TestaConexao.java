/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mayar
 */
public class TestaConexao {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            System.out.println("Conexão aberta!");
        }
     }
    
    
}
