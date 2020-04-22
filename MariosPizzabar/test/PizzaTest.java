import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @org.junit.jupiter.api.Test
    void compareTo_SmallerComesFirst() {
        Pizza test1 = new Pizza(1,"Test","tomatsauce, ost, skinke og oregano",57);
        Pizza test2 = new Pizza(2,"Test","tomatsauce, ost, skinke og oregano",57);

        assertEquals(-1, test1.compareTo(test2));
    }

    @org.junit.jupiter.api.Test
    void compareTo_HigherComesLast() {
        Pizza test1 = new Pizza(1,"Test","tomatsauce, ost, skinke og oregano",57);
        Pizza test2 = new Pizza(2,"Test","tomatsauce, ost, skinke og oregano",57);

        assertEquals(1, test2.compareTo(test1));
    }

    @org.junit.jupiter.api.Test
    void compareTo_isEqual() {
        Pizza test1 = new Pizza(1,"Test","tomatsauce, ost, skinke og oregano",57);

        assertEquals(0, test1.compareTo(test1));
    }
}