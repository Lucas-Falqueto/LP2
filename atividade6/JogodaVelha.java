package JogodaVelha;

import javax.swing.*;

public class JogodaVelha {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Jogo da Velha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null); // centraliza a janela na tela
        
      Panel panel = new Panel();
        frame.add(panel);
        
        frame.setVisible(true);
    }
}
