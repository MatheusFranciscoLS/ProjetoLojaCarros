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
import javax.swing.table.DefaultTableModel;

public class Vendas1 extends JPanel {

    ArrayList<Vendas> listaVendas = new ArrayList<>();

    private JButton cadastrar, cancelar, apagar, consultar, editar, gravar;
    private JTextField carro1;
    private JTextField cliente1;
    private JTextField valorVenda1;
    private JTextField formaPagamento1;
    private JTextField dataVenda1;

    private JTable jTable;

    public Vendas1() {
        listaVendas = EmpacotamentoVendas.lerArquivoVendas("vendas.dat");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Carro");
        carro1 = new JTextField(15);
        JLabel label1 = new JLabel("Cliente");
        cliente1 = new JTextField(15);
        JLabel label2 = new JLabel("Valor da venda");
        valorVenda1 = new JTextField(15);
        JLabel label3 = new JLabel("Forma de pagamento");
        formaPagamento1 = new JTextField(15);
        JLabel label4 = new JLabel("Data da venda");
        dataVenda1 = new JTextField(15);

        add(label);
        add(carro1);
        add(label1);
        add(cliente1);
        add(label2);
        add(valorVenda1);
        add(label3);
        add(formaPagamento1);
        add(label4);
        add(dataVenda1);

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
                new String[]{"Carro", "Cliente", "Valor Venda", "Forma Pagamento", "Data Venda"}));
        jSPane.setViewportView(jTable);

        Handler handler = new Handler();
        cadastrar.addActionListener(handler);

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

    // add linhas do array list ao jtable 
    public void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setNumRows(0);
        Object linha[] = new Object[5];
        for (int i = 0; i < listaVendas.size(); i++) {
            linha[0] = listaVendas.get(i).carro;
            linha[1] = listaVendas.get(i).Cliente;
            linha[2] = listaVendas.get(i).valorVenda;
            linha[3] = listaVendas.get(i).formaPagamento;
            linha[4] = listaVendas.get(i).dataVenda;
            model.addRow(linha);

        }
    }

    public class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (carro1.getText().equals("") || cliente1.getText().equals("") || valorVenda1.getText().equals("") || formaPagamento1.getText().equals("") || dataVenda1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Favor preencher todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                Vendas c = new Vendas(carro1.getText(), cliente1.getText(), valorVenda1.getText(), formaPagamento1.getText(), dataVenda1.getText());
                listaVendas.add(c);
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
                carro1.setText("");
                cliente1.setText("");
                valorVenda1.setText("");
                formaPagamento1.setText("");
                dataVenda1.setText("");
                atualizarTabela();
            }
        }
    }

    public class Handler2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            JOptionPane.showMessageDialog(null, "Cadastro cancelado", "Cancelar", JOptionPane.ERROR_MESSAGE);
            carro1.setText("");
            cliente1.setText("");
            valorVenda1.setText("");
            formaPagamento1.setText("");
            dataVenda1.setText("");

        }
    }

    public class Handler3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            int i = Integer.parseInt(JOptionPane.showInputDialog("A posição do carro na tabela"));
            i--;

            carro1.setText(listaVendas.get(i).carro);
            cliente1.setText(listaVendas.get(i).Cliente);
            valorVenda1.setText(listaVendas.get(i).valorVenda);
            formaPagamento1.setText(listaVendas.get(i).formaPagamento);
            dataVenda1.setText(listaVendas.get(i).dataVenda);

        }
    }

    public class Handler4 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            int i = jTable.getSelectedRow();

            String carro = (String) jTable.getValueAt(i, 0);
            String cliente = (String) jTable.getValueAt(i, 1);
            String valorVenda = (String) jTable.getValueAt(i, 2);
            String formaPagamento = (String) jTable.getValueAt(i, 3);
            String dataVenda = (String) jTable.getValueAt(i, 4);

            listaVendas.remove(i);
            Vendas d = new Vendas(carro, cliente, valorVenda, formaPagamento, dataVenda);
            listaVendas.add(i, d);
            carro1.setText("");
            cliente1.setText("");
            valorVenda1.setText("");
            formaPagamento1.setText("");
            dataVenda1.setText("");
            JOptionPane.showMessageDialog(null, "Edição Realizado com Sucesso", "Editar",
                    JOptionPane.INFORMATION_MESSAGE);
            atualizarTabela();
        }
    }

    public class Handler5 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {

            int i = jTable.getSelectedRow();

            listaVendas.remove(i);
            carro1.setText("");
            cliente1.setText("");
            valorVenda1.setText("");
            formaPagamento1.setText("");
            dataVenda1.setText("");
            JOptionPane.showMessageDialog(null, "Exclusão Realizado com Sucesso", "Informação",
                    JOptionPane.INFORMATION_MESSAGE);
            atualizarTabela();
        }
    }

    public class Handler6 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            EmpacotamentoVendas.gravarArquivoVendas(listaVendas, "vendas.dat");
            JOptionPane.showMessageDialog(null, "Gravado com Sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            atualizarTabela();
        }
    }
}
