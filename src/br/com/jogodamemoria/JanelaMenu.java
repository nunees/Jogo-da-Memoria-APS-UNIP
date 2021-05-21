package br.com.jogodamemoria;

import javax.swing.*;
import java.awt.*;

public class JanelaMenu extends JFrame {
    private JPanel container;

    JanelaMenu(String titulo, String conteudo) {
        setTitle(titulo);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 300);
        container = new JPanel();
        setContentPane(container);
        container.setLayout(null);
        setResizable(false);
        TextArea textArea = new TextArea();
        textArea.setBounds(0, 0, 600, 300);
        textArea.setEditable(false);
        Font font = new Font("Segoe Script", Font.BOLD, 14);
        textArea.setFont(font);
        textArea.setText(conteudo);
        container.add(textArea);
    }
}





