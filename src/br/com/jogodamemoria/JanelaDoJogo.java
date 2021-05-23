package br.com.jogodamemoria;

import javax.swing.*;
import java.util.Objects;

public class JanelaDoJogo extends JFrame {
    public JanelaDoJogo() {
        super("Jogo da Mem�ria");
        ImageIcon logo = new ImageIcon(Objects.requireNonNull(getClass().getResource("res/logo.png")));
        setIconImage(logo.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JMenuBar jogo = new JMenuBar();
        setJMenuBar(jogo);

        JMenu ajuda = new JMenu("Ajuda");
        jogo.add(ajuda);

        JMenuItem comojogar = new JMenuItem("Como jogar?");
        comojogar.addActionListener(actionEvent -> new JanelaMenu("Como Jogar",
                "Como Jogar?\n\n\n" +
                        "O jogo da mem�ria � um jogo cl�ssico composto por imagens em um lado \n" +
                        "e no outro apenas uma simples interroga��o ou imagem aleat�ria.\n\n" +
                        "O Jogo come�a quando as imagens s�o viradas para baixo \n" +
                        "para que o jogador n�o saiba onde se encontra seu outro par.\n\n" +
                        "Deve-se virar apenas duas pe�as por vez, se as imagens n�o forem iguais \n" +
                        "elas s�o viradas para baixo novamente e o jogador deve escolher outras \n" +
                        "cartas at� se formar um par de cartas iguais que dever�o ficar viradas\n" +
                        "para cima.\n\n" +
                        "O Jogo termina quando todos os pares de cartas \n" +
                        "forem encontrados ou as tentativas se acabarem.\n").setVisible(true));

        JMenuItem sobre = new JMenuItem("Sobre o jogo");
        sobre.addActionListener(actionEvent -> new JanelaMenu("Sobre",
                "Atividadade Pr�tica Supervisionada\n" +
                "\n" +
                "Criado por:\n" +
                "\n" +
                "BRUNO GONZALEZ MASSONE � N582JF3\n" +
                "\n" +
                "FELIPE NUNES DA SILVA � N4935E0 \n" +
                "\n" +
                "FELIPE DE OLIVEIRA PEREIRA MAUR�CIO � F2322A8").setVisible(true));

        ajuda.add(comojogar);
        ajuda.add(sobre);
        add(new Carta());
        pack();
    }

}
