import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RestaurantOptions extends JPanel {
    public RestaurantOptions(OnlineFoodDeliverySystem app) {
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel authPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        if (UserAccount.loggedIn) {
            JLabel userLabel = new JLabel("Welcome, " + UserAccount.name);
            userLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
            authPanel.add(userLabel);

            JButton logoutButton = new JButton("Logout");
            logoutButton.addActionListener(_ -> {
                UserAccount.loggedIn = false;
                JOptionPane.showMessageDialog(app, "Logged out successfully.");
                app.refreshPage("Step1");
            });
            authPanel.add(logoutButton);
        } else {
            JButton loginButton = new JButton("Login");
            loginButton.addActionListener(_ -> app.showPage("Login"));
            authPanel.add(loginButton);

            JButton registerButton = new JButton("Register");
            registerButton.addActionListener(_ -> app.showPage("Register"));
            authPanel.add(registerButton);
        }

        topPanel.add(authPanel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        formPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Select Restaurant", TitledBorder.CENTER, TitledBorder.TOP));

        JLabel label = new JLabel("Restaurant:");
        JComboBox<String> combo = app.restaurant;
        combo.setPreferredSize(new Dimension(200, 25));

        formPanel.add(label);
        formPanel.add(combo);

        add(formPanel, BorderLayout.CENTER);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(_ -> {
            MenuManager.updateMenuItems(app);
            app.showPage("Step2");
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}