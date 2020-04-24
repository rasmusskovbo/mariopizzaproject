import java.time.LocalTime;
import java.util.Scanner;

public class Machine {


    PizzaMenu pizzaMenu = new PizzaMenu();
    OrderList orderList = new OrderList();
    UserInterface userInterface = new UserInterface();

    Scanner input = new Scanner(System.in);


    public Machine() {


        //oprettelse eksempel
        Order ordre1 = new Order(LocalTime.of(10, 45));
        ordre1.addPizzaToOrder(pizzaMenu, 1);
        ordre1.addPizzaToOrder(pizzaMenu, 2);
        orderList.addOrder(ordre1);


        Order ordre2 = new Order(LocalTime.of(14,30));
        ordre2.addPizzaToOrder(pizzaMenu,2);
        orderList.addOrder(ordre2);

        Order ordre3 = new Order(LocalTime.of(12,15));
        ordre3.addPizzaToOrder(pizzaMenu,3);
        orderList.addOrder(ordre3);



        menu();

    }


    public void menu() {


        while (true) {


            System.out.println("\nMenu - Pick option");
            System.out.println("1. See menu");
            System.out.println("2. Current orders ");
            System.out.println("3. Make order");
            System.out.println("4. Remove order");
            System.out.println("5. Statistic");
            System.out.println("6. Exit machine");
            System.out.print("Enter option: ");

            pickingMenuOption();


        }


    }


    public void pickingMenuOption() {

        int tal = userInterface.pickingMenuOptionNumber();

        switch (tal) {

            case 1:
                System.out.println("\n" + pizzaMenu);
                System.out.print("Press enter to return to menu: ");
                input.nextLine();

                break;


            case 2:

                if (orderList.getOrderList().size() == 0) {
                    System.out.print("No orders. Press enter to return to menu: ");
                    input.nextLine();

                } else {

                    orderList.sortByPickupTime();
                    System.out.println("\n" + orderList);

                    System.out.print("Press enter to return to menu: ");
                    input.nextLine();

                }

                break;


            case 3:

                //insæt i metoder - delmetoder
                userInterface.userDisplayMessage("How manny pizzas do you want?"); //anbefaling ny måde

                int amountPizza = userInterface.orderPizzaNumber();


                System.out.print("Type in hour for delivery: ");
                int hour = userInterface.orderDelieveryHour();

                System.out.print("Type in minute for delivery: ");
                int minute = userInterface.orderDelieveryMinute();


                Order ordreIndtastning = new Order(LocalTime.of(hour, minute));
                orderList.addOrder(ordreIndtastning);

                System.out.print("Pick a pizza: ");
                ordreIndtastning.addPizzaToOrder(pizzaMenu, userInterface.orderPizzaNumber());

                if (amountPizza > 1) {

                    for (int i = 2; i <= amountPizza; i++) { //starter fra 2, da den opretter endnu pizza

                        System.out.print("Pick a pizza again: ");
                        ordreIndtastning.addPizzaToOrder(pizzaMenu, userInterface.orderPizzaNumber());

                    }


                }

                System.out.println("\nYou've ordered: " + ordreIndtastning);
                System.out.print("Press enter to return to menu: ");
                input.nextLine();
                break;



            case 4:

                orderList.sortByPickupTime();
                System.out.print("What order do you wanna remove?: ");
                orderList.removeOrder(userInterface.removeOrder());

                System.out.println("\nYou've removed: " + orderList.getRemoved());
                System.out.print("Press enter to return to menu: ");
                input.nextLine();
                break;

            case 5:

                //Statistik skal laves
                System.out.print("Under construction. Press enter to return to menu: ");
                input.nextLine();

                break;


            case 6:
                System.exit(0);


        }
    }


}
