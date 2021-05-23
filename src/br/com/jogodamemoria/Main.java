package br.com.jogodamemoria;

import javax.swing.*;

public class Main {
    // Execução do programa
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            new JanelaDoJogo().setVisible(true);

        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro ao iniciar o programa!\nDetalhes: " + e, "Erro",
                    JOptionPane.ERROR_MESSAGE);

            System.exit(-1);
        }
    }
}
