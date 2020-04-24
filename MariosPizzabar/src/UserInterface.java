import java.util.Scanner;

public class UserInterface {

    Scanner input = new Scanner(System.in);
    int number;




    public void userDisplayMessage(String text){
        System.out.println(text);
    }



    public int pickingMenuOptionNumber() {

        number = input.nextInt(); //skal valideres
        input.nextLine(); //clear buffer
        return number;


    }


    public int orderPizzaAmount () {

        number = input.nextInt(); //skal valideres
        input.nextLine(); //clear buffer
        return number;

    }

    public int orderDelieveryHour() {


        number = input.nextInt(); //skal valideres
        input.nextLine(); //clear buffer
        return number;
    }


    public int orderDelieveryMinute() {

        number = input.nextInt(); //skal valideres
        input.nextLine(); //clear buffer
        return number;
    }


    public int orderPizzaNumber() {

        number = input.nextInt(); //skal valideres
        input.nextLine(); //clear buffer
        return number;
    }

    public int removeOrder() {

        number = input.nextInt() - 1; //skal valideres.. Minus 1 fordi, arraylist indexer fra 0
        input.nextLine(); //clear buffer
        return number;


    }


}
