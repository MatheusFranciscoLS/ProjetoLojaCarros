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

public class Clientes extends JPanel {

    ArrayList<Clientes1> listaClientes = new ArrayList<>();

    private JButton cadastrar, cancelar, apagar, consultar, editar, gravar;
    private JTextField id1;
    private JTextField nome1;
    private JTextField sobrenome1;
    private JTextField idade1;
    private JTextField cidade1;
    private JTextField cep1;

    private JTable jTable;

    public Clientes() {
        listaClientes = EmpacotamentoClientes.lerArquivoClientes("clientes.dat");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("ID");
        id1 = new JTextField(15);
        JLabel label1 = new JLabel("Nome");
        nome1 = new JTextField(15);
        JLabel label2 = new JLabel("Sobrenome");
        sobrenome1 = new JTextField(15);
        JLabel label3 = new JLabel("Idade");
        idade1 = new JTextField(15);
        JLabel label4 = new JLabel("Cidade");
        cidade1 = new JTextField(15);
        JLabel label5 = new JLabel("CEP");
        cep1 = new JTextField(15);

        add(label);
        add(id1);
        add(label1);
        add(nome1);
        add(label2);
        add(sobrenome1);
        add(label3);
        add(idade1);
        add(label4);
        add(cidade1);
        add(label5);
        add(cep1);

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
                new String[]{"ID", "Nome", "Sobrenome", "Idade", "Cidade", "CEP"}));
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
        Object linha[] = new Object[6];
        for (int i = 0; i < listaClientes.size(); i++) {
            linha[0] = listaClientes.get(i).id;
            linha[1] = listaClientes.get(i).nome;
            linha[2] = listaClientes.get(i).sobrenome;
            linha[3] = listaClientes.get(i).idade;
            linha[4] = listaClientes.get(i).cidade;
            linha[5] = listaClientes.get(i).cep;
            model.addRow(linha);

        }
    }

    public class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (id1.getText().equals("") || nome1.getText().equals("") || sobrenome1.getText().equals("") || idade1.getText().equals("") || cidade1.getText().equals("") || cep1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Favor preencher todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                Clientes1 c = new Clientes1(id1.getText(), nome1.getText(), sobrenome1.getText(), idade1.getText(), cidade1.getText(), cep1.getText());
                listaClientes.add(c);
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
                id1.setText("");
                nome1.setText("");
                sobrenome1.setText("");
                idade1.setText("");
                cidade1.setText("");
                cep1.setText("");
                atualizarTabela();
            }
        }
    }

    public class Handler2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            JOptionPane.showMessageDialog(null, "Cadastro cancelado", "Cancelar", JOptionPane.ERROR_MESSAGE);
            id1.setText("");
            nome1.setText("");
            sobrenome1.setText("");
            idade1.setText("");
            cidade1.setText("");
            cep1.setText("");

        }
    }

    public class Handler3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            int i = Integer.parseInt(JOptionPane.showInputDialog("A posição do carro na tabela"));
            i--;

            id1.setText(listaClientes.get(i).id);
            nome1.setText(listaClientes.get(i).nome);
            sobrenome1.setText(listaClientes.get(i).sobrenome);
            idade1.setText(listaClientes.get(i).idade);
            cidade1.setText(listaClientes.get(i).cidade);
            cep1.setText(listaClientes.get(i).cep);

        }
    }

    public class Handler4 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            int i = jTable.getSelectedRow();

            String id = (String) jTable.getValueAt(i, 0);
            String nome = (String) jTable.getValueAt(i, 1);
            String sobrenome = (String) jTable.getValueAt(i, 2);
            String idade = (String) jTable.getValueAt(i, 3);
            String cidade = (String) jTable.getValueAt(i, 4);
            String cep = (String) jTable.getValueAt(i, 5);

            listaClientes.remove(i);
            Clientes1 d = new Clientes1(id, nome, sobrenome, idade, cidade, cep);
            listaClientes.add(i, d);
            id1.setText("");
            nome1.setText("");
            sobrenome1.setText("");
            idade1.setText("");
            cidade1.setText("");
            cep1.setText("");
            JOptionPane.showMessageDialog(null, "Edição Realizado com Sucesso", "Editar",
                    JOptionPane.INFORMATION_MESSAGE);
            atualizarTabela();
        }
    }

    public class Handler5 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {

            int i = jTable.getSelectedRow();

            listaClientes.remove(i);
            id1.setText("");
            nome1.setText("");
            sobrenome1.setText("");
            idade1.setText("");
            cidade1.setText("");
            cep1.setText("");
            JOptionPane.showMessageDialog(null, "Exclusão Realizado com Sucesso", "Informação",
                    JOptionPane.INFORMATION_MESSAGE);
            atualizarTabela();
        }
    }

    public class Handler6 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            EmpacotamentoClientes.gravarArquivoClientes(listaClientes, "clientes.dat");
            JOptionPane.showMessageDialog(null, "Gravado com Sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            atualizarTabela();
        }
    }
}
