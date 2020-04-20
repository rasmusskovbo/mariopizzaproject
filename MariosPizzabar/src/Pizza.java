public class Pizza implements Comparable<Pizza>, Cloneable {
    private int index;
    private String name;
    private String ingredients;
    private int price;

    public Pizza(int index, String name, String ingredients, int price) {
        this.index = index;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    // printer pizza ud som på menukortet.
    public String toString() {
        return String.format("%d. %s: %s.....%d.-",index, name, ingredients, price );
    }

    // Sammenligner pizzaer med hinanden baseret på menu index, hvis ikke de er addet i rækkefølge.
    @Override
    public int compareTo(Pizza other) {
        return this.getIndex()-other.getIndex();
    }

    // implementerer muligheden for at shallow clone pizza object
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // getters & setters
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
