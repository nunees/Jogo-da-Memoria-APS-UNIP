package br.com.jogodamemoria;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaDoJogo extends JFrame {
    public JanelaDoJogo() {

        super("Jogo da Memória");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JMenuBar jogo = new JMenuBar();
        setJMenuBar(jogo);

        JMenu opcoes = new JMenu("Jogo");
        JMenu ajuda = new JMenu("Ajuda");
        jogo.add(opcoes);
        jogo.add(ajuda);

        JMenuItem exit = new JMenuItem("Sair");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
                    System.exit(1);
                }
            }
        });
        opcoes.add(exit);


        JMenuItem comojogar = new JMenuItem("Como jogar?");
        comojogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new JanelaAjuda().setVisible(true);
            }
        });
        JMenuItem sobre = new JMenuItem("Sobre o programa");
        sobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new JanelaSobre().setVisible(true);
            }
        });
        ajuda.add(comojogar);
        ajuda.add(sobre);


        add(new Carta());
        pack();
        setVisible(true);
    }

}
