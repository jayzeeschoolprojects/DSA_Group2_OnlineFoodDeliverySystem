import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class LoginPage extends JPanel {
    public LoginPage(OnlineFoodDeliverySystem app) {
        setLayout(new BorderLayout(10,10));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Login", TitledBorder.CENTER, TitledBorder.TOP));

        JTextField userField = new JTextField();
        userField.setPreferredSize(new Dimension(200, 25));
        JPasswordField passField = new JPasswordField();
        passField.setPreferredSize(new Dimension(200, 25));

        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        userPanel.add(new JLabel("Username:"));
        userPanel.add(userField);

        JPanel passPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        passPanel.add(new JLabel("Password:"));
        passPanel.add(passField);

        formPanel.add(userPanel);
        formPanel.add(passPanel);

        add(formPanel, BorderLayout.CENTER);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(_ -> {
            String u = userField.getText();
            String p = new String(passField.getPassword());

            if (u.equals(UserAccount.username) && p.equals(UserAccount.password)) {
                UserAccount.loggedIn = true;
                app.customerName.setText(UserAccount.name);
                app.customerAddress.setText(UserAccount.address);
                JOptionPane.showMessageDialog(app, "Login successful.");
                app.refreshPage("Step1");
            } else {
                JOptionPane.showMessageDialog(app, "Invalid credentials.");
            }
        });

        JButton goRegister = new JButton("Register");
        goRegister.addActionListener(_ -> app.showPage("Register"));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(_ -> app.showPage("Step1"));

        JPanel btnPanel = new JPanel();
        btnPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        btnPanel.add(loginButton);
        btnPanel.add(goRegister);
        btnPanel.add(backButton);
        add(btnPanel, BorderLayout.SOUTH);
    }
}