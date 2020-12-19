/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Factory.ConnectionFactory;
import Model.Pessoa;
import Model.Usuario;
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
public class UsuarioDao {
     String Nome;
    String Cpf;
    String Sexo;
    String Telefone;
    String User;
    String Senha;
    Boolean Gerente;
    private final Connection connection;
     public UsuarioDao() throws ClassNotFoundException{
         this.connection = new ConnectionFactory().getConnection();
     }
    
    
      public void adiciona(Usuario usuario){ 
        String sql;
        sql = "INSERT INTO usuario(nome,cpf,sexo,telefone,gerente,usuario,senha) VALUES(?,?,?,?,?,?,?)";
        try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getCpf());
                stmt.setString(3, usuario.getSexo());
                stmt.setString(4, usuario.getTelefone());
                stmt.setBoolean(5, usuario.getGerente());
                stmt.setString(6, usuario.getUser());
                stmt.setString(7, usuario.getSenha());
                
                
               
                stmt.execute();
                stmt.close();
                
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
      
      public Usuario buscaUsuario(Usuario usu) throws SQLException{
         
       
         String sql="select *from usuario where nome like '%"+ usu.getPesquisa() +"%'";
        Statement stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         //PreparedStatement stmt=connection.prepareStatement(sql);
         ResultSet rs;
         rs= stmt.executeQuery(sql);
         rs.first();
         
         usu.setId(rs.getInt("Id"));
         usu.setNome(rs.getString("nome"));
         usu.setCpf(rs.getString("cpf"));
         usu.setSexo(rs.getString("sexo"));
         usu.setTelefone(rs.getString("telefone"));
         usu.setGerente(rs.getBoolean("gerente"));
         //usu.setGerente(Boolean.parseBoolean("gerente"));
         usu.setUser(rs.getString("usuario"));
         usu.setSenha(rs.getString("senha"));
         
         
        return usu;
   
     }
      
        public void altera(Usuario usuario) throws SQLException
    {
        String sql="update usuario set nome=?,cpf=?,sexo=?,telefone=?,gerente=?,usuario=?, senha=? where id=?";
        
        try{
            
            PreparedStatement stmt=connection.prepareStatement(sql);
            
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getCpf());
                stmt.setString(3, usuario.getSexo());
                stmt.setString(4, usuario.getTelefone());
                stmt.setBoolean(5, usuario.getGerente());
                stmt.setString(6, usuario.getUser());
                stmt.setString(7, usuario.getSenha());
                stmt.setInt(8, usuario.getId());
                
                stmt.execute();
                
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
            
        
    }
        
        public void excluir(Usuario usuario) throws SQLException{
        
        
        String sql="delete from usuario where id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, usuario.getId());
        stmt.execute();
    }
}
