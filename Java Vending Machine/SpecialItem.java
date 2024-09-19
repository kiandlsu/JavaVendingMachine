// ANG, Janell & DIMLA, Kian <S17A>

import java.util.ArrayList;

/**
 * SpecialItem class that inherits attributes and methods
 * from the Item class.
 */
public class SpecialItem extends Item {

    /**
     * SpecialItem object constructor.
     *
     * @param name Special item's name
     * @param price Special item's price
     * @param calories Special item's calories
     */
    public SpecialItem(String name, double price, int calories) {
        super(name, price, 0, calories); 
    }
}