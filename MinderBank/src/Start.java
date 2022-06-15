import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Start extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new Start();
    }

    private final JButton cancelButton = new JButton("Cancel");
    private final JButton loginButton = new JButton("Login");

    private final JList<String> userList = new JList<>();

    private final JTextField password = new JTextField();

    private final JLabel error = new JLabel();

    public Start() {
        setSize(300, 250);
        setTitle("MinderBank (1/3)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // UserPanel
        JPanel userPanel = new JPanel(new GridLayout(3, 2));
        userPanel.add(new JLabel("User"));

        DefaultListModel<String> userModel = new DefaultListModel<String>();
        userModel.addElement("Vivian");
        userModel.addElement("Joe");
        userModel.addElement("Linus");
        userModel.addElement("Felix");
        userModel.addElement("Benjamin");
        userModel.addElement("Luca");
        userModel.addElement("Verstappen");
        userModel.addElement("Noel");
        userList.setModel(userModel);

        JScrollPane listScroller = new JScrollPane(userList);
        userPanel.add(listScroller);

        userPanel.add(new JLabel("Password"));
        userPanel.add(password);
        userPanel.add(new JLabel()); //Empty Label to move the Password label

        userPanel.add(error);
        error.setForeground(Color.red);

        add(userPanel, BorderLayout.CENTER);

        //ButtonPanel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(loginButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(cancelButton))
            System.exit(0);

        if (userList.getSelectedIndex() == -1)
            error.setText("Please Select a user");
        else if (password.getText().equals("1234")){
            DecimalFormat df = new DecimalFormat("0.00");
            double balance = Math.random()*1000;
            balance = Double.parseDouble(df.format(balance));

            new Account(userList.getSelectedValue(), balance );
            dispose();
        }else
            error.setText("Password is wrong");
    }
}
