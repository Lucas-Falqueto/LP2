package atividade3;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ListaFrame extends JPanel {
    private Color cor;

    public ListaFrame() {
        cor = Color.RED;
    }

    public void setCor(Color cor) {
        this.cor = cor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(cor);
        g.fillOval(0, 0, getWidth(), getHeight());
    }

    public Color getCor() {
        return null;
    }
}