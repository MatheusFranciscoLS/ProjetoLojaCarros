/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolojacarros;

/**
 *
 * @author Aluno
 */
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.table.DefaultTableModel;

public class Carros extends JPanel {

    ArrayList<Carros1> listaCarros = new ArrayList<>();

    private JButton cadastrar, cancelar, apagar, consultar, editar, gravar;
    private JTextField marca1;
    private JTextField modelo1;
    private JTextField ano1;
    private JTextField cor1;
    private JTextField valor1;

    private JTable jTable;

    public Carros() {
        listaCarros = EmpacotamentoCarros.lerArquivoCarros("carros.dat");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Marca");
        marca1 = new JTextField(15);
        JLabel label1 = new JLabel("Modelo");
        modelo1 = new JTextField(15);
        JLabel label2 = new JLabel("Ano");
        ano1 = new JTextField(15);
        JLabel label3 = new JLabel("Cor");
        cor1 = new JTextField(15);
        JLabel label4 = new JLabel("Valor");
        valor1 = new JTextField(15);

        add(label);
        add(marca1);
        add(label1);
        add(modelo1);
        add(label2);
        add(ano1);
        add(label3);
        add(cor1);
        add(label4);
        add(valor1);

        JPanel botoes = new JPanel();

        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(cancelar = new JButton("Cancelar"));
        botoes.add(consultar = new JButton("Consultar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        botoes.add(gravar = new JButton("Gravar"));
        add(botoes);
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        jTable = new JTable();
        jTable.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"Marca", "Modelo", "Ano", "Cor", "Valor"}));
        jSPane.setViewportView(jTable);

        Handler1 handler1 = new Handler1();
        cadastrar.addActionListener(handler1);

        Handler2 handler2 = new Handler2();
        cancelar.addActionListener(handler2);

        Handler3 handler3 = new Handler3();
        consultar.addActionListener(handler3);

        Handler4 handler4 = new Handler4();
        editar.addActionListener(handler4);

        Handler5 handler5 = new Handler5();
        apagar.addActionListener(handler5);

        Handler6 handler6 = new Handler6();
        gravar.addActionListener(handler6);
        atualizarTabela();

    }

    // add linhas do array list ao jtable (metodo para atualizar a tabela)
    public void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setNumRows(0);
        Object linha[] = new Object[5];
        for (int i = 0; i < listaCarros.size(); i++) {
            linha[0] = listaCarros.get(i).marca;
            linha[1] = listaCarros.get(i).modelo;
            linha[2] = listaCarros.get(i).ano;
            linha[3] = listaCarros.get(i).cor;
            linha[4] = listaCarros.get(i).valor;
            model.addRow(linha);

        }
    }

    public class Handler1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (marca1.getText().equals("") || modelo1.getText().equals("") || ano1.getText().equals("") || valor1.getText().equals("") || cor1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Favor preencher todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                Carros1 c = new Carros1(marca1.getText(), modelo1.getText(), ano1.getText(), valor1.getText(), cor1.getText());
                listaCarros.add(c);
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
                marca1.setText("");
                modelo1.setText("");
                ano1.setText("");
                cor1.setText("");
                valor1.setText("");
                atualizarTabela();
            }
        }
    }

    public class Handler2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            JOptionPane.showMessageDialog(null, "Cadastro cancelado", "Cancelar", JOptionPane.ERROR_MESSAGE);
            marca1.setText("");
            modelo1.setText("");
            ano1.setText("");
            cor1.setText("");
            valor1.setText("");

        }
    }

    public class Handler3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            int i = Integer.parseInt(JOptionPane.showInputDialog("A posição do carro na tabela")); // outra forma de ser feito ---> int i = jTable.getSelectedRow(); (para fazer dessa forma eu clico na linha e busco com o consultar
            i--;

            marca1.setText(listaCarros.get(i).marca);
            modelo1.setText(listaCarros.get(i).modelo);
            ano1.setText(listaCarros.get(i).ano);
            cor1.setText(listaCarros.get(i).cor);
            valor1.setText(listaCarros.get(i).valor);

        }
    }

    public class Handler4 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            int i = jTable.getSelectedRow();

            String marca = (String) jTable.getValueAt(i, 0);
            String modelo = (String) jTable.getValueAt(i, 1);
            String ano = (String) jTable.getValueAt(i, 2);
            String cor = (String) jTable.getValueAt(i, 3);
            String valor = (String) jTable.getValueAt(i, 4);

            listaCarros.remove(i);
            Carros1 d = new Carros1(marca, modelo, ano, cor, valor);
            listaCarros.add(i, d);
            marca1.setText("");
            modelo1.setText("");
            ano1.setText("");
            valor1.setText("");
            cor1.setText("");
            JOptionPane.showMessageDialog(null, "Edição Realizado com Sucesso", "Editar",
                    JOptionPane.INFORMATION_MESSAGE);
            atualizarTabela();
        }
    }

    public class Handler5 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {

            int i = jTable.getSelectedRow();

            listaCarros.remove(i);
            marca1.setText("");
            modelo1.setText("");
            ano1.setText("");
            cor1.setText("");
            valor1.setText("");
            JOptionPane.showMessageDialog(null, "Exclusão Realizado com Sucesso", "Informação",
                    JOptionPane.INFORMATION_MESSAGE);
            atualizarTabela();
        }
    }

    public class Handler6 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            EmpacotamentoCarros.gravarArquivoCarros(listaCarros, "carros.dat");
            JOptionPane.showMessageDialog(null, "Gravado com Sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            atualizarTabela();

        }
    }
}
