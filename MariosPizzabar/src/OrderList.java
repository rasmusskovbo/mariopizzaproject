import java.util.ArrayList;

public class OrderList {
    private ArrayList<Order> orderList = new ArrayList<>();

    public OrderList() {

    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void removeOrder(int index) {
        orderList.remove(index);
    }

    public void sortByPickupTime() {
        orderList.sort(Order::compareTo);
    }

    public String toString() {
        String print = "";
        for (Order order:orderList) {
            print += order.toString();
            print += "\n";
        }
        return print;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
}
