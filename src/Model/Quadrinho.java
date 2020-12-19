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
public class Quadrinho {
    private Integer Id;
    private String Isbn;
    private String Titulo;
    private String autor;
    private String Editora;
    private String Categoria;
    private Integer volume;
    private String pesquisa;

    /**
     * @return the Isbn
     */
    public String getIsbn() {
        return Isbn;
    }

    /**
     * @param Isbn the Isbn to set
     */
    public void setIsbn(String Isbn) {
        this.Isbn = Isbn;
    }

    /**
     * @return the Titulo
     */
    public String getTitulo() {
        return Titulo;
    }

    /**
     * @param Titulo the Titulo to set
     */
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the Editora
     */
    public String getEditora() {
        return Editora;
    }

    /**
     * @param Editora the Editora to set
     */
    public void setEditora(String Editora) {
        this.Editora = Editora;
    }

    /**
     * @return the Categoria
     */
    public String getCategoria() {
        return Categoria;
    }

    /**
     * @param Categoria the Categoria to set
     */
    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    /**
     * @return the volume
     */
    public Integer getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    /**
     * @return the Id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Integer Id) {
        this.Id = Id;
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
