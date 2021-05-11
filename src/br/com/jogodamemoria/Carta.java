package br.com.jogodamemoria;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Carta extends JPanel {

    static Timer t;
    private ImageIcon iconeInterrogacao;
    private JButton[] buttons;
    private ImageIcon[] icons;
    private int totalButtons;
    private int numClicks;
    private int numAcertos;
    private int errorsClicksIndex;
    private int currentIndex;

    public Carta() {
        try {
            this.setIconeInterrogacao(new ImageIcon(getClass().getResource("res/interrogacao.png")));
            String[] filenames = {"res/metais.png", "res/organicos.png", "res/papel.png", "res/plastico.png", "res/vidros.png"};
            int totalBtns = filenames.length * 2;
            this.setTotalButtons(totalBtns);
            this.buttons = new JButton[this.totalButtons];
            this.icons = new ImageIcon[this.totalButtons];
            this.numAcertos = 0;

            for (int i = 0, j = 0; i < filenames.length; i++) {
                this.icons[j] = new ImageIcon(getClass().getResource(filenames[i]));
                this.buttons[j] = new JButton("");
                this.buttons[j].addActionListener(new ImageButtonListener());
                this.buttons[j].setIcon(this.getLockedCard());
                add(this.buttons[j++]);

                this.icons[j] = this.icons[j - 1];
                buttons[j] = new JButton("");
                buttons[j].addActionListener(new ImageButtonListener());
                buttons[j].setIcon(this.getLockedCard());
                add(buttons[j++]);
            }


            // randomize icons array
            Random gen = new Random();
            for (int i = 0; i < getTotalButtons(); i++) {
                int rand = gen.nextInt(getTotalButtons());
                ImageIcon temp = icons[i];
                icons[i] = icons[rand];
                icons[rand] = temp;
            }
            setLayout(new GridLayout(2, 7));
            t = new Timer(1000, new TimerListener());

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro grave e o programa será encerrado!\n " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    public ImageIcon getLockedCard() {
        return iconeInterrogacao;
    }

    public void setIconeInterrogacao(ImageIcon lockedCard) {
        this.iconeInterrogacao = lockedCard;
    }

    public int getTotalButtons() {
        return totalButtons;
    }

    public void setTotalButtons(int totalButtons) {
        this.totalButtons = totalButtons;
    }

    class ImageButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (t.isRunning())
                return;

            numClicks++;

            // Qual botão o usuario clicou
            for (int i = 0; i < getTotalButtons(); i++) {
                if (actionEvent.getSource() == buttons[i]) {
                    buttons[i].setIcon(icons[i]);
                    currentIndex = i;
                }
            }

            // Checa por click
            if (numClicks % 2 == 0) {
                if (currentIndex == errorsClicksIndex) {
                    numClicks--;
                    return;
                }

                // As imagens são iguais
                if (icons[currentIndex] != icons[errorsClicksIndex]) {
                    // Mostra as imagens por cerca de 1 seg, antes de esconder novamente
                    t.start();
                } else {
                    System.out.println(numAcertos);
                    if (numAcertos == 4) {
                        JOptionPane.showMessageDialog(null,"\nAcertos: " + numAcertos + "\nTotal de Clicks: " + numClicks,"Resultado",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        numAcertos++;
                    }

                }
            } else {
                // Apenas grava o indice de erros
                errorsClicksIndex = currentIndex;
            }
        }
    }

    class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            buttons[currentIndex].setIcon(iconeInterrogacao);
            buttons[errorsClicksIndex].setIcon(iconeInterrogacao);
            t.stop();
        }
    }
}
