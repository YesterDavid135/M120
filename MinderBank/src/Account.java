import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Account extends JFrame implements ActionListener {

    private final JButton depositButton = new JButton("Deposit");
    private final JButton withdrawButton = new JButton("Wirthdraw");
    private final JButton cancelButton = new JButton("Cancel");

    private final JTextField value = new JTextField();

    private final JLabel error = new JLabel("Please enter a number above 0");

    private double balance;
    private final String user;

    public Account(String user, double balance) {
        setSize(300, 250);
        setTitle("MinderBank (2/3)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        this.balance = balance;
        this.user = user;

        //welcomePanel
        JPanel welcomePanel = new JPanel(new GridLayout(4, 1));
        welcomePanel.add(new JLabel("Hello, " + user));
        welcomePanel.add(new JLabel("You're Balance is: +" + balance + "CHF"));

        JPanel valuePanel = new JPanel(new GridLayout(1, 2));
        valuePanel.add(new JLabel("CHF input"));
        valuePanel.add(value);
        welcomePanel.add(valuePanel);

        welcomePanel.add(error);
        error.setForeground(Color.red);
        error.setVisible(false);


        add(welcomePanel, BorderLayout.CENTER);


        //ButtonPanel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        cancelButton.addActionListener(this);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(cancelButton))
            System.exit(0);

        double input;
        try {
           input = Double.parseDouble(value.getText());
        } catch (Exception ex) {
            error.setVisible(true);
            return;
        }
        if (input <= 0) {
            error.setVisible(true);
            return;
        }

        String message = "Are you sure to ";
        if  (e.getSource().equals(withdrawButton))
            message+= "withdraw ";
        else
            message += "deposit ";
        message += input + "CHF?";

        int a = JOptionPane.showConfirmDialog(this, message);
        if (a == JOptionPane.YES_OPTION) {
            if  (e.getSource().equals(withdrawButton))
               balance -= input;
           else
                balance += input;

            new Summary(user, balance);
            dispose();
        }

    }
}