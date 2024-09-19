// ANG, Janell & DIMLA, Kian <S17A>

/**
 * Denomination class that represents
 * a denomination's amount and its count.
 */
public class Denomination {
    private double amount;
    private int quantity;

    /**
     * Denomination item constructor.
     * 
     * @param amount Denomination's amount
     * @param quantity Denomination's quantity
     */
    public Denomination(double amount, int quantity) {
        this.amount = amount;
        this.quantity = quantity;
    }

    /**
     * Denomination item constructor where quantity is
     * set to 100 by default.
     * 
     * @param amount Denomination's amount
     */
    public Denomination(double amount) {
        this.amount = amount;
        this.quantity = 100;
    }

    /**
     * Deducts denomination quantity
     * 
     * @param quantity Quantity to remove
     */
    public void dispenseDenomination(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        }
    }

    /**
     * Adds denomination count.
     * 
     * @param quantity Quantity to add
     */
    public void addDenomination(int quantity) {
        this.quantity += quantity;
    }

    /**
     * Returns denomination amount.
     * 
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns denomination quantity.
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }
}