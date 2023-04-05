package atividade2;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class Mudarcor extends JFrame {
    private ListaFrame painel;

    public Mudarcor() {
        setTitle("Cor da Bola");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painel = new ListaFrame();
        add(painel);

        painel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (painel.getCor() == Color.BLACK) {
                    painel.setCor(Color.BLUE);
                } else {
                    painel.setCor(Color.BLACK);
                }
            }
        });
    }

    public static void main(String[] args) {
        Mudarcor janela = new Mudarcor();
        janela.setVisible(true);
    }
}