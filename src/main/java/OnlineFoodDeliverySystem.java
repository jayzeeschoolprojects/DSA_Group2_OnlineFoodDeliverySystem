import javax.swing.*;
import java.awt.*;

class OnlineFoodDeliverySystem extends JFrame {

    private final JPanel mainPanel;
    private final CardLayout cardLayout;
    private JTextField customerName;
    private JTextField customerAddress;
    private JComboBox<String> restaurant;
    private JCheckBox item1, item2, item3;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel restaurantLabel;
    private JLabel orderLabel;
    private JLabel statusLabel;

    OnlineFoodDeliverySystem() {
        setTitle("Online Food Delivery System");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(firstPage(), "Step1");
        mainPanel.add(secondPage(), "Step2");
        mainPanel.add(thirdPage(), "Step3");

        add(mainPanel);
    }

    private JPanel firstPage() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(new JLabel("Name:"));
        customerName = new JTextField();
        formPanel.add(customerName);

        formPanel.add(new JLabel("Address:"));
        customerAddress = new JTextField();
        formPanel.add(customerAddress);

        formPanel.add(new JLabel("Choose Restaurant:"));
        restaurant = new JComboBox<>(new String[]{"Pizza Shop", "Burger Shop", "Pasta Shop"});
        formPanel.add(restaurant);

        panel.add(formPanel, BorderLayout.CENTER);

        JButton nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(100, 30));
        nextButton.addActionListener(_ -> {
            if (customerName.getText().isEmpty() || customerAddress.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name and address!");
            } else {
                updateMenuItems();
                cardLayout.show(mainPanel, "Step2");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        buttonPanel.add(nextButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel secondPage() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel menuPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        menuPanel.add(new JLabel("Select items to order:"));

        item1 = new JCheckBox();
        item2 = new JCheckBox();
        item3 = new JCheckBox();

        menuPanel.add(item1);
        menuPanel.add(item2);
        menuPanel.add(item3);

        panel.add(menuPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createPlaceOrderButton());
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JButton createPlaceOrderButton() {
        JButton placeOrderButton = new JButton("Place Order");
        placeOrderButton.setPreferredSize(new Dimension(120, 30));
        placeOrderButton.addActionListener(_ -> {
            String selectedRestaurant = (String) restaurant.getSelectedItem();
            if (selectedRestaurant == null) selectedRestaurant = "";

            StringBuilder items = new StringBuilder();
            if (item1.isSelected()) items.append(item1.getText()).append(" ");
            if (item2.isSelected()) items.append(item2.getText()).append(" ");
            if (item3.isSelected()) items.append(item3.getText()).append(" ");
            if (items.isEmpty()) items.append("No items selected");

            nameLabel.setText("Customer: " + customerName.getText());
            addressLabel.setText("Address: " + customerAddress.getText());
            restaurantLabel.setText("Restaurant: " + selectedRestaurant);
            orderLabel.setText("Order: " + items);
            statusLabel.setText("Status: Preparing...");

            cardLayout.show(mainPanel, "Step3");
        });
        return placeOrderButton;
    }

    private JPanel thirdPage() {
        JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        nameLabel = new JLabel();
        addressLabel = new JLabel();
        restaurantLabel = new JLabel();
        orderLabel = new JLabel();
        statusLabel = new JLabel();

        panel.add(nameLabel);
        panel.add(addressLabel);
        panel.add(restaurantLabel);
        panel.add(orderLabel);
        panel.add(statusLabel);

        JButton backButton = new JButton("New Order");
        backButton.addActionListener(_ -> {
            customerName.setText("");
            customerAddress.setText("");
            item1.setSelected(false);
            item2.setSelected(false);
            item3.setSelected(false);
            cardLayout.show(mainPanel, "Step1");
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        panel.add(buttonPanel);

        return panel;
    }

    private void updateMenuItems() {
        String selectedRestaurant = (String) restaurant.getSelectedItem();
        if (selectedRestaurant == null) selectedRestaurant = "";

        switch (selectedRestaurant) {
            case "Pizza Shop" -> {
                item1.setText("Margherita Pizza");
                item2.setText("Pepperoni Pizza");
                item3.setText("Veggie Pizza");
            }
            case "Burger Shop" -> {
                item1.setText("Cheeseburger");
                item2.setText("Chicken Burger");
                item3.setText("Veggie Burger");
            }
            case "Pasta Shop" -> {
                item1.setText("Spaghetti");
                item2.setText("Fettuccine Alfredo");
                item3.setText("Penne Arrabiata");
            }
        }

        item1.setSelected(false);
        item2.setSelected(false);
        item3.setSelected(false);
    }
}
