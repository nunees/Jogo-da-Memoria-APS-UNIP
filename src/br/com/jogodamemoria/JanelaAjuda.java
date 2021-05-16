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
                        "O jogo da memoria é um jogo clássico composto por imagens em um lado \n" +
                        "e no outro apenas uma simples interrogação ou imagem aleatória.\n\n" +
                        "O Jogo começa quando as imagens são postas de viradas para baixo,\n" +
                        "para que o jogador não saiba onde se encontra seu outro par.\n\n" +
                        "Deve-se virar apenas duas peças por vez, se as imagens não forem iguais \n" +
                        "elas são viradas para baixo novamente e o jogador deve escolher outras \n" +
                        "cartas até se formar um par de cartas iguais que deverão ficar viradas\n" +
                        "para cima.\n\n" +
                        "O Jogo termina quando todos os pares de cartas \n" +
                        "forem encontrados.\n"
        );
        container.add(textArea);
        setLocationRelativeTo(null);
    }
}
