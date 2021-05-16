package br.com.jogodamemoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;


public class Carta extends JPanel {

    static Timer temporizador;

    private ImageIcon iconeInterrogacao;
    private JButton[] botoes;
    private ImageIcon[] icones;

    private int totalBotoes;
    private int numeroClicks;
    private int numeroAcertos;
    private int numeroErros;

    private int indiceErros;
    private int indiceAtual;

    private int dificuldade;
    private int tentativas;

    public Carta() {

        //Excessão principal da classe, se não for possivel carregar os arquivos necessario o programa é encerrado.
        try {
            // Excessão que tenta lidar com a entrada invalida do usuario.
            try {
                mudarDificuldade();
                JOptionPane.showMessageDialog(null, "Você possui " + this.dificuldade + " tentativas!\nBoa sorte!", "Escolha a dificuldade", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: o campo não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }

            // Carrega o icone de interrogação das cartas.
            this.setIconeInterrogacao(new ImageIcon(Objects.requireNonNull(getClass().getResource("res/interrogacao.png"))));

            // A String filenames contém o caminho de todas as imagens usadas no jogo.
            String[] filenames = {"res/metais.png", "res/organicos.png", "res/papel.png", "res/plastico.png", "res/vidros.png"};
            int totalBtns = filenames.length * 2;

            this.setTotalBotoes(totalBtns);
            this.setBotoes(new JButton[this.totalBotoes]);
            this.setIcones(new ImageIcon[this.totalBotoes]);

            this.setNumeroAcertos(0);
            this.setNumeroErros(0);
            this.setNumeroClicks(0);

            // Loop que ira gerar os botões e adicionar as imagens e listeners.
            for (int i = 0, j = 0; i < filenames.length; i++) {
                this.icones[j] = new ImageIcon(Objects.requireNonNull(getClass().getResource(filenames[i])));
                this.botoes[j] = new JButton("");
                this.botoes[j].addActionListener(new ImageButtonListener());
                this.botoes[j].setIcon(this.getIconeInterrogacao());
                add(this.botoes[j++]);

                this.icones[j] = this.icones[j - 1];
                botoes[j] = new JButton("");
                botoes[j].addActionListener(new ImageButtonListener());
                botoes[j].setIcon(this.getIconeInterrogacao());
                add(botoes[j++]);
            }


            // Gera posições aleatorias das cartas
            Random gen = new Random();
            for (int i = 0; i < getTotalBotoes(); i++) {
                int rand = gen.nextInt(getTotalBotoes());
                ImageIcon temp = icones[i];
                icones[i] = icones[rand];
                icones[rand] = temp;
            }

            setLayout(new GridLayout(2, 7));

            // Cria um temporizador que ira desvirar as cartas se as mesmas forem diferentes
            temporizador = new Timer(1000, new TimerListener());

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro grave e o programa será encerrado!\n " +
                            e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    /*
     *  GETTERS e SETTERS
     *
     */

    public ImageIcon getIconeInterrogacao() {
        return iconeInterrogacao;
    }

    public void setIconeInterrogacao(ImageIcon lockedCard) {
        this.iconeInterrogacao = lockedCard;
    }

    public void setBotoes(JButton[] botoes) {
        this.botoes = botoes;
    }

    public void setIcones(ImageIcon[] icones) {
        this.icones = icones;
    }

    public int getTotalBotoes() {
        return totalBotoes;
    }

    public void setTotalBotoes(int totalBotoes) {
        this.totalBotoes = totalBotoes;
    }

    public int getNumeroClicks() {
        return this.numeroClicks;
    }

    public void setNumeroClicks(int numeroClicks) {
        this.numeroClicks += numeroClicks;
    }

    public int getNumeroAcertos() {
        return this.numeroAcertos;
    }

    public void setNumeroAcertos(int numeroAcertos) {
        this.numeroAcertos += numeroAcertos;
    }

    public int getNumeroErros() {
        return this.numeroErros;
    }

    public void setNumeroErros(int numeroErros) {
        this.numeroErros += numeroErros;
    }

    // Altera a dificuldade do jogo
    public void mudarDificuldade() {
        String input = JOptionPane.showInputDialog("Escolha uma diculdade: \n\nFacil: 0\nMédia: 1\nDifícil: 2\nGod(Tem certeza?): 3\n\n");
        int escolha = Integer.parseInt(input);
        if (escolha == 0) {
            this.dificuldade = 20;
        } else if (escolha == 1) {
            this.dificuldade = 10;
        } else if (escolha == 2) {
            this.dificuldade = 5;
        } else if (escolha == 3) {
            this.dificuldade = 1;
        } else {
            JOptionPane.showMessageDialog(null, "Escolha inválida, por padrão a dificuldade será configurada como fácil!", "Erro", JOptionPane.ERROR_MESSAGE);
            this.dificuldade = 20;
        }
    }

    /*
     *  Inner classes criadas para organizar todas as classes que pertencem ao escopo da classe cartas.
     *  Facilitando assim a manutenção e a organização
     *
     */
    class ImageButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (temporizador.isRunning())
                return;

            setNumeroClicks(1);

            // Checa qual botão o usuario clicou e incrementa o indice
            for (int i = 0; i < getTotalBotoes(); i++) {
                if (actionEvent.getSource() == botoes[i]) {
                    botoes[i].setIcon(icones[i]);
                    indiceAtual = i;
                }
            }

            if (getNumeroClicks() % 2 == 0) {
                if (indiceAtual == indiceErros) {
                    setNumeroClicks(-1);
                    return;
                }

                /*  Se as cartas não forem iguais, primeiro verifica se o jogador excedeu suas tentivas, logo em seguida
                 *  ativa o temporizador.
                 *  Se as cartas forem iguis, verifica se o jogar possui tentivas restantes, se tambem acertou todas as
                 *  combinações e logo em seguida apresenta uma mensagem com os resultados;
                 */
                if (icones[indiceAtual] != icones[indiceErros]) {
                    // Mostra as imagens por cerca de 1 seg, antes de esconder novamente
                    if ((tentativas + 1) >= dificuldade) {
                        JOptionPane.showMessageDialog(null, "Fim de jogo", "GAME OVER",
                                JOptionPane.INFORMATION_MESSAGE);
                        System.exit(1);
                    } else {
                        tentativas++;
                    }
                    setNumeroErros(1);
                    temporizador.start();
                } else {
                    if (getNumeroAcertos() == 4) {
                        JOptionPane.showMessageDialog(null, "\nAcertos: " +
                                (getNumeroAcertos() + 1) + "/5" + "\nErros: " + getNumeroErros() +
                                "\nJogadas: " + getNumeroClicks() / 2, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    } else {
                        setNumeroAcertos(1);
                    }

                }
            } else {
                // Grava as jogadas erradas
                indiceErros = indiceAtual;
            }
        }
    }

    class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            // O temporizador depois de ativado, define o icone das cartas como uma interrogação
            botoes[indiceAtual].setIcon(iconeInterrogacao);
            botoes[indiceErros].setIcon(iconeInterrogacao);
            temporizador.stop();
        }
    }
}
