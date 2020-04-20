import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Order implements Comparable<Order> {
    private LocalTime pickupTime;
    private ArrayList<Pizza> pizzas = new ArrayList<>();

    public Order (LocalTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    // Tager pizzaMenuen som reference, kopierer referencen til pizzaen på valgte index (fx 1 for Vesuvio) og tilføjer den til ordrens ArrayList
    public void addPizzaToOrder(PizzaMenu pizzaMenu, int index) {
        pizzas.add(pizzaMenu.getPizzaMenu().get(index-1));
    }

    // Sammenligner tidspunktet når OrderList skal sammenligne.
    public int compareTo(Order other) {
        if (other.pickupTime.isBefore(pickupTime)) {
            return +1;
        } else if (other.pickupTime.isAfter(pickupTime)) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return String.format("Pick-up: "+pickupTime+", "+pizzas);
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
