import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class OrderSummary extends JPanel {
    public OrderSummary(OnlineFoodDeliverySystem app) {
        setLayout(new GridLayout(6,1,5,5));
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Order Summary", TitledBorder.CENTER, TitledBorder.TOP));

        app.nameLabel = new JLabel();
        app.addressLabel = new JLabel();
        app.restaurantLabel = new JLabel();
        app.orderLabel = new JLabel();
        app.statusLabel = new JLabel();

        add(app.nameLabel);
        add(app.addressLabel);
        add(app.restaurantLabel);
        add(app.orderLabel);
        add(app.statusLabel);

        JButton newOrderButton = new JButton("New Order");
        newOrderButton.addActionListener(_ -> {
            app.item1.setSelected(false);
            app.item2.setSelected(false);
            app.item3.setSelected(false);
            app.showPage("Step1");
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newOrderButton);
        add(buttonPanel);
    }
}
