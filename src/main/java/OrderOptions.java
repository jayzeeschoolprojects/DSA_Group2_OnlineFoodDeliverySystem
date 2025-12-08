import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class OrderOptions extends JPanel {
    public OrderOptions(OnlineFoodDeliverySystem app) {
        setLayout(new BorderLayout(10,10));

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
