package br.com.jogodamemoria;

import javax.swing.*;
import java.awt.*;

public class JanelaAjuda extends JFrame {
    private JPanel container;

    JanelaAjuda() {
        setTitle("Ajuda");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 300);
        container = new JPanel();
        setContentPane(container);
        container.setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        TextArea textArea = new TextArea();
        textArea.setBounds(0, 0, 600, 300);
        textArea.setEditable(false);
        Font font = new Font("Segoe Script", Font.BOLD, 14);
        textArea.setFont(font);
        textArea.setText(
                "Como Jogar?\n\n\n" +
                        "O jogo da memoria � um jogo cl�ssico composto por imagens em um lado \n" +
                        "e no outro apenas uma simples interroga��o ou imagem aleat�ria.\n\n" +
                        "O Jogo come�a quando as imagens s�o postas de viradas para baixo,\n" +
                        "para que o jogador n�o saiba onde se encontra seu outro par.\n\n" +
                        "Deve-se virar apenas duas pe�as por vez, se as imagens n�o forem iguais \n" +
                        "elas s�o viradas para baixo novamente e o jogador deve escolher outras \n" +
                        "cartas at� se formar um par de cartas iguais que dever�o ficar viradas\n" +
                        "para cima.\n\n" +
                        "O Jogo termina quando todos os pares de cartas \n" +
                        "forem encontrados.\n"
        );
        container.add(textArea);
        setLocationRelativeTo(null);
    }
}
