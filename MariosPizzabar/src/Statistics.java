import java.util.ArrayList;
import java.util.Arrays;

public class Statistics {
    private ArrayList<Order> completedOrders = new ArrayList<>();
    private int totalRevenue;
    private int totalPizzasSold;
    private int[] soldPizzaTracker = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    // ikke scalable direkte i systemet. Evt implementere Arraylist<Integer> hvis nødvendigt

    public void addOrder(Order order) {
        for (Pizza pizza : order.getPizzas()) {
            soldPizzaTracker[pizza.getNumber() - 1]++;
        }
        totalRevenue += order.getTotalPrice();
        totalPizzasSold += order.getPizzas().size();
        completedOrders.add(order);
    }

    public String getSoldPizzaTracker() {
        return Arrays.toString(soldPizzaTracker);
    }

    public ArrayList<Order> getCompletedOrders() {
        return completedOrders;
    }

    public void setCompletedOrders(ArrayList<Order> completedOrders) {
        this.completedOrders = completedOrders;
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(int totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public int getTotalPizzasSold() {
        return totalPizzasSold;
    }

    public void setTotalPizzasSold(int totalPizzasSold) {
        this.totalPizzasSold = totalPizzasSold;
    }

    public void setSoldPizzaTracker(int[] soldPizzaTracker) {
        this.soldPizzaTracker = soldPizzaTracker;
    }
}
