import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RestaurantOptions extends JPanel {
    public RestaurantOptions(OnlineFoodDeliverySystem app) {
        setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        formPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Select Restaurant", TitledBorder.CENTER, TitledBorder.TOP));

        JLabel label = new JLabel("Restaurant:");
        JComboBox<String> combo = app.restaurant;
        combo.setPreferredSize(new Dimension(200, 25)); // Fix width

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
