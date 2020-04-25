import java.time.LocalTime;
import java.util.ArrayList;

public class Order implements Comparable<Order> {
    private static int orderIDcount = 99;
    private int orderID;
    private LocalTime pickupTime;
    private ArrayList<Pizza> pizzas = new ArrayList<>();

    public Order (LocalTime pickupTime) {
        this.pickupTime = pickupTime;
        orderIDcount++;
        orderID = orderIDcount;
    }


    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    // Tager pizzaMenuen som reference, kopierer referencen til pizzaen på valgte index (fx 1 for Vesuvio) og tilføjer den til ordrens ArrayList
    public void addPizzaToOrder(PizzaMenu pizzaMenu, int number) {
        pizzas.add(pizzaMenu.getPizzaMenu().get(number-1));
    }

    // Sammenligner tidspunktet når OrderList skal sammenligne.
    public int compareTo(Order other) {
        // return this.pickupTime.compareTo(other.pickupTime);

        if (other.pickupTime.isBefore(pickupTime)) {
            return +1;
        } else if (other.pickupTime.isAfter(pickupTime)) {
            return -1;
        } else {
            return 0;
        }
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
}
