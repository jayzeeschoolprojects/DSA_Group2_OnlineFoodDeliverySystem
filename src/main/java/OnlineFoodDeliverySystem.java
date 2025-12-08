import javax.swing.*;
import java.awt.*;

public class OnlineFoodDeliverySystem extends JFrame {
    JPanel mainPanel;
    CardLayout cardLayout;

    JTextField customerName;
    JTextField customerAddress;
    JComboBox<String> restaurant;
    JCheckBox item1, item2, item3;
    JLabel nameLabel, addressLabel, restaurantLabel, orderLabel, statusLabel;

    public OnlineFoodDeliverySystem() {
        setTitle("Online Food Delivery System");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        customerName = new JTextField();
        customerAddress = new JTextField();
        restaurant = new JComboBox<>(new String[]{"Pizza Shop", "Burger Shop", "Pasta Shop"});
        item1 = new JCheckBox();
        item2 = new JCheckBox();
        item3 = new JCheckBox();
        nameLabel = new JLabel();
        addressLabel = new JLabel();
        restaurantLabel = new JLabel();
        orderLabel = new JLabel();
        statusLabel = new JLabel();

        mainPanel.add(new RestaurantOptions(this), "Step1");
        mainPanel.add(new OrderOptions(this), "Step2");
        mainPanel.add(new OrderSummary(this), "Step3");
        mainPanel.add(new LoginPage(this), "Login");
        mainPanel.add(new RegisterPage(this), "Register");

        add(mainPanel);
    }

    public void showPage(String name) {
        cardLayout.show(mainPanel, name);
    }

    public static void main(String[] args) {
        new OnlineFoodDeliverySystem().setVisible(true);
    }
}
