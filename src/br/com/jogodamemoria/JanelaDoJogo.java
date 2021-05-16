package br.com.jogodamemoria;

import javax.swing.*;

public class JanelaDoJogo extends JFrame {
    public JanelaDoJogo() {
        super("Jogo da Memória");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JMenuBar jogo = new JMenuBar();
        setJMenuBar(jogo);

        JMenu ajuda = new JMenu("Ajuda");
        jogo.add(ajuda);

        JMenuItem comojogar = new JMenuItem("Como jogar?");
        comojogar.addActionListener(actionEvent -> new JanelaAjuda().setVisible(true));

        JMenuItem sobre = new JMenuItem("Sobre o programa");
        sobre.addActionListener(actionEvent -> new JanelaSobre().setVisible(true));

        ajuda.add(comojogar);
        ajuda.add(sobre);

        add(new Carta());
        pack();
        setVisible(true);
    }

}
