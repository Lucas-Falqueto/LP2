package atividade3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MudareColorir extends JFrame {
    private PainelBola painel;

    public MudareColorir() {
        setTitle("Arrastar e Mudar Cor com Dois Toques");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painel = new PainelBola(getWidth(), getHeight());
        add(painel);

        painel.addMouseListener(new ClicarListener());
        painel.addMouseMotionListener(new ArrastarListener());
    }

    public static void main(String[] args) {
        MudareColorir janela = new MudareColorir();
        janela.setVisible(true);
    }

    private class ClicarListener extends MouseAdapter {
        private int contadorCliques = 0;

        @Override
        public void mousePressed(MouseEvent e) {
            if (painel.contains(e.getPoint())) {
                contadorCliques++;

                if (contadorCliques == 2) {
                    painel.mudarCor();
                    contadorCliques = 0;
                }
            }

        }
    }

    private class ArrastarListener extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            painel.setPosicaoBola(e.getPoint());
        }
    }

    private class PainelBola extends JPanel {
        private Point posicao;
        private Color cor;

        public PainelBola(int widht, int height) {
            posicao = new Point(widht / 2, height / 2);
            cor = Color.RED;
        }

        public void setPosicaoBola(Point novaPosicao) {
            posicao = novaPosicao;
            repaint();
        }

        public void mudarCor() {
            if (cor == Color.RED) {
                cor = Color.BLUE;
            } else {
                cor = Color.RED;
            }
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(cor);
            g.fillOval(posicao.x - 25, posicao.y - 25, 50, 50);
        }
    }
}