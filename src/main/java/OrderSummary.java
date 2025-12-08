import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class OrderSummary extends JPanel {
    public OrderSummary(OnlineFoodDeliverySystem app) {
        setLayout(new BorderLayout(10,10));

        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel authPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

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

        topPanel.add(authPanel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        JPanel summaryPanel = new JPanel(new GridLayout(6,1,5,5));
        summaryPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Order Summary", TitledBorder.CENTER, TitledBorder.TOP));

        app.nameLabel = new JLabel();
        app.addressLabel = new JLabel();
        app.restaurantLabel = new JLabel();
        app.orderLabel = new JLabel();
        app.statusLabel = new JLabel();

        summaryPanel.add(app.nameLabel);
        summaryPanel.add(app.addressLabel);
        summaryPanel.add(app.restaurantLabel);
        summaryPanel.add(app.orderLabel);
        summaryPanel.add(app.statusLabel);

        JButton newOrderButton = new JButton("New Order");
        newOrderButton.addActionListener(_ -> {
            app.item1.setSelected(false);
            app.item2.setSelected(false);
            app.item3.setSelected(false);
            app.showPage("Step1");
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newOrderButton);
        summaryPanel.add(buttonPanel);

        add(summaryPanel, BorderLayout.CENTER);
    }
}