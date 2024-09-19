// ANG, Janell & DIMLA, Kian <S17A>

import java.util.*;

/**
 * RegularModel that class represents a regular vending machine object.
 */
public class RegularModel {
    /**
     * Model's item list.
     */
    protected ArrayList<Item> itemList;

    /**
     * Model's transaction list.
     */
    protected ArrayList<Transaction> transactionList;

    /**
     * Model's stock list.
     */
    protected ArrayList<Stock> stockList;

    /**
     * Model's denomination list.
     */
    protected ArrayList<Denomination> denominationList;

    /**
     * Model's balance and collected payment
     */
    protected double balance, 
                     collectPayment;

    /**
     * Model's restock session.
     */
    protected int restockSession;

    /**
     * Model's didRestock and isVendingFeatures flags.
     */
    protected boolean didRestock, isVF;

    /**
     * RegularModel object constructor that
     * initializes its class attributes.
     */
    public RegularModel() {
        itemList = new ArrayList<>();
        transactionList = new ArrayList<>();
        stockList = new ArrayList<>();
        denominationList = new ArrayList<>();
        balance = 0.00;
        collectPayment = 0.00;
        restockSession = 0;
        didRestock = false;
        isVF = false;
        initializeItems();
        initializeDenominations();
    }  

    /**
     * Initializes the item list.
     */
    public void initializeItems() {
        itemList.add(new Item("Chasyu Pork", 100.75, 15, 250));
        itemList.add(new Item("Noodles", 20.50, 100, 50));
        itemList.add(new Item("Tonkotsu Broth", 80.00, 100, 20));
        itemList.add(new Item("Fish Cake", 60.00, 100, 150));
        itemList.add(new Item("Fried Tofu", 40.00, 100, 200));
        itemList.add(new Item("Aji Tamago", 15.00, 100, 75));
        itemList.add(new Item("Pickled Radish", 20.00, 10, 30));
        itemList.add(new Item("Shrimp", 120.00, 100, 100));
    }

    /**
     * Initializes the denomination list.
     */
    public void initializeDenominations() {
        denominationList.add(new Denomination(1000, 100));
        denominationList.add(new Denomination(500, 100));
        denominationList.add(new Denomination(200, 100));
        denominationList.add(new Denomination(100, 100));
        denominationList.add(new Denomination(50, 100));
        denominationList.add(new Denomination(20, 100));
        denominationList.add(new Denomination(10, 100));
        denominationList.add(new Denomination(5, 100));
        denominationList.add(new Denomination(1, 100));
        denominationList.add(new Denomination(0.5, 100));
        denominationList.add(new Denomination(0.25, 100));
    }
        
    /**
     * Dispenses the item at the specified index and updates the balance and transaction list.
     *
     * @param index The index of the item to dispense.
     */
    public void dispense(int index) {
        Transaction transaction;
        Item item = itemList.get(index);
        item.dispense();
        balance -= item.getPrice();
        collectPayment += item.getPrice();
        transaction = new Transaction(item, 1, item.getPrice(), restockSession);
        transactionList.add(transaction);
    }

    /**
     * Adds the specified amount to the balance if the amount is valid.
     *
     * @param input The amount to add to the balance.
     * @return True if the amount was added successfully, false otherwise.
     */
    public boolean addBalance(String input) {
        input = input.trim();
        double amount;
        boolean result = false;

        try {
            amount = Double.parseDouble(input);
            if (amount == 1 || amount == 5 || amount == 10 || amount == 20 || amount == 50
            || amount == 100 || amount == 200 || amount == 500 || amount == 1000) {
                balance += amount;
                result = true;
            }
        } catch (Exception e) {

        }

        return result;
    }

    /**
     * Dispenses the change and updates the balance.
     *
     * @return The message with the denominations the change was dispensed in.
     */
    public String dispenseChange() {
        int count;
        String message = "Change dispensed: PHP " + String.format("%.2f", balance);
        boolean enoughChange = true;

        for (Denomination denomination : denominationList) {
            count = Math.min(((int) (balance / denomination.getAmount())), denomination.getQuantity());
            if (count > 0) {
                message += "\n" + count + " x PHP " + String.format("%.2f", denomination.getAmount());
                denomination.dispenseDenomination(count);
                balance -= count * denomination.getAmount();
                if (denomination.getAmount() == 0.25 && balance != 0) {
                    enoughChange = false;
                }
            } else if (balance > 0 && denomination.getAmount() == 0.25 && 
                        (int) (balance / denomination.getAmount()) < denomination.getQuantity()) {
                enoughChange = false;
            }
        }

        if (!enoughChange) {
            message += "\nInsufficient change in the reserve.\nDispensing available change.";
        }

        return message;
    }

    /**
     * Restocks the item at the specified index with the specified quantity.
     *
     * @param index The index of the item to restock.
     * @param input The quantity to restock the item with.
     * @return True if the item was restocked successfully, false otherwise.
     */
    public boolean restock(int index, String input) {
        input = input.trim();
        boolean result = false;
        int quantity;
        Item item = itemList.get(index);

        try {
            quantity = Integer.parseInt(input);
            if (quantity > 0) {
                item.addQuantity(quantity);
                stockList.add(new Stock(item.getName(), item.getQuantity(), restockSession));
                result = true;
            } 
        } catch (Exception e) {} 

        return result;
    }

    /**
     * Sets the price of the item at the specified index to the specified price.
     *
     * @param index The index of the item to set the price for.
     * @param input The price to set the item's price to.
     * @return True if the price was set successfully, false otherwise.
     */
    public boolean setPrice(int index, String input) {
        input = input.trim();
        boolean result = false;
        double price;
        Item item = itemList.get(index);

        try {
            price = Double.parseDouble(input);
            if (price > 0 && price % 0.25 == 0) {
                item.setPrice(price);
                result = true;
            }
        } catch (Exception e) {}
        
        return result;
    }

    /**
     * Collects the payment and resets the collectPayment variable.
     *
     * @return The amount of payment that was collected.
     */
    public double collectPayment() {
        double result = collectPayment;

        collectPayment = 0;

        return result;
    }

    /**
     * Replenishes the change for the specified denomination with the specified quantity.
     *
     * @param index The index of the denomination to replenish.
     * @param input The quantity to replenish the denomination with.
     * @return True if the change was replenished successfully, false otherwise.
     */
    public boolean replenishChange(int index, String input) {
        input = input.trim();
        boolean result = false;
        int quantity;
        Denomination denomination = denominationList.get(index);

        try {
            quantity = Integer.parseInt(input);
            if (quantity > 0) {
                denomination.addDenomination(quantity);
                result = true;
            }
        } catch (Exception e) {}

        return result;
    }

    /**
     * Increments the restock session counter if the restock flag is set.
     */
    public void incrementRestockSession() {
        if (getDidRestock()) {
            restockSession++;
        }
    }

    /**
     * Gets the stock summary data for the current restock session to be
     * used in a JTable object.
     * 
     * @return An array of objects representing the stock summary data.
     */
    public Object[][] getStockSummaryData() {
        List<Object[]> dataList = new ArrayList<>();
    
        for (Stock stock : stockList) {
            if (stock.getRestockSession() + 1 == restockSession) {
                for (Item item : itemList) {
                    if (stock.getItemName().equals(item.getName())) {
                        Object[] row = {
                            item.getName(),
                            stock.getInitialStock(),
                            item.getQuantity()
                        };
                        dataList.add(row);
                    }
                }
            }
        }
    
        return dataList.toArray(new Object[dataList.size()][]);
    }


    /**
     * Gets the transaction data for the current restock session to be
     * used in a JTable object.
     * 
     * @return An array of objects representing the transaction data.
     */
    public Object[][] getTransactionData() {
        List<Object[]> rowDataList = new ArrayList<>();
        int quantity;
        Item transactionItem;
    
        if (transactionList.size() > 0 && transactionList.get(transactionList.size() - 1).getRestockSession() == restockSession) {
            for (Transaction transaction : transactionList) {
                if (transaction.getRestockSession() == restockSession) {
                    transactionItem = transaction.getItem();
                    quantity = transaction.getQuantity();
                    Object[] row = {
                        transactionItem.getName(),
                        quantity,
                        transactionItem.getPrice()
                    };
                    rowDataList.add(row);
                }
            }
            Object[] totalRow = {"Total:", "", getTotal()};
            rowDataList.add(totalRow);
        }

        return rowDataList.toArray(new Object[rowDataList.size()][]);
    }

    /**
     * Gets the total amount of money spent during the current restock session.
     *
     * @return The total amount of money spent.
     */
    public double getTotal() {
        double total = 0.0;

        for (Transaction transaction : transactionList) {
            if (transaction.getRestockSession() == restockSession) { // If transaction was during the current restockSession
                total += transaction.getTotalPrice();
            }
        }

        return total;
    }

    /**
     * Gets the list of items.
     *
     * @return The list of items.
     */
    public ArrayList<Item> getItemList() {
        return itemList;
    }

    /**
     * Gets the list of denominations.
     *
     * @return The list of denominations.
     */
    public ArrayList<Denomination> getDenominationList() {
        return denominationList;
    }

    /**
     * Gets the balance.
     *
     * @return The balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the restock session.
     *
     * @return The restock session.
     */
    public int getRestockSession() {
        return restockSession;
    }

    /**
     * Gets the restock flag.
     *
     * @return The restock flag.
     */
    public boolean getDidRestock() {
        return didRestock;
    }

    /**
     * Gets the isVF (isVendingFeatures) flag.
     *
     * @return The isVF flag.
     */
    public boolean getIsVF() {
        return isVF;
    }

    /**
     * Sets the restock flag.
     *
     * @param didRestock The restock flag.
     */
    public void setDidRestock(boolean didRestock) {
        this.didRestock = didRestock;
    }

    /**
     * Sets the isVF (isVendingFeatures) flag.
     *
     * @param isVF The isVF flag.
     */
    public void setIsVF(boolean isVF) {
        this.isVF = isVF;
    }
}