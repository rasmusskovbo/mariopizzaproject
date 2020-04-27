import java.time.LocalTime;
import java.util.Scanner;

    public class Handler {
        private PizzaMenu pizzaMenu = new PizzaMenu();
        private OrderList orderList = new OrderList();
        private UserInterface ui = new UserInterface();
        private Scanner input = new Scanner(System.in);
        private Statistics statistics = new Statistics();

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
                    ui.enterToReturn();
                    break;

                case 2:
                    seeOrders();
                    ui.enterToReturn();
                    break;

                case 3:
                    createOrder();
                    ui.enterToReturn();
                    break;

                case 4:
                    removeOrder();
                    ui.enterToReturn();
                    break;

                case 5:
                    showStatistics();
                    ui.enterToReturn();
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

            if (isOrderAvailable()) {
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
            Order order = createOrderLoop(amountPizza, hour, minute);

            orderList.addOrder(order);
            ui.displayMsg("New order confirmed: "+order.toString());

        }

        public void removeOrder() {
            ui.displayMsg("\n--Remove Order--");
            if (isOrderAvailable()) {
                orderList.sortByPickupTime();
                seeOrders();

                ui.displayMsg("Please enter ID of the order you would like to remove. 0 to return to menu: ");
                Order orderHolder = removeOrderLoop(); //returner null object hvis brugeren vil forlade menu

                if (orderHolder != null) { //hvis brugeren vil forlade menuen ref ovenstående springes dette over.
                    if (isOrderComplete(orderHolder)) {
                        ui.displayMsg("You've succesfully completed order no.: " + orderHolder.getOrderID()+". It has been added to statistics");
                        statistics.addOrder(orderHolder);
                    } else {
                        ui.displayMsg("You've succesfully removed order no.: " + orderHolder.getOrderID());
                    }

                }
            }
        }

        public void showStatistics() {
            ui.displayMsg("--Statistics--");
            ui.displayMsg("Total revenue: "+statistics.getTotalRevenue());
            ui.displayMsg("Total pizzas sold: "+statistics.getTotalPizzasSold());
            ui.displayMsg("Sold pizzas by menu no:  1  2  3  4  5  6  7  8  9  10 11 12 13 14");
            ui.displayMsg("                        "+statistics.getSoldPizzaTracker());
        }

        public boolean isOrderComplete(Order order) {
            ui.displayRemoveOrderMenu();
            while (true) {
                switch (intValidation(2,0)) {

                    // complete
                    case 1:
                        return true;

                    // cancelled
                    case 2:
                        return false;
                }
            }
        }

        public Order createOrderLoop(int amountOfPizza, int hour, int minute) {
            Order order = new Order(LocalTime.of(hour, minute));

            while (amountOfPizza > 0) {
                ui.displayMsg("(Pizzas left to enter "+amountOfPizza+"). Enter pizza ID from menu: ");
                order.addPizza(pizzaMenu.getPizzaMenu().get(intValidation(14,1) - 1));
                amountOfPizza--;
            }
            return order;
        }

        public Order removeOrderLoop() {
            boolean flag = false;
            Order removedOrder = null;
            while (!flag) {
                int choice = 0;
                choice = intValidation(orderList.getOrderList().get(0).getOrderIDcount(), -1);
                if (choice == 0) {
                    return null;
                } else {
                    for (int i = 0; i < orderList.getOrderList().size(); i++) {
                        if (orderList.getOrderList().get(i).getOrderID() == choice) {
                            removedOrder = orderList.getOrderList().get(i);
                            orderList.removeOrder(i);
                            flag = true;
                        }
                    }
                    if (flag == false) {
                        ui.displayMsg("Order ID not found. Please check your input.");
                    }
                }
            }
            return removedOrder;
        }

        public boolean isOrderAvailable() {
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
                choice = 0; //reset valg efter hvert loop
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

