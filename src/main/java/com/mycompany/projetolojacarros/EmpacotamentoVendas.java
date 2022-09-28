/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolojacarros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class EmpacotamentoVendas {
         // serialização: gravando o objetos no arquivo binário "nomeArq"

    public static void gravarArquivoVendas(ArrayList<Vendas> lista, String nomeArq) {
        File arq = new File(nomeArq);
        try {
            arq.delete();
            arq.createNewFile();
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(lista);
            objOutput.close();
        } catch (IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }
// desserialização: recuperando os objetos gravados no arquivo binário "nomeArq"

    public static ArrayList<Vendas> lerArquivoVendas(String nomeArq) {
        ArrayList<Vendas> lista = new ArrayList();
        try {
            File arq = new File(nomeArq);
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                lista = (ArrayList<Vendas>) objInput.readObject();
                objInput.close();
            }
        } catch (IOException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        } catch (ClassNotFoundException erro2) {
            System.out.printf("Erro: %s", erro2.getMessage());
        }
        return (lista);
    }
}
