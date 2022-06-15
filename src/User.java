import java.text.DecimalFormat;

public class User {

    private final String username;

    private final int password;

    private double balance;

    public User(String username, int password) {

        this.username = username;
        this.password = password;

        DecimalFormat df = new DecimalFormat("0.00");
        double balance = Math.random() * 1000;
        balance = Double.parseDouble(df.format(balance));
        this.balance = balance;

    }

    @Override
    public String toString() {
        return username;
    }


    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password == password.hashCode();
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double input) {
        if (balance >= input)
            balance -= input;
    }

    public void deposit(double input) {
        balance += input;
    }
}
