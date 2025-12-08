import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class OrderOptions extends JPanel {
    public OrderOptions(OnlineFoodDeliverySystem app) {
        setLayout(new BorderLayout(10,10));

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

        JPanel menuPanel = new JPanel(new GridLayout(5,1,10,10));
        menuPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Select Items to Order", TitledBorder.CENTER, TitledBorder.TOP));

        menuPanel.add(new JLabel("Available Items:"));
        menuPanel.add(app.item1);
        menuPanel.add(app.item2);
        menuPanel.add(app.item3);

        add(menuPanel, BorderLayout.CENTER);

        JButton placeOrderButton = new JButton("Place Order");
        placeOrderButton.addActionListener(_ -> {
            if (!UserAccount.loggedIn) {
                JOptionPane.showMessageDialog(app, "Please login first to complete the order.");
                app.showPage("Login");
                return;
            }

            String restaurant = (String) app.restaurant.getSelectedItem();
            StringBuilder items = new StringBuilder();
            if (app.item1.isSelected()) items.append(app.item1.getText()).append(" ");
            if (app.item2.isSelected()) items.append(app.item2.getText()).append(" ");
            if (app.item3.isSelected()) items.append(app.item3.getText()).append(" ");
            if (items.isEmpty()) items.append("No items selected");

            app.nameLabel.setText("Full Name: " + UserAccount.name);
            app.addressLabel.setText("Address: " + UserAccount.address);
            app.restaurantLabel.setText("Restaurant: " + restaurant);
            app.orderLabel.setText("Order: " + items);
            app.statusLabel.setText("Status: Preparing...");

            app.showPage("Step3");
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        buttonPanel.add(placeOrderButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}