// ANG, Janell & DIMLA, Kian <S17A>

import java.util.ArrayList;

/**
 * Item class that contains item information and
 * methods to edit some item values.
 */
public class Item {
    /**
     * Item's name.
     */
    protected String name;

    /**
     * Item's price.
     */
    protected double price;

    /**
     * Item's calories.
     */
    protected int calories;
    
    /**
     * Item's objects.
     */
    protected ArrayList<Item> quantity = new ArrayList<>();

    /**
     * Item object constructor.
     * 
     * @param name Item's name
     * @param price Item's price
     * @param quantity Item's quantity
     * @param calories Item's calories
     */
    public Item(String name, double price, int quantity, int calories) {
        this.name = name;
        this.price = price;
        for (int i = 0; i < quantity; i++) {
            this.quantity.add(new Item());
        }
        this.calories = calories;
    }

    /**
     * Item object acting as the stock objects
     */
    public Item() {

    }

    /**
     * Returns name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns price
     * 
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns quantity
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity.size();
    }

    /**
     * Returns calories
     * 
     * @return calories
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Changes the item quantity
     * 
     * @param quantity Item's quantity to add
     */
    public void addQuantity(int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.quantity.add(new Item());
        }
    }

    /**
     * Changes the item price
     * 
     * @param price Item's new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Dispenses an item object from the vending machine.
     */
    public void dispense() {
        quantity.remove(0);
    }

    /**
     * Checks if an item is available if quantity is greater
     * than or equal to 10.
     * 
     * @return result
     */
    public boolean isAvailable() {
        boolean result = false;
        if (quantity.size() >= 10) {
            result = true;
        }
        return result;
    }

    /**
     * Checks if an item is available if quantity is greater
     * than or equal to 10 and returns a string accordingly.
     * 
     * @return result
     */
    public String availableToString() {
        String result = "Unavailable";
        if (quantity.size() >= 10) {
            result = "Available";
        }
        return result;
    }
}