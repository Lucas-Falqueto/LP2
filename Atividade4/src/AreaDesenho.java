import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

// import java.awt.event.*;
// import java.util.ArrayList;

public class AreaDesenho extends JPanel implements MouseListener, MouseMotionListener {
    private ArrayList<Linha> linhas = new ArrayList<>();
    private Linha linhaAtual;
    private Point startPoint;

    public AreaDesenho() {
        addMouseListener(this);
        addMouseMotionListener(this);

        // Cria uma nova linha aleatória com bolinhas nas pontas
        Random random = new Random();
        int x1 = random.nextInt(getWidth() - 50) + 25;
        int y1 = random.nextInt(getHeight() - 50) + 25;
        int x2 = random.nextInt(getWidth() - 50) + 25;
        int y2 = random.nextInt(getHeight() - 50) + 25;
        Color cor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        Linha linha = new Linha(x1, y1, x2, y2, cor);
        linhas.add(linha);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha todas as linhas
        for (Linha linha : linhas) {
            linha.desenhar(g);
        }
    }

    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();

        // Verifica se o clique foi em uma das bolinhas das linhas existentes
        for (Linha linha : linhas) {
            if (linha.isClicadoBolinha(startPoint)) {
                linhaAtual = linha;
                break;
            }
        }

        // Se não, cria uma nova linha na posição do clique
        if (linhaAtual == null) {
            linhaAtual = new Linha(startPoint.x, startPoint.y, startPoint.x, startPoint.y, Color.BLACK);
            linhas.add(linhaAtual);
        }
    }

    public void mouseDragged(MouseEvent e) {
        // Se a linha atual não for nula, atualiza sua posição e das bolinhas
        if (linhaAtual != null) {
            linhaAtual.setPontoFinal(e.getX(), e.getY());
            linhaAtual.moverBolinha(e.getX() - startPoint.x, e.getY() - startPoint.y);
            startPoint = e.getPoint();

            // Redesenha a área de desenho
            repaint();
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
        // Ao soltar o mouse, seta a linha atual como nula para que possa criar uma nova
        // linha
        linhaAtual = null;
    }

    public void mouseMoved(MouseEvent e) {
    }

}
