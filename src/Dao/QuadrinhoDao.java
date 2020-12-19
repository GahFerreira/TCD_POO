/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Factory.ConnectionFactory;
import Model.Quadrinho;
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
public class QuadrinhoDao {
     private final Connection connection;
        Integer Id;
        String Isbn;
        String Titulo;
        String autor;
        String Editora;
        String Categoria;
        Integer volume;
        
         public QuadrinhoDao() throws ClassNotFoundException{
         this.connection = new ConnectionFactory().getConnection();
          }
         
          public void adiciona(Quadrinho quadrinho){ 
        String sql;
        sql = "INSERT INTO quadrinho(isbn,titulo,autor,editora,categoria,volume) VALUES(?,?,?,?,?,?)";
        try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                
                stmt.setString(1, quadrinho.getIsbn());
                stmt.setString(2, quadrinho.getTitulo());
                stmt.setString(3, quadrinho.getAutor());
                stmt.setString(4, quadrinho.getEditora());
                stmt.setString(5, quadrinho.getCategoria());
                stmt.setInt(6, quadrinho.getVolume());
                
                
               
                stmt.execute();
                stmt.close();
                
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    }
          
      
         public Quadrinho buscaQuadrinho(Quadrinho quad) throws SQLException{
         
       
         String sql="select *from quadrinho where titulo like '%"+ quad.getPesquisa() +"%'";
        Statement stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         //PreparedStatement stmt=connection.prepareStatement(sql);
         ResultSet rs;
         rs= stmt.executeQuery(sql);
         rs.first();
         
         quad.setId(rs.getInt("Id"));
         quad.setIsbn(rs.getString("isbn"));
         quad.setTitulo(rs.getString("titulo"));
         quad.setAutor(rs.getString("autor"));
         quad.setEditora("editora");
         quad.setCategoria(rs.getString("categoria"));
         quad.setVolume(rs.getInt("volume"));
         
         
        return quad;
   
     }
      
        public void altera(Quadrinho quadrinho) throws SQLException
    {
        String sql="update quadrinho set isbn=?,titulo=?,autor=?,editora=?,categoria=?,volume=? where id=?";
        
        try{
            
            PreparedStatement stmt=connection.prepareStatement(sql);
            
                stmt.setString(1, quadrinho.getIsbn());
                stmt.setString(2, quadrinho.getTitulo());
                stmt.setString(3, quadrinho.getAutor());
                stmt.setString(4, quadrinho.getEditora());
                stmt.setString(5, quadrinho.getCategoria());
                stmt.setInt(6, quadrinho.getVolume());
                stmt.setInt(7, quadrinho.getId());
                
                stmt.execute();
                
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
            
        
    }
        
        public void excluir(Quadrinho quadrinho) throws SQLException{
        
        
        String sql="delete from quadrinho where id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, quadrinho.getId());
        stmt.execute();
    }
    
}
