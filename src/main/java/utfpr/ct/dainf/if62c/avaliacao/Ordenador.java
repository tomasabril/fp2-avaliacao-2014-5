/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.avaliacao;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1013343 Tomás Abril <tomas@alunos.utfpr.edu.br>
 */
public class Ordenador extends Thread {

    String caminho;
    List<String> linhas = new ArrayList<>();
    BufferedWriter gravar;
    BufferedReader ler;
    Boolean terminou = false;

    public Ordenador(String caminho) {
        this.caminho = caminho;
    }

    private synchronized void carrega() {

        try {
            ler = new BufferedReader(new FileReader(caminho));
            String linha = ler.readLine();
            int i = 0;
            while (linha != null) {
                linhas.add(linha);
                linha = ler.readLine();
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Ordenador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ler.close();
            } catch (IOException ex) {
                Logger.getLogger(Ordenador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private synchronized void grava() {
        try {
            gravar = new BufferedWriter(new FileWriter(caminho + ".ord"));
            for (String l : linhas) {
                gravar.write(l);
                gravar.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Ordenador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                gravar.close();
            } catch (IOException ex) {
                Logger.getLogger(Ordenador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public synchronized void ordena() {
        carrega();
        Collections.sort(linhas);
        grava();
        terminou = true;
        notify();
    }

    @Override
    public void run() {
        ordena();
    }

    public Boolean isTerminou() {
        return terminou;
    }
}
