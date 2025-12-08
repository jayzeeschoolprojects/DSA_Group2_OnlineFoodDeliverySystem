public class MenuManager {

    public static void updateMenuItems(OnlineFoodDeliverySystem app) {
        String selectedRestaurant = (String) app.restaurant.getSelectedItem();

        switch (selectedRestaurant) {
            case "Pizza Shop" -> {
                app.item1.setText("Margherita Pizza");
                app.item2.setText("Pepperoni Pizza");
                app.item3.setText("Veggie Pizza");
            }
            case "Burger Shop" -> {
                app.item1.setText("Cheeseburger");
                app.item2.setText("Chicken Burger");
                app.item3.setText("Veggie Burger");
            }
            case "Pasta Shop" -> {
                app.item1.setText("Spaghetti");
                app.item2.setText("Fettuccine Alfredo");
                app.item3.setText("Penne Arrabiata");
            }
        }

        app.item1.setSelected(false);
        app.item2.setSelected(false);
        app.item3.setSelected(false);
    }
}
