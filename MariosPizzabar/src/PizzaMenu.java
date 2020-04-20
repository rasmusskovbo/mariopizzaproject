import java.util.ArrayList;

public class PizzaMenu {
    private ArrayList<Pizza> pizzaMenu = new ArrayList<>();

    public PizzaMenu() {
        createMenu();
    }

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

    public void createMenu() {
        Pizza test = new Pizza(5,"Test","tomatsauce, ost, skinke og oregano",57);
        Pizza vesuvio = new Pizza(1,"Vesuvio","tomatsauce, ost, skinke og oregano",57);
        Pizza amerikaner = new Pizza(2,"Amerikaner","tomatsauce, ost, skinke og oregano",57);

        pizzaMenu.add(test);
        pizzaMenu.add(vesuvio);
        pizzaMenu.add(amerikaner);
    }

    public void add(Pizza pizza) {
        pizzaMenu.add(pizza);
    }

    public ArrayList<Pizza> getPizzaMenu() {
        return pizzaMenu;
    }

    public void setPizzaMenu(ArrayList<Pizza> pizzaMenu) {
        this.pizzaMenu = pizzaMenu;
    }

    public void pizzaTest() {
        System.out.println(pizzaMenu.get(0));
    }
}
