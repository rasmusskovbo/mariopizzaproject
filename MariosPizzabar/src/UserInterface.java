public class UserInterface {

    public void displayMainMenu() {
        System.out.println("\n--Main Menu--");
        System.out.println("1. See menu");
        System.out.println("2. See current orders");
        System.out.println("3. Create order");
        System.out.println("4. Remove order");
        System.out.println("5. Statistics");
        System.out.println("6. Exit");
        System.out.print("Enter option: ");
    }

    public void displayMsg(String text){
        System.out.println(text);
    }

    public void returnOption() {

        displayMsg("Press enter to return to the main menu.");

        try {
            System.in.read();
        }
        catch (Exception e) {
        }

    }
 }

