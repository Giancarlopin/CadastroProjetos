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
public class Funcionario {
    
    private int codfuncionario;
    private String nome;
    private String cpf;
    private String telefone;
    private String cargo;
    private int codcidade;

    public int getCodFuncionario() {
        return codfuncionario;
    }

    public void setCodFuncionario(int codfuncionario) {
        this.codfuncionario = codfuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCodcidade() {
        return codcidade;
    }

    public void setCodcidade(int codcidade) {
        this.codcidade = codcidade;
    }


}
