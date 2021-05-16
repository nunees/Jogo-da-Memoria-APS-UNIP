package br.com.jogodamemoria;

import javax.swing.*;
import java.awt.*;

public class JanelaSobre extends JFrame {
    private JPanel container;

    JanelaSobre() {
        setTitle("Sobre");
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
                "Ativididade Prática Supervisionada\n" +
                        "\n" +
                        "Criado por:\n" +
                        "\n" +
                        "BRUNO GONZALEZ MASSONE – N582JF3\n" +
                        "\n" +
                        "FELIPE NUNES DA SILVA – N4935E0 \n" +
                        "\n" +
                        "FELIPE DE OLIVEIRA PEREIRA MAURÍCIO – F2322A8"
        );
        container.add(textArea);
        setLocationRelativeTo(null);

    }
}
