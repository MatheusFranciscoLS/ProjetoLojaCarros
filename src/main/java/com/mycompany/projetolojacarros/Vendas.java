/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolojacarros;

import java.io.Serializable;

/**
 *
 * @author Aluno
 */
public class Vendas implements Serializable{
    
    public String carro;
    public String Cliente;
    public String valorVenda;
    public String formaPagamento;
    public String dataVenda;

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Vendas(String carro, String Cliente, String valorVenda, String formaPagamento, String dataVenda) {
        this.carro = carro;
        this.Cliente = Cliente;
        this.valorVenda = valorVenda;
        this.formaPagamento = formaPagamento;
        this.dataVenda = dataVenda;
    }
    
    
    
}
