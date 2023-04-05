package atividade1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class desenhalinha extends JFrame {
    private paineldesenho painel;

    public desenhalinha() {
        setTitle("Desenhar Linha");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painel = new paineldesenho();
        add(painel);

        addMouseListener(new MouseAdapter() {
            private int x1, y1, x2, y2;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (x1 == 0 && y1 == 0) {
                    x1 = e.getX();
                    y1 = e.getY();
                } else {
                    x2 = e.getX();
                    y2 = e.getY();
                    painel.setPontos(x1, y1, x2, y2);
                    x1 = y1 = x2 = y2 = 0;
                }
            }
        });
    }

    public static void main(String[] args) {
        desenhalinha janela = new desenhalinha();
        janela.setVisible(true);
    }
}
