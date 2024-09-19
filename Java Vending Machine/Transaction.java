// ANG, Janell & DIMLA, Kian <S17A>

/**
* Transaction class that contains transaction information.
*/
public class Transaction {
    private Item item;
    private int quantity, restockSession;
    private double totalPrice;

    /**
     * Transaction object constructor.
     * 
     * @param item Transaction's item
     * @param quantity Transaction's quantity
     * @param totalPrice Transaction's price amount
     * @param restockSession Transaction's restock session
     */
    public Transaction(Item item, int quantity, double totalPrice, int restockSession) {
        this.item = item;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.restockSession = restockSession;
    }

    /**
     * Returns item
     * 
     * @return item
     */
    public Item getItem() {
        return item;
    }

    /**
     * Returns quantity
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns totalPrice
     * 
     * @return totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Returns restockSession
     * 
     * @return restockSession
     */
    public int getRestockSession() {
        return restockSession;
    }
}