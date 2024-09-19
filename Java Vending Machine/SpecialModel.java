// ANG, Janell & DIMLA, Kian <S17A>

import java.util.*;

/**
 * SpecialModel class that represents a special vending machine object.
 * 
 * Inherits attributes and methods from the RegularModel class.
 */
public class SpecialModel extends RegularModel {

    /**
     * SpecialModel object constructor that
     * initializes its class attributes.
     */
    public SpecialModel() {
        super();
    }

    /**
     * Initializes the itemList.
     */
    @Override
    public void initializeItems() {
        itemList.add(new Item("Ice Cream", 50.00, 15, 250));
        itemList.add(new Item("Bread", 12.50, 100, 60));
        itemList.add(new Item("Pork Cutlet", 100.00, 100, 240));
        itemList.add(new Item("Beef Soup", 60.00, 100, 105));

        itemList.add(new Item("Egg", 15.00, 100, 20));
        itemList.add(new Item("Noodles", 15.00, 100, 25));

        itemList.add(new SpecialItem("Katsudon", 150.0, 300));
        itemList.add(new SpecialItem("Ramen", 130.0, 150));
        itemList.add(new SpecialItem("Egg Sandwich", 60.0, 150));
        itemList.add(new SpecialItem("Ice Cream Sandwich", 100.0, 200));
    }

    /**
     * Dispenses the item at the specified index and updates the balance and transaction list.
     *
     * @param index The index of the item to dispense.
     */
    public void dispense(int index) {
        Transaction transaction;
        Item item = itemList.get(index);

        if (item instanceof SpecialItem) {
            switch (index) {
                case 6: // Katsudon
                    itemList.get(2).dispense();
                    itemList.get(4).dispense();
                    itemList.get(4).dispense();
                    break;
                case 7: // Ramen
                    itemList.get(3).dispense();
                    itemList.get(5).dispense();
                    break;
                case 8: // Egg Sandwich
                    itemList.get(1).dispense();
                    itemList.get(4).dispense();
                    break;
                case 9: // Ice Cream Sandwich
                    itemList.get(0).dispense();
                    itemList.get(1).dispense();
                    break;
            }
        } else {
            item.dispense();
        }

        balance -= item.getPrice();
        collectPayment += item.getPrice();
        transaction = new Transaction(item, 1, item.getPrice(), restockSession);
        transactionList.add(transaction);
    }
}
