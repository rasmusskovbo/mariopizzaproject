import java.util.Scanner;

public class UserInterface {
    private Scanner in = new Scanner(System.in);

    public void displayMainMenu() {
        displayMsg("\n--Main Menu--");
        displayMsg("1. See menu");
        displayMsg("2. See current orders");
        displayMsg("3. Create order");
        displayMsg("4. Remove order");
        displayMsg("5. Statistics");
        displayMsg("6. Exit");
        displayMsg("Enter option: ");
    }

    public void displayMsg(String text){
        System.out.println(text);
    }

    public void displayRemoveOrderMenu() {
        displayMsg("Is order complete or cancelled?");
        displayMsg("1. Complete");
        displayMsg("2. Cancelled");
    }

    public void enterToReturn() {

        displayMsg("Press enter to return to the main menu.");

        in.nextLine();

    }
 }

