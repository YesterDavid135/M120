import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new Start();
    }

    private final JButton cancelButton = new JButton("Cancel");

    private final JList<User> userList = new JList<>();

    private final JTextField password = new JTextField();

    private final JLabel error = new JLabel();

    public Start() {
        setSize(300, 250);
        setTitle("MinderBank (1/3)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // UserPanel
        JPanel userPanel = new JPanel(new GridLayout(1, 2));
        userPanel.add(new JLabel("User"));

        DefaultListModel<User> userModel = new DefaultListModel<>();

        User[] users = {
                new User("Vivian", "pickachu".hashCode()),
                new User("Joe", "mama".hashCode()),
                new User("Linus", "hacker".hashCode()),
        };
        for (User user : users) {
            userModel.addElement(user);
        }

        userList.setModel(userModel);

        JScrollPane listScroller = new JScrollPane(userList);
        userPanel.add(listScroller);

        JPanel passwordPanel = new JPanel(new GridLayout(2, 2));

        passwordPanel.add(new JLabel("Password"));
        passwordPanel.add(password);
        passwordPanel.add(new JLabel()); //Empty Label to move the Password label

        passwordPanel.add(error);
        error.setForeground(Color.red);

        JPanel mainPanel = new JPanel(new GridLayout(2, 1));

        mainPanel.add(userPanel);
        mainPanel.add(passwordPanel);

        add(mainPanel, BorderLayout.CENTER);

        //ButtonPanel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JButton loginButton = new JButton("Login");
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
        else if (userList.getSelectedValue().checkPassword(password.getText())) {
            new Account(userList.getSelectedValue());
            dispose();
        } else
            error.setText("Password is wrong");
    }
}
