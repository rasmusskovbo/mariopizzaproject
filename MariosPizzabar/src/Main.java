import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        PizzaMenu pizzaMenu = new PizzaMenu();
        System.out.print(pizzaMenu.toString());
        pizzaMenu.sort();
        System.out.print(pizzaMenu.toString());

        Order ordre1 = new Order(LocalTime.of(10,45));
        ordre1.addPizzaToOrder(pizzaMenu, 1);
        ordre1.addPizzaToOrder(pizzaMenu, 2);
        Order ordre2 = new Order(LocalTime.of(14,30));
        ordre2.addPizzaToOrder(pizzaMenu,2);
        Order ordre3 = new Order(LocalTime.of(12,15));
        ordre3.addPizzaToOrder(pizzaMenu,3);

        OrderList orderList = new OrderList();
        orderList.addOrder(ordre1);
        orderList.addOrder(ordre2);
        orderList.addOrder(ordre3);
        System.out.println(orderList);

        orderList.sortByPickupTime();

        System.out.println(orderList);
    }
}
