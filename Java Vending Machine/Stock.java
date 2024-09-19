// ANG, Janell & DIMLA, Kian <S17A>

/**
 * Stock class that contains restocking information.
 */
public class Stock {
    private String itemName;
    private int initialStock, restockSession;

    /**
     * Stock object constructor.
     * 
     * @param itemName Restocked item's name
     * @param initialStock Restocked item's initial quantity
     * @param restockSession Restocked item's session
     */
    public Stock(String itemName, int initialStock, int restockSession) {
        this.itemName = itemName;
        this.initialStock = initialStock;
        this.restockSession = restockSession;
    }

    /**
     * Returns itemName
     * 
     * @return itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Returns initialStock
     * 
     * @return initialStock
     */
    public int getInitialStock() {
        return initialStock;
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