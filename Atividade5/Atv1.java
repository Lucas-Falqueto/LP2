import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Atv1 extends JFrame {

    public Atv1() {
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Painel painel = new Painel();
        add(painel);
    }

    private class Painel extends JPanel {

        public Painel() {
            setSize(300, 200);
            JLabel label = new JLabel();
            label.setText("Valor");
            JTextArea textArea = new JTextArea();
            textArea.setPreferredSize(new Dimension(150, 20));
            textArea.setText("0");
            JButton button = new JButton();
            JButton buttonZera = new JButton();
            button.setText("Incrementar");
            buttonZera.setText("Zerar");
            add(label);
            add(textArea);
            add(button);
            add(buttonZera);

            buttonZera.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    textArea.setText("0");
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }
            });

            button.addMouseListener(new MouseListener() {
                private int num;

                @Override
                public void mouseClicked(MouseEvent e) {
                    num = Integer.parseInt(textArea.getText());
                    textArea.setText(String.valueOf(num += 1));
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

            });
        }

    }

    public static void main(String[] args) {
        Atv1 janela = new Atv1();
        janela.setVisible(true);
    }
}
