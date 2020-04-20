import java.util.ArrayList;

public class PizzaMenu {
    private ArrayList<Pizza> pizzaMenu = new ArrayList<>();

    public PizzaMenu() {
        createMenu();
    }

    // sorterer jf. Pizza klasses compareTo metode.
    public void sort() {
        pizzaMenu.sort(Pizza::compareTo);
    }

    public String toString() {
        String print = "";
        for (Pizza pizza:pizzaMenu) {
            print += pizza.toString();
            print += "\n";
        }
        return print;
    }

    // instancierer pizzaer og tilføjer dem til menu
    public void createMenu() {
        Pizza test = new Pizza(5,"Test","tomatsauce, ost, skinke og oregano",57);
        Pizza vesuvio = new Pizza(1,"Vesuvio","tomatsauce, ost, skinke og oregano",57);
        Pizza amerikaner = new Pizza(2,"Amerikaner","tomatsauce, ost, skinke og oregano",57);

        pizzaMenu.add(test);
        pizzaMenu.add(vesuvio);
        pizzaMenu.add(amerikaner);
    }

    // tilføjer pizzaer til menu
    public void add(Pizza pizza) {
        pizzaMenu.add(pizza);
    }

    // getters & setters
    public ArrayList<Pizza> getPizzaMenu() {
        return pizzaMenu;
    }

    public void setPizzaMenu(ArrayList<Pizza> pizzaMenu) {
        this.pizzaMenu = pizzaMenu;
    }
}
