package br.com.jogodamemoria;

import javax.swing.JOptionPane;
import java.awt.EventQueue;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			EventQueue.invokeLater(JanelaDoJogo::new);


		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao iniciar o programa!\nDetalhes: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
	}

}
