/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mayar
 */
public class Cliente extends Pessoa {
  /*  private Integer Id;
    private String Nome;
    private String Cpf;
     private String Sexo;
    private String telefone;*/
    private String Endereco;
    private String pesquisa;
   
    public Cliente(){
        super();
    }

    
    
       public String getEndereco() {
        return Endereco;
    }

    /**
     * @param Endereco the Endereco to set
     */
       
    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

  
    
    
}
