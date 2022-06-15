package W02;

import javax.swing.*;
import java.awt.*;

public class ZeroGUI extends JFrame {

    private BorderLayout borderLayout = new BorderLayout();
    private GridLayout gridLayout = new GridLayout(3,2);
    private GridLayout flowLayout = new GridLayout(1,3);

    private JPanel labelPanel = new JPanel(gridLayout);
    private JPanel buttonPanel = new JPanel(flowLayout);

    private JLabel labels[] = new JLabel[3];
    private JButton buttons[] = new JButton[3];

    private JList<String> list = new JList<>();
    private DefaultListModel model = new DefaultListModel<>();


    public ZeroGUI(){

        list.setModel(model);

        this.setSize(300, 100);
        this.setTitle("Zero");
        this.setLayout(borderLayout);

        labels[0] = new JLabel("Dieses Programm macht nichts.");
        labels[1] = new JLabel("Copyright (c) 1999");
        labels[2] = new JLabel("Zerosoft AG");

        buttons[0] = new JButton("Abbrechen");
        buttons[1] = new JButton("OK");
        buttons[2] = new JButton("Hilfe");

        for (int i = 0; i<3; i++){
          labelPanel.add(labels[i]);


          buttonPanel.add(buttons[i]);
        }

        add(labelPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ZeroGUI();
    }

}
