/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Factory.ConnectionFactory;
import Model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author mayar
 */
public class VendaDao {
    private final Connection connection;
     String DtCompra;
     Double valor;
     
      public VendaDao() throws ClassNotFoundException{
         this.connection = new ConnectionFactory().getConnection();
     }
      
      public void adiciona(Venda venda){ 
        String sql;
        sql = "INSERT INTO venda(datacompra,valor) VALUES(STR_TO_DATE(?,'%M %d %Y'),?)";
        try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                
                stmt.setString(1, venda.getDtCompra());
                stmt.setDouble(2, venda.getValor());
                
               
                stmt.execute();
                stmt.close();
                
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
      
       public Venda buscaVenda(Venda venda) throws SQLException{
         
       
         String sql="select *from venda where valor= "+ venda.getPesquisa();
        Statement stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         //PreparedStatement stmt=connection.prepareStatement(sql);
         ResultSet rs;
         rs= stmt.executeQuery(sql);
         rs.first();
         
         venda.setId(rs.getInt("Id"));
         venda.setDtCompra(rs.getString("datacompra"));
         venda.setValor(rs.getDouble("valor"));
         
         
        return venda;
   
     }
       
            public void altera(Venda venda) throws SQLException
    {
        String sql="update venda set datacompra=?,valor=? where id=?";
        
        try{
            
            PreparedStatement stmt=connection.prepareStatement(sql);
            
                stmt.setString(1, venda.getDtCompra());
                stmt.setDouble(2, venda.getValor());
                stmt.setInt(3, venda.getId());
                
                stmt.execute();
                
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
              
    }
       public void excluir(Venda venda) throws SQLException{
        
        
        String sql="delete from venda where id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, venda.getId());
        stmt.execute();
    }
      
}
