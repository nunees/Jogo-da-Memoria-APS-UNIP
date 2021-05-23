package br.com.jogodamemoria;

import javax.swing.*;
import java.util.Objects;

public class JanelaDoJogo extends JFrame {
    public JanelaDoJogo() {
        super("Jogo da Memória");
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
                        "O jogo da memória é um jogo clássico composto por imagens em um lado \n" +
                        "e no outro apenas uma simples interrogação ou imagem aleatória.\n\n" +
                        "O Jogo começa quando as imagens são viradas para baixo \n" +
                        "para que o jogador não saiba onde se encontra seu outro par.\n\n" +
                        "Deve-se virar apenas duas peças por vez, se as imagens não forem iguais \n" +
                        "elas são viradas para baixo novamente e o jogador deve escolher outras \n" +
                        "cartas até se formar um par de cartas iguais que deverão ficar viradas\n" +
                        "para cima.\n\n" +
                        "O Jogo termina quando todos os pares de cartas \n" +
                        "forem encontrados ou as tentativas se acabarem.\n").setVisible(true));

        JMenuItem sobre = new JMenuItem("Sobre o jogo");
        sobre.addActionListener(actionEvent -> new JanelaMenu("Sobre",
                "Atividadade Prática Supervisionada\n" +
                "\n" +
                "Criado por:\n" +
                "\n" +
                "BRUNO GONZALEZ MASSONE – N582JF3\n" +
                "\n" +
                "FELIPE NUNES DA SILVA – N4935E0 \n" +
                "\n" +
                "FELIPE DE OLIVEIRA PEREIRA MAURÍCIO – F2322A8").setVisible(true));

        ajuda.add(comojogar);
        ajuda.add(sobre);
        add(new Carta());
        pack();
    }

}
