package JogodaVelha;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.net.URL;

public class Panel extends JPanel {
    private JButton[][] botoes;
    private char turno;

    public Panel() {
        setLayout(new GridLayout(3, 3));
        botoes = new JButton[3][3];
        turno = 'X';

        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                botoes[linha][coluna] = new JButton("");
                botoes[linha][coluna].setFont(new Font("Arial", Font.PLAIN, 40));
                botoes[linha][coluna].addActionListener(new JogadaListener(linha, coluna));
                add(botoes[linha][coluna]);
            }
        }
    }

    private void verificarVencedor() {
        // Verifica linhas
        for (int linha = 0; linha < 3; linha++) {
            if (botoes[linha][0].getText().equals(botoes[linha][1].getText()) &&
                    botoes[linha][0].getText().equals(botoes[linha][2].getText()) &&
                    !botoes[linha][0].getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Jogador " + turno + " venceu!");
                reiniciarJogo();
                return;
            }
        }

        // Verifica colunas
        for (int coluna = 0; coluna < 3; coluna++) {
            if (botoes[0][coluna].getText().equals(botoes[1][coluna].getText()) &&
                    botoes[0][coluna].getText().equals(botoes[2][coluna].getText()) &&
                    !botoes[0][coluna].getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Jogador " + turno + " venceu!");
                reiniciarJogo();
                return;
            }
        }

        // Verifica diagonais
        if (botoes[0][0].getText().equals(botoes[1][1].getText()) &&
                botoes[0][0].getText().equals(botoes[2][2].getText()) &&
                !botoes[0][0].getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Jogador " + turno + " venceu!");
            reiniciarJogo();
            return;
        }else if(botoes[2][0].getText().equals(botoes[1][1].getText()) &&
        botoes[2][0].getText().equals(botoes[0][2].getText()) &&
        !botoes[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(this, "Jogador " + turno + " venceu!");
            reiniciarJogo();
            return;
        }

        // Verifica empate
        boolean empate = true;
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (botoes[linha][coluna].getText().equals("")) {
                    empate = false;
                }
            }
        }

        if (empate) {
            somM("empate");
            JOptionPane.showMessageDialog(this, "Empate!");
            reiniciarJogo();
            return;
        }

        // Troca o turno
        if (turno == 'X') {
            turno = 'O';
        } else {
            turno = 'X';
        }
    }

    private void reiniciarJogo() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                botoes[linha][coluna].setText("");
            }
        }
        turno = 'X';
    }

    private class JogadaListener implements ActionListener {
        private int linha;
        private int coluna;

        public JogadaListener(int linha, int coluna) {
            this.linha = linha;
            this.coluna = coluna;
        }

        public void actionPerformed(ActionEvent e) {
            if (botoes[linha][coluna].getText().equals("")) {
                botoes[linha][coluna].setText(String.valueOf(turno));
                somM("somM");
                verificarVencedor();
            }
        }
    }

    // Som de movimento
    public void somM(String Movie) {
        URL url = JogodaVelha.class.getResource(Movie + ".wav");
        AudioClip audioM = Applet.newAudioClip(url);
        audioM.play();
    }

}
