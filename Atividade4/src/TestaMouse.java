
import java.awt.BorderLayout;
// import java.awt.Point;

import javax.swing.*;

public class TestaMouse extends JFrame {

    public TestaMouse() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        JPanel labelPanel = new JPanel();
        labelPanel.add(new JLabel("Desenhe clicando com o mouse"));

        JPanel areaDesenhoPanel = new JPanel(new BorderLayout());
        // areaDesenhoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));W

        areaDesenhoPanel.add(new AreaDesenho(), BorderLayout.CENTER);

        // adiciona os painéis no JFrame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(labelPanel, BorderLayout.NORTH);
        getContentPane().add(areaDesenhoPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TestaMouse();
    }

}