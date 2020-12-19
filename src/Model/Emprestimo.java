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
public class Emprestimo {
    
    
    private Integer Id;
    private String DtEmprestimo;
    private String DtDevolucao;
    private Double Multa;
    private Boolean Status;
    private String pesquisa;
    

    /**
     * @return the DtEmprestimo
     */
    public String getDtEmprestimo() {
        return DtEmprestimo;
    }

    /**
     * @param DtEmprestimo the DtEmprestimo to set
     */
    public void setDtEmprestimo(String DtEmprestimo) {
        this.DtEmprestimo = DtEmprestimo;
    }

    /**
     * @return the DtDevolucao
     */
    public String getDtDevolucao() {
        return DtDevolucao;
    }

    /**
     * @param DtDevolucao the DtDevolucao to set
     */
    public void setDtDevolucao(String DtDevolucao) {
        this.DtDevolucao = DtDevolucao;
    }

    /**
     * @return the Multa
     */
    public Double getMulta() {
        return Multa;
    }

    /**
     * @param Multa the Multa to set
     */
    public void setMulta(Double Multa) {
        this.Multa = Multa;
    }

    /**
     * @return the Status
     */
    public Boolean getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Boolean Status) {
        this.Status = Status;
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
