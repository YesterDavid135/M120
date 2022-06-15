package W01;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutView extends JFrame {

    private LayoutManager layout = new BorderLayout();

    public BorderLayoutView() {

        this.setVisible(true);

        this.setSize(500, 500);

        this.setLayout(layout);

        JLabel[] labels = new JLabel[5];

        for (int i = 0; i<labels.length; i++) {
            labels[i] = new JLabel(i + 1 + "hallo");
        }
        add(labels[0], BorderLayout.NORTH);
        add(labels[1], BorderLayout.WEST);
        add(labels[2], BorderLayout.EAST);
        add(labels[3], BorderLayout.SOUTH);
        add(labels[4], BorderLayout.CENTER);

        labels[4].setBackground(Color.red);
        labels[4].setOpaque(true);


    }
}
