/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.projetolojacarros;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.*;

/**
 *
 * @author Aluno
 */
public class ProjetoLojaCarros {

    private String carros = "Veiculos";

    private String clientes = "Clientes";

    private String vendas = "Vendas";

    public void janela() throws IOException {

        JFrame jframe = new JFrame("App Loja Carros");
        JTabbedPane jTPane = new JTabbedPane();

        JPanel tab1 = new JPanel();
        tab1.add(new Carros());

        JPanel tab2 = new JPanel();
        tab2.add(new Clientes());

        JPanel tab3 = new JPanel();
        tab3.add(new Vendas1());
 

        jTPane.add(carros, tab1);
        jTPane.add(clientes, tab2);
        jTPane.add(vendas, tab3);

        jframe.add(jTPane);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(600, 200, 700, 700);
        jframe.setVisible(true);

    }

    public static void main(String[] args) throws IOException {

        ProjetoLojaCarros app = new ProjetoLojaCarros();
        app.janela();

    }
}
