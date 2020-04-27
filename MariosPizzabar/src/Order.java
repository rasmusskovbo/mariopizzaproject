import java.time.LocalTime;
import java.util.ArrayList;

public class Order implements Comparable<Order> {
    private static int orderIDcount = 99;
    private int orderID;
    private LocalTime pickupTime;
    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private boolean isOrderComplete = false;

    public Order (LocalTime pickupTime) {
        this.pickupTime = pickupTime;
        orderIDcount++;
        orderID = orderIDcount;
    }


    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    // Sammenligner tidspunktet når OrderList skal sammenligne.
    public int compareTo(Order other) {
        return this.pickupTime.compareTo(other.pickupTime);
    }

    // Komprimeret visning af pizzaer sammen med respektiv pick-up time
    public String toString() {
        String print = "";
        for (Pizza pizza:pizzas) {
            print += pizza.getNumber()+"-";
            print += pizza.getName()+"  ";
        }
        return String.format("Pick-up time: "+pickupTime+", Order ID: "+orderID+", Pizzas: "+print);
    }

    // getters & setters
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getOrderIDcount() {
        return orderIDcount;
    }

    public LocalTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public boolean isOrderComplete() {
        return isOrderComplete;
    }

    public void setOrderComplete(boolean orderComplete) {
        isOrderComplete = orderComplete;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Pizza pizza:pizzas) {
            totalPrice += pizza.getPrice();
        }
        return totalPrice;
    }
}
