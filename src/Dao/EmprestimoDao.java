/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Factory.ConnectionFactory;
import Model.Emprestimo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author mayar
 */
public class EmprestimoDao {
    private final Connection connection;
    Integer Id;
    String DtEmprestimo;
    String DtDevolucao;
    Double Multa;
    Boolean Status;
    
     public EmprestimoDao() throws ClassNotFoundException{
         this.connection = new ConnectionFactory().getConnection();
     }
     
     
     public void adiciona(Emprestimo emprestimo){ 
        String sql;
        sql = "INSERT INTO emprestimo(dtemprestimo,dtdevolucao,multa,status) VALUES(STR_TO_DATE(?,'%M %d %Y'),STR_TO_DATE(?,'%M %d %Y'),?,?)";
        try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                
                stmt.setString(1, emprestimo.getDtEmprestimo());
                stmt.setString(2, emprestimo.getDtDevolucao());
                stmt.setDouble(3, emprestimo.getMulta());
                stmt.setBoolean(4, emprestimo.getStatus());
               
                stmt.execute();
                stmt.close();
                
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    }
     
     
     public Emprestimo buscaEmprestimo(Emprestimo emp) throws SQLException{
         
       
         String sql="select *from emprestimo where multa= " +emp.getPesquisa();
        Statement stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         //PreparedStatement stmt=connection.prepareStatement(sql);
         ResultSet rs;
         rs= stmt.executeQuery(sql);
         rs.first();
         
         emp.setId(rs.getInt("Id"));
         emp.setDtEmprestimo(rs.getString("dtemprestimo"));
         emp.setDtDevolucao(rs.getString("dtdevolucao"));
         emp.setMulta(rs.getDouble("multa"));
         emp.setStatus(rs.getBoolean("status"));
        
         
        return emp;
   
     }
     
    public void altera(Emprestimo emprestimo) throws SQLException
    {
        String sql="update emprestimo set dtemprestimo=?,dtdevolucao=?,multa=?,status=? where id=?";
        
        try{
            
            PreparedStatement stmt=connection.prepareStatement(sql);
            
                stmt.setString(1, emprestimo.getDtEmprestimo());
                stmt.setString(2, emprestimo.getDtDevolucao());
                stmt.setDouble(3, emprestimo.getMulta());
                stmt.setBoolean(4, emprestimo.getStatus());
                stmt.setInt(5, emprestimo.getId());
                
                stmt.execute();
                
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
            
        
    }
    
    public void excluir(Emprestimo emprestimo) throws SQLException{
        
        
        String sql="delete from emprestimo where id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, emprestimo.getId());
        stmt.execute();
    }
    
     
}
