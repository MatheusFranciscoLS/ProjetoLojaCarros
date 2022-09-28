/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolojacarros;

import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author Aluno
 */
public class Clientes1 implements Serializable{
    
    public String id;
    public String nome;
    public String sobrenome;
    public String idade;
    public String cidade;
    public String cep;

    public Clientes1(String id, String nome, String sobrenome, String idade, String cidade, String cep) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.cidade = cidade;
        this.cep = cep;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
    
}
