/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Factory.ConnectionFactory;
import java.sql.Connection;
import Model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author mayar
 */
public class ClienteDao {
    
    private final Connection connection;
     Integer Id;
     String Nome;
     String Cpf;
     String Endereco;
     String Sexo;
     String telefone;
     
     public ClienteDao() throws ClassNotFoundException{
         this.connection = new ConnectionFactory().getConnection();
     }
     
     public void adiciona(Cliente cliente){ 
        String sql = "INSERT INTO cliente(nome,cpf,endereco,sexo,telefone) VALUES(?,?,?,?,?)";
        try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                
                
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getEndereco());
                stmt.setString(4, cliente.getSexo());
                stmt.setString(5, cliente.getTelefone());
                
               
                stmt.execute();
                stmt.close();
                
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    }
     
                 
    public Cliente buscaCliente(Cliente cli) throws SQLException{
         
       
         String sql="select *from cliente where nome like '%"+ cli.getPesquisa() +"%'";
        Statement stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         //PreparedStatement stmt=connection.prepareStatement(sql);
         ResultSet rs;
         rs= stmt.executeQuery(sql);
         rs.first();
         
         cli.setId(rs.getInt("Id"));
         cli.setNome(rs.getString("nome"));
         cli.setCpf(rs.getString("cpf"));
         cli.setEndereco(rs.getString("endereco"));
         cli.setSexo(rs.getString("sexo"));
         cli.setTelefone(rs.getString("telefone"));
         
         
        return cli;
   
     }
     
    public void altera(Cliente cliente) throws SQLException
    {
        String sql="update cliente set nome=?,cpf=?,endereco=?,sexo=?,telefone=? where id=?";
        
        try{
            
            PreparedStatement stmt=connection.prepareStatement(sql);
            
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getEndereco());
                stmt.setString(4, cliente.getSexo());
                stmt.setString(5, cliente.getTelefone());
                stmt.setInt(6, cliente.getId());
                
                stmt.execute();
                
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
            
        
    }
    
    public void excluir(Cliente cliente) throws SQLException{
        
        
        String sql="delete from cliente where id=?";
        PreparedStatement stmt=connection.prepareStatement(sql);
        stmt.setInt(1, cliente.getId());
        stmt.execute();
    }
    
     
    
}
