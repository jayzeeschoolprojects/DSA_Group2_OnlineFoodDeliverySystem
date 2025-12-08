import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RegisterPage extends JPanel {
    public RegisterPage(OnlineFoodDeliverySystem app) {
        setLayout(new BorderLayout(10,10));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Register Account", TitledBorder.CENTER, TitledBorder.TOP));

        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 25));
        JTextField addressField = new JTextField();
        addressField.setPreferredSize(new Dimension(200, 25));
        JTextField userField = new JTextField();
        userField.setPreferredSize(new Dimension(200, 25));
        JPasswordField passField = new JPasswordField();
        passField.setPreferredSize(new Dimension(200, 25));

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        namePanel.add(new JLabel("Full Name:"));
        namePanel.add(nameField);

        JPanel addrPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        addrPanel.add(new JLabel("Address:"));
        addrPanel.add(addressField);

        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        userPanel.add(new JLabel("Username:"));
        userPanel.add(userField);

        JPanel passPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        passPanel.add(new JLabel("Password:"));
        passPanel.add(passField);

        formPanel.add(namePanel);
        formPanel.add(addrPanel);
        formPanel.add(userPanel);
        formPanel.add(passPanel);

        add(formPanel, BorderLayout.CENTER);

        JButton registerBtn = new JButton("Register");
        registerBtn.addActionListener(_ -> {
            String n = nameField.getText();
            String addr = addressField.getText();
            String u = userField.getText();
            String p = new String(passField.getPassword());

            if (n.isEmpty() || addr.isEmpty() || u.isEmpty() || p.isEmpty()) {
                JOptionPane.showMessageDialog(app, "All fields must be filled.");
                return;
            }

            UserAccount.name = n;
            UserAccount.address = addr;
            UserAccount.username = u;
            UserAccount.password = p;

            app.customerName.setText(n);
            app.customerAddress.setText(addr);

            JOptionPane.showMessageDialog(app, "Account created. Please login.");
            app.showPage("Login");
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        btnPanel.add(registerBtn);
        add(btnPanel, BorderLayout.SOUTH);
    }
}
