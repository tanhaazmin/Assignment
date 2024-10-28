import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_page {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";
    private static final int MAX_ATTEMPTS = 3;

    private int attempts = 0;

    public Login_page() {

        JFrame frame = new JFrame("Login Page");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);


        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);


        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);


        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 80, 80, 25);
        panel.add(loginButton);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputUsername = userText.getText();
                String inputPassword = new String(passwordText.getPassword());

                if (USERNAME.equals(inputUsername) && PASSWORD.equals(inputPassword)) {
                    JOptionPane.showMessageDialog(panel, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0); // Exit the program on successful login
                } else {
                    attempts++;
                    if (attempts >= MAX_ATTEMPTS) {
                        JOptionPane.showMessageDialog(panel, "Maximum attempts reached. Access denied!", "Error", JOptionPane.ERROR_MESSAGE);
                        System.exit(0); // Exit the program after 3 unsuccessful attempts
                    } else {
                        JOptionPane.showMessageDialog(panel, "Incorrect username or password. " + (MAX_ATTEMPTS - attempts) + " attempt(s) left.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {

        new Login_page();
    }
}
