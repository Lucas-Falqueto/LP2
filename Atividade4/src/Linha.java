
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Linha extends JPanel {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color cor;
    private ArrayList<Bolinha> pontos = new ArrayList<>();

    public Linha(int x1, int y1, int x2, int y2, Color cor) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.cor = cor;

        // Cria as bolinhas nos pontos inicial e final da linha
        pontos.add(new Bolinha(x1, y1, cor));
        pontos.add(new Bolinha(x2, y2, cor));
    }

    public void desenhar(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.setColor(cor);
        g2.drawLine(x1, y1, x2, y2);

        // Desenha as bolinhas
        for (Bolinha ponto : pontos) {
            ponto.desenhar(g);
        }
    }

    public void setPontoFinal(int x, int y) {
        // Atualiza as coordenadas do ponto final da linha
        x2 = x;
        y2 = y;

        // Atualiza a posição da bolinha final
        pontos.get(1).setPosicao(x, y);
    }

    public void moverBolinha(int deltaX, int deltaY) {
        // Atualiza a posição das bolinhas
        Bolinha inicio = pontos.get(0);
        inicio.setPosicao(inicio.getX() + deltaX, inicio.getY() + deltaY);

        Bolinha fim = pontos.get(1);
        fim.setPosicao(fim.getX() + deltaX, fim.getY() + deltaY);
    }

    public boolean isClicadoBolinha(Point ponto) {
        for (Bolinha bolinha : pontos) {
            if (bolinha.isClicado(ponto)) {
                return true;
            }
        }
        return false;
    }

    private class Bolinha {
        private int x;
        private int y;
        private Color cor;

        public Bolinha(int x, int y, Color cor) {
            this.x = x;
            this.y = y;
            this.cor = cor;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setPosicao(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isClicado(Point ponto) {
            return ponto.distance(x, y) <= 5; // 5 é o raio da bolinha
        }

        public void desenhar(Graphics g) {
            g.setColor(cor);
            g.fillOval(x - 5, y - 5, 10, 10);
        }
    }
}
