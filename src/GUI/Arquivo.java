package GUI;

import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.FormatterClosedException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import java.io.File;

public class Arquivo {

    private Formatter arquivo;
    private Scanner entrada;

    Arquivo() {
    }

    // ---------------------------------//--------------------------------------
    // ######################### Funções para Salvar ###########################
    public void openWrite(String file) {
        try {
            arquivo = new Formatter(file + ".txt");
        } catch (SecurityException semPermissao) {
            JOptionPane.showMessageDialog(null, "sem permissão para abrir o arquivo!",
                    "Alerta", JOptionPane.WARNING_MESSAGE);
        } catch (FileNotFoundException arquivoInexistente) {
            JOptionPane.showMessageDialog(null, "Arquivo inexistente ou arquivo não pode ser criado");
        }
    }

    public void write(String output) {
        try {
            arquivo.format(output + "\n");
        } catch (FormatterClosedException formatoDesconhecido) {
            JOptionPane.showMessageDialog(null, "Erro ao escrever");
        } catch (NoSuchElementException excecaoElemento) {
            JOptionPane.showMessageDialog(null, "Entrada inválida");
        }
    }

    public void closeWrite() {
        arquivo.close();
    }

    // ---------------------------------//--------------------------------------
    // ####################### Funções para escrever: ##########################

    public void openRead(String aux) {
        try {
            entrada = new Scanner(new File(aux + ".txt"));
        } catch (FileNotFoundException arquivoNaoEncontrado) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel abrir o arquivo! Nao encontrado!");
        }
    }

    public String read() {
        try {
            if (entrada.hasNext()) {
                return (entrada.nextLine());
            }
        } catch (NoSuchElementException entradaDiferente) {
            JOptionPane.showMessageDialog(null, "Entrada diferente da esperada");
            entrada.close();
        } catch (IllegalStateException erroLeitura) {
            JOptionPane.showMessageDialog(null, "Erro de leitura");
        }
        return ("");
    }

    public boolean isReadable() {
        return (entrada.hasNext());
    }

    public void closeRead() {
        entrada.close();
    }
    // ---------------------------------//--------------------------------------
}
