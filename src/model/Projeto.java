/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Windows
 */
public class Projeto {
    
    private int codprojeto;
    private String nmprojeto;
    private String dsprojeto;
    private String dtinicio;
    private String dtfim;
    private String situacao;

    public int getCodProjeto() {
        return codprojeto;
    }

    public void setCodProjeto(int codprojeto) {
        this.codprojeto = codprojeto;
    }

    public String getNmProjeto() {
        return nmprojeto;
    }

    public void setNmProjeto (String nmprojeto) {
        this.nmprojeto = nmprojeto;
    }

    public String getDsProjeto() {
        return dsprojeto;
    }

    public void setDsProjeto(String dsprojeto) {
        this.dsprojeto = dsprojeto;
    }

    public String getDtIncio() {
        return dtinicio;
    }

    public void setDtIncio(String dtinicio) {
        this.dtinicio = dtinicio;
    }

    public String getDtFim() {
        return dtfim;
    }

    public void setDtFim(String dtfim) {
        this.dtfim = dtfim;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }


}
