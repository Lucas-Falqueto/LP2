package atividade1;

import javax.swing.JPanel;
import java.awt.Graphics;

public class paineldesenho extends JPanel {
    private int x1, y1, x2, y2;

    public void setPontos(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(x1, y1, x2, y2);
    }
}
