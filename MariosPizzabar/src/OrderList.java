import java.util.ArrayList;

public class OrderList {
    private ArrayList<Order> orderList = new ArrayList<>();
    private Order removed;

    public OrderList() {

    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void removeOrder(int order) {
        removed = orderList.get(order);

        orderList.remove(order);


    }

    public Order getRemoved() {
        return removed;
    }

    public void sortByPickupTime() {
        orderList.sort(Order::compareTo);
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public String toString() {
        String print = "";
        for (Order order : orderList) {
            print += order.toString();
            print += "\n";
        }
        return print;
    }


}
