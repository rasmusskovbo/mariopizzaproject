import java.time.LocalTime;
import java.util.Scanner;

    public class Handler {
        private PizzaMenu pizzaMenu = new PizzaMenu();
        private OrderList orderList = new OrderList();
        private UserInterface ui = new UserInterface();
        private Scanner input = new Scanner(System.in);

        public Handler() {
            menu();
        }


        public void menu() {

            while (true) {
                ui.displayMainMenu();
                menuOptions();
            }

        }

        public void menuOptions() {

            switch(intValidation(6,1)) {

                case 1:
                    seeMenu();
                    ui.returnOption();
                    break;

                case 2:
                    seeOrders();
                    ui.returnOption();
                    break;

                case 3:
                    createOrder();
                    ui.returnOption();
                    break;

                case 4:
                    removeOrder();
                    ui.returnOption();
                    break;

                case 5:
                    ui.displayMsg("Nothing to see here yet.");
                    ui.returnOption();
                    break;

                case 6:
                    System.exit(0);
            }
        }

        public void seeMenu() {

            ui.displayMsg("\n--Pizza Menu--");
            ui.displayMsg(pizzaMenu.toString());

        }

        public void seeOrders() {
            ui.displayMsg("\n--Current Orders--");

            if (ordersAreAvailable()) {
                orderList.sortByPickupTime();
                ui.displayMsg(orderList.toString());
            }

        }

        public void createOrder() {
            ui.displayMsg("\n--New Order--");
            ui.displayMsg("Please enter amount of pizza: ");
            int amountPizza = intValidation(100,1);

            ui.displayMsg("Please enter hour of pickup: ");
            int hour = intValidation(23,0);

            ui.displayMsg("Please enter minutes of pickup: ");
            int minute = intValidation(59,0);

            // TODO: Evt. check at tid er senere end LocalTime.now
            Order order = new Order(LocalTime.of(hour, minute));

            while (amountPizza > 0) {
                ui.displayMsg("(Pizzas left to enter "+amountPizza+"). Enter pizza ID from menu: ");
                order.addPizza(pizzaMenu.getPizzaMenu().get(intValidation(14,1) - 1));
                amountPizza--;
            }

            ui.displayMsg("New order confirmed: "+order.toString());
            orderList.addOrder(order);

        }

        public void removeOrder() {
            ui.displayMsg("\n--Remove Order--");
            if (ordersAreAvailable()) {
                orderList.sortByPickupTime();
                seeOrders();

                ui.displayMsg("Please enter ID of the order you would like to remove: ");
                boolean flag = false;
                Order removedOrder = null;
                while (!flag) {
                    int choice = intValidation(orderList.getOrderList().get(0).getOrderIDcount(),0);
                    for (int i = 0; i < orderList.getOrderList().size(); i++)
                        if (orderList.getOrderList().get(i).getOrderID() == choice) {
                            removedOrder = orderList.getOrderList().get(i);
                            orderList.removeOrder(i);
                            flag = true;
                        } else {
                            ui.displayMsg("Order ID not found. Please check your input.");
                        }
                }

                ui.displayMsg("You've succesfully removed order no.: " + removedOrder.getOrderID());
            }

        }

        public boolean ordersAreAvailable() {
            if (orderList.getOrderList().size() < 1) {
                ui.displayMsg("Currently no orders.");
                return false;
            } else {
                return true;
            }
        }

        // Tager en max værdi og checker at input er et nummer lige med nul eller større og lavere end max værdi
        public int intValidation(int maxAmount, int minAmount) {
            int choice = 0;
            while (true) {
                choice = 0;
                try {
                    if (!input.hasNextInt()) {
                        input.nextLine();
                        throw new NotAValidOptionException("Not a valid input. Please enter a number: ");
                    } else {
                        choice = input.nextInt();
                        if (choice > maxAmount || choice < 0 || choice < minAmount) {
                            input.nextLine();
                            throw new NotAValidOptionException("Not a valid input. Number must be higher than "+minAmount+" and equal to or lower than " + maxAmount +": ");
                        } else {
                            return choice;
                        }
                    }
                } catch (NotAValidOptionException e) {
                    System.out.print(e);
                }
            }
        }
        /*
        Forsøg med regular expression matching. Mangler måde at skille string af på og gøre til time object.

        public Order finalizeOrder(String pickupTime) {
            BufferedReader = new BufferedReader(pickupTime);
            int hour = reader.nextInt();
            reader.next();
            int minute = reader.nextInt();
            Order order = new Order(LocalTime.of(hour, minute));
            return order;
        }

        public String setPickUpTime() {
            String in = "";
            boolean flag;

            do {
                ui.displayMsg("Type in pick-up time as follows: HH:MM: ");
                String pickupHourPattern = "\\d{2}\\:{1}\\d{2}";
                in = input.next();
                flag = in.matches(pickupHourPattern);
                if (!flag) {
                }
            } while (!flag);

            return in;
        }

        // Simpel int validation
        public int intValidation() {
            while (true) {
                try {
                    if (!input.hasNextInt()) {
                        input.nextLine();
                        throw new NotAValidOptionException("Not a valid input. Please enter a number: ");
                    } else {
                        return input.nextInt();
                    }
                } catch (NotAValidOptionException e) {
                    input.nextLine();
                    System.out.print(e);
                }
            }
        }
        */
    }

