// ANG, Janell & DIMLA, Kian <S17A>

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * VendingMachineView class that contains
 * Java GUI elements for the vending machine
 * creator.
 */
public class VendingMachineView {
    // Main Menu Screen
    private JFrame menuFrame;
    private JButton exitProgramBtn,
                    createRVMBtn,
                    createSVMBtn;

    // Main Regular Screen
    private JFrame regularFrame;
    private JButton regularBuyBtn,
                    regularFinishBtn,
                    maintenanceBtn;

    // Payment Menu
    private JFrame paymentFrame;
    private JPanel paymentPanel;
    private JTextField paymentInput;
    private JButton addBtn,
                    finishBtn;
    private JTextArea paymentText,
                      balanceText;
    
    // Item Buttons
    private JButton itemBtn[] = new JButton[8];

    // Dispense Change Screen
    private JFrame dispenseChangeFrame;
    private JTextArea dispenseChangeText;
    private JButton okBtn;

    // Maintenance Menu
    private JFrame maintenanceFrame;
    private JButton returnMainBtn,
                    testVFBtn,
                    testMFBtn;

    // Maintenance Features Menu
    private JFrame maintenanceFeaturesFrame;
    private JButton returnMaintenanceMenuBtn;
    private JButton restockBtn,
                    setPriceBtn,
                    collectPaymentBtn,
                    replenishBtn,
                    transactionBtn;

    // Restock Screen
    private JFrame restockFrame;
    private JPanel restockPanel;
    private JTextField restockInput;
    private JTextArea restockText,
                      restockSessionText;
    private JButton rItemBtn[] = new JButton[8],
                    restockFinishBtn;

    // Set Price Screen
    private JFrame priceFrame;
    private JPanel pricePanel;
    private JTextField priceInput;
    private JTextArea priceText;
    private JButton pItemBtn[] = new JButton[8],
                    priceFinishBtn;

    // Collect Payment Screen 
    private JFrame collectFrame;
    private JTextArea collectText;
    private JButton collectFinishBtn;

    // Replenish Change Screen
    private JFrame replenishFrame;
    private JPanel replenishPanel;
    private JTextField replenishInput;
    private JTextArea replenishText;
    private JButton denominationBtn[] = new JButton[11],
                    replenishFinishBtn;
    
    // Transaction Summary Screen
    private JFrame transactionFrame;
    private JButton transactionFinishBtn;
    private JTable restockTable,
                   transactionTable;
    private JScrollPane restockScrollPane,
                        transactionScrollPane;

    // Special Vending Machine
    
    // Special Screen
    private JFrame specialFrame;
    private JButton specialBuyBtn,
                    specialFinishBtn,
                    specialMaintenanceBtn;
    
    private JFrame specialPaymentFrame;
    private JTextField specialPaymentInput;
    private JTextArea specialBalanceText,
                      specialPaymentText;
    private JButton specialAddBtn,
                    specialPaymentFinishBtn;

    //Alacarte Items
    private JButton specialItemBtn[] = new JButton[4];

    // Ingredient selection Menu (Customization)
    private JButton noBtn[] = new JButton[4];

    // Customizable items
    private JButton customizeItemBtn[] = new JButton[4];

    // Customization Screens
    private JFrame porkCutletFrame;
    private JFrame beefSoupFrame;
    private JFrame iceCreamFrame;
    private JFrame breadFrame;

    private JButton returnBtn[] = new JButton[4];

    // Dispense Change Screen
    private JFrame specialDispenseChangeFrame;
    private JTextArea specialDispenseChangeText;
    private JButton specialOkBtn;

    // Special Maintenance Screen
    // Maintenance Menu
    private JFrame specialMaintenanceFrame;
    private JButton specialReturnMainBtn,
                    specialTestVFBtn,
                    specialTestMFBtn;

    // Maintenance Features Menu
    private JFrame specialMaintenanceFeaturesFrame;
    private JButton specialReturnMaintenanceMenuBtn;
    private JButton specialRestockBtn,
                    specialSetPriceBtn,
                    specialCollectPaymentBtn,
                    specialReplenishBtn,
                    specialTransactionBtn;

    // Restock Screen
    private JFrame specialRestockFrame;
    private JPanel specialRestockPanel;
    private JTextField specialRestockInput;
    private JTextArea specialRestockText,
                    specialRestockSessionText;
    private JButton specialRItemBtn[] = new JButton[6],
                    specialRestockFinishBtn;

    // Set Price Screen
    private JFrame specialPriceFrame;
    private JPanel specialPricePanel;
    private JTextField specialPriceInput;
    private JTextArea specialPriceText;
    private JButton specialPItemBtn[] = new JButton[6],
                    specialPriceFinishBtn;

    // Collect Payment Screen 
    private JFrame specialCollectFrame;
    private JTextArea specialCollectText;
    private JButton specialCollectFinishBtn;

    // Replenish Change Screen
    private JFrame specialReplenishFrame;
    private JPanel specialReplenishPanel;
    private JTextField specialReplenishInput;
    private JTextArea specialReplenishText;
    private JButton specialDenominationBtn[] = new JButton[11],
                    specialReplenishFinishBtn;
    
    // Transaction Summary Screen
    private JFrame specialTransactionFrame;
    private JButton specialTransactionFinishBtn;
    private JTable specialRestockTable,
                   specialTransactionTable;
    private JScrollPane specialRestockScrollPane,
                        specialTransactionScrollPane;

    // Item Process Frame
    private JFrame makeFrame;
    private JButton makeFinishBtn;
    private JTextArea makeText;


    /**
     * VendingMachineView object constructor that
     * initializes its buttons.
     */
    public VendingMachineView() {
        // Main Menu Buttons
        createRVMBtn = new JButton();
        createRVMBtn.setText("Create Regular Vending Machine");
        createSVMBtn = new JButton();
        createSVMBtn.setText("Create Special Vending Machine");
        maintenanceBtn = new JButton();
        maintenanceBtn.setText("Maintenance");
        exitProgramBtn = new JButton();

        // Regular Menu Buttons
        regularFinishBtn = new JButton();
        regularFinishBtn.setText("Finish");
        regularBuyBtn = new JButton();
        regularBuyBtn.setText("Purchase Item");

        // Item, Restock, and Set Price Buttons
        for (int i = 0; i < 8; i++) {
            itemBtn[i] = new JButton();
            rItemBtn[i] = new JButton();
            pItemBtn[i] = new JButton();
        }

        restockFinishBtn = new JButton();
        priceFinishBtn = new JButton();

        addBtn = new JButton();
        finishBtn = new JButton();
        okBtn = new JButton();

        // Denomination Buttons
        for (int i = 0; i < 11; i++) {
            denominationBtn[i] = new JButton();
            specialDenominationBtn[i] = new JButton();
        }
        replenishFinishBtn = new JButton();

        transactionFinishBtn = new JButton();

        returnMainBtn = new JButton();
        testVFBtn = new JButton();
        testMFBtn = new JButton();
        returnMaintenanceMenuBtn = new JButton();
        restockBtn = new JButton();
        setPriceBtn = new JButton();
        collectPaymentBtn = new JButton();
        collectFinishBtn = new JButton();
        replenishBtn = new JButton();
        transactionBtn = new JButton();

        // Special Screen Buttons
        specialBuyBtn = new JButton();
        specialBuyBtn.setText("Purchase Item");
        specialMaintenanceBtn = new JButton();
        specialMaintenanceBtn.setText("Maintenance");
        specialFinishBtn = new JButton();
        specialFinishBtn.setText("Finish");

        // Special Payment Buttons
        specialAddBtn = new JButton();
        specialAddBtn.setText("Add");
        specialPaymentFinishBtn = new JButton();
        specialPaymentFinishBtn.setText("     Finish     ");

        // Special Item Buttons
        for (int i = 0; i < 4; i++) {
            specialItemBtn[i] = new JButton();
            noBtn[i] = new JButton();
            customizeItemBtn[i] = new JButton();
            returnBtn[i] = new JButton();
            returnBtn[i].setText("Return");
        }

        specialOkBtn = new JButton();
        specialOkBtn.setText("Ok");

        // Special Maintenance Buttons
        // Special Restock and Set Price Buttons
        for (int i = 0; i < 6; i++) {
            specialRItemBtn[i] = new JButton();
            specialPItemBtn[i] = new JButton();
                    
        }

        specialReturnMainBtn = new JButton();
        specialReturnMainBtn.setText("Finish");
        specialTestVFBtn = new JButton();
        specialTestVFBtn.setText("Test Vending Features");
        specialTestMFBtn = new JButton();
        specialTestMFBtn.setText("Test Maintenance Features");
        specialReturnMaintenanceMenuBtn = new JButton();
        specialRestockBtn = new JButton();
        specialSetPriceBtn = new JButton();
        specialCollectPaymentBtn = new JButton();
        specialReplenishBtn = new JButton();
        specialTransactionBtn = new JButton();
        specialRestockFinishBtn = new JButton();
        specialPriceFinishBtn = new JButton();
        specialCollectFinishBtn = new JButton();
        specialReplenishFinishBtn = new JButton();
        specialTransactionFinishBtn = new JButton();
        makeFinishBtn = new JButton();

        mainMenuScreen();
    }

    /**
     * Displays the menu for the regular vending machine.
     */
    public void regularScreen() {
        regularFrame = new JFrame("2. Regular Vending Machine");
        regularFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regularFrame.setLayout(new FlowLayout());
        regularFrame.setSize(250, 200);

        JLabel regularLabel = new JLabel();
        regularLabel.setText("Regular Vending Machine");

        JPanel regularPanel = new JPanel();
        regularPanel.setLayout(new GridLayout(3, 1, 1, 1));

        regularFrame.add(regularLabel);
        regularPanel.add(regularBuyBtn);
        regularPanel.add(maintenanceBtn);
        regularPanel.add(regularFinishBtn);
        regularFrame.add(regularPanel);

        regularFrame.setLocationRelativeTo(null);
        regularFrame.setVisible(true);
    }

    /**
     * Disposes the regular vending machine menu.
     */
    public void disposeRegularFrame() {
        regularFrame.dispose();
    }
    
    /**
     * Displays the main menu screen with options for creating a regular or
     * special vending machine and exiting the program.
     */
    public void mainMenuScreen() {
        menuFrame = new JFrame("1. Vending Machine Creator");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(new FlowLayout());
        menuFrame.setSize(300, 200);
        menuFrame.getContentPane().setBackground(new Color(211, 117, 107));

        Color color = new Color(167, 93, 93);

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome to The Vending Machine!");
        welcomeLabel.setForeground(Color.white);

        exitProgramBtn.setText("Exit Program");

        menuFrame.add(welcomeLabel); 
        createRVMBtn.setBackground(color); 
        createRVMBtn.setForeground(Color.white); 
        menuFrame.add(createRVMBtn);
        createSVMBtn.setBackground(color); 
        createSVMBtn.setForeground(Color.white); 
        menuFrame.add(createSVMBtn);
        exitProgramBtn.setBackground(color); 
        exitProgramBtn.setForeground(Color.white); 
        menuFrame.add(exitProgramBtn);

        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);
    }

    /**
     * Disposes the main menu screen.
     */
    public void disposeMenuFrame() {
        menuFrame.dispose();
    }

    /**
     * Displays the payment screen for the regular vending machine where the user
     * can insert money and buy items.
     */
    public void paymentScreen() {
        paymentFrame = new JFrame("Regular Menu");
        paymentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paymentFrame.setLayout(new FlowLayout());
        paymentFrame.setSize(550, 300);
        paymentFrame.getContentPane().setBackground(new Color(147, 191, 207));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 1, 1));

        JLabel paymentLabel = new JLabel();
        paymentLabel.setText("Insert Money");

        paymentInput = new JTextField();
        paymentInput.setColumns(20);

        balanceText = new JTextArea();
        balanceText.setColumns(20);
        balanceText.setEditable(false);

        paymentText = new JTextArea();
        paymentText.setColumns(20);
        paymentText.setEditable(false);

        paymentPanel = new JPanel();
        paymentPanel.setLayout(new GridLayout(2, 4, 1, 1));

        addBtn.setText("Add");
        finishBtn.setText("Finish");

        paymentFrame.add(paymentLabel);
        paymentFrame.add(paymentInput);
        paymentFrame.add(addBtn);

        panel.add(balanceText);
        panel.add(paymentText);

        paymentFrame.add(panel);

        for (int i = 0; i < 8; i++) {
            paymentPanel.add(itemBtn[i]);
        }

        paymentFrame.add(paymentPanel);
        paymentFrame.add(finishBtn);
         
        paymentFrame.setLocationRelativeTo(null);
        paymentFrame.setVisible(true); 
    }

    /**
     * Disposes the regular vending machine's
     * payment and item menu screen.
     */
    public void disposePaymentFrame() {
        paymentFrame.dispose();
    }


    /**
     * Displays the regular vending machine's
     * change dispensed and its denominations.
     */
    public void dispenseChangeScreen() { //!
        dispenseChangeFrame = new JFrame("Dispense Change");
        dispenseChangeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispenseChangeFrame.setLayout(new FlowLayout());
        dispenseChangeFrame.setSize(250, 300);

        okBtn.setText("Ok");

        dispenseChangeFrame.add(dispenseChangeText);
        dispenseChangeFrame.add(okBtn);

        dispenseChangeFrame.setLocationRelativeTo(null);
        dispenseChangeFrame.setVisible(true);
    }

    /**
     * Disposes the regular vending machine's
     * change dispensing screen.
     */
    public void disposeDispenseChangeFrame() {
        dispenseChangeFrame.dispose();
    }

    /**
     * Displays the menu for the regular vending machine's
     * maintenance menu.
     */
    public void maintenanceScreen() {
        maintenanceFrame = new JFrame("3. Maintenance Menu");
        maintenanceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maintenanceFrame.setLayout(new FlowLayout());
        maintenanceFrame.setSize(250, 200);

        JLabel maintenanceLabel= new JLabel();
        maintenanceLabel.setText("Maintenance Menu");

        returnMainBtn.setText("Finish");

        testVFBtn.setText("    Test Vending Features    ");

        testMFBtn.setText("Test Maintenance Features");
        
        maintenanceFrame.add(maintenanceLabel);
        maintenanceFrame.add(testVFBtn);
        maintenanceFrame.add(testMFBtn);
        maintenanceFrame.add(returnMainBtn);

        maintenanceFrame.setLocationRelativeTo(null);
        maintenanceFrame.setVisible(true);
    }

    /**
     * Disposes the maintenance menu 
     * for the regular vending machine.
     */
    public void disposeMaintenanceFrame() {
        maintenanceFrame.dispose();
    }

    /**
     * Displays the menu for the regular vending machine's
     * maintenance features.
     */
    public void maintenanceFeaturesScreen() {
        maintenanceFeaturesFrame = new JFrame("4. Maintenance Features");
        maintenanceFeaturesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maintenanceFeaturesFrame.setLayout(new FlowLayout());
        maintenanceFeaturesFrame.setSize(250, 250);

        JLabel MFLabel = new JLabel();
        MFLabel.setText("Maintenance Features");

        returnMaintenanceMenuBtn.setText("Finish");
        
        restockBtn.setText("Restock Items");

        setPriceBtn.setText("Set Price");

        collectPaymentBtn.setText("              Collect Payment              ");
  
        replenishBtn.setText("            Replenish Change            ");

        transactionBtn.setText("Print Summary of Transactions");
            
        maintenanceFeaturesFrame.add(MFLabel);
        maintenanceFeaturesFrame.add(restockBtn);
        maintenanceFeaturesFrame.add(setPriceBtn);
        maintenanceFeaturesFrame.add(collectPaymentBtn);
        maintenanceFeaturesFrame.add(replenishBtn);
        maintenanceFeaturesFrame.add(transactionBtn);
        maintenanceFeaturesFrame.add(returnMaintenanceMenuBtn);

        maintenanceFeaturesFrame.setLocationRelativeTo(null);
        maintenanceFeaturesFrame.setVisible(true);
    }

    /**
     * Displays the menu for the regular vending machine's
     * item restocking.
     */
    public void restockScreen() {
        restockFrame = new JFrame("5. Restock Menu");
        restockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        restockFrame.setLayout(new FlowLayout());
        restockFrame.setSize(550, 250);

        restockPanel = new JPanel();
        restockPanel.setLayout(new GridLayout(2, 4, 1, 1));

        restockText = new JTextArea();
        restockText.setEditable(false);
        restockText.setText("Enter item quantity then select item to restock.");
        restockText.setColumns(25);

        restockSessionText = new JTextArea();
        restockSessionText.setEditable(false);
        restockSessionText.setColumns(10);

        JLabel restockLabel = new JLabel("                                        Item Restock Menu                                        ");

        restockInput = new JTextField();
        restockInput.setColumns(40);

        restockFinishBtn.setText("Finish");

        restockFrame.add(restockLabel);

        restockFrame.add(restockText);
        restockFrame.add(restockSessionText);

        restockFrame.add(restockInput);
        for (int i = 0; i < 8; i++) {
            restockPanel.add(rItemBtn[i]);
        }
        restockFrame.add(restockPanel);
        restockFrame.add(restockFinishBtn);

        restockFrame.setLocationRelativeTo(null);
        restockFrame.setVisible(true);
    }

    /**
     * Disposes the regular vending machine's
     * restock screen.
     */
    public void disposeRestockFrame() {
        restockFrame.dispose();
    }

    /**
     * Disposes the menu for the regular vending machine's
     * maintenance features.
     */
    public void disposeMaintenanceFeaturesFrame() {
        maintenanceFeaturesFrame.dispose();
    }

    /**
     * Empties the regular vending machine's
     * restock input.
     */
    public void resetRestockField() {
        restockInput.setText("");
    }

    /**
     * Displays the menu for the regular vending machine's
     * price setting.
     */
    public void setPriceScreen() {
        priceFrame = new JFrame("5. Set Price Menu");
        priceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        priceFrame.setLayout(new FlowLayout());
        priceFrame.setSize(550, 250);

        pricePanel = new JPanel();
        pricePanel.setLayout(new GridLayout(2, 4, 1, 1));

        priceText = new JTextArea();
        priceText.setEditable(false);
        priceText.setText("Enter new item price then select item to set price.");
        priceText.setColumns(40);

        JLabel priceLabel = new JLabel("Set Item Price Menu");

        priceInput = new JTextField();
        priceInput.setColumns(40);

        priceFinishBtn.setText("Finish");

        priceFrame.add(priceLabel);
        priceFrame.add(priceText);
        priceFrame.add(priceInput);

        for (int i = 0; i < 8; i++) {
            pricePanel.add(pItemBtn[i]);
        }

        priceFrame.add(pricePanel);
        priceFrame.add(priceFinishBtn);

        priceFrame.setLocationRelativeTo(null);
        priceFrame.setVisible(true);
    }

    /**
     * Empties the regular vending machine's 
     * price setting input.
     */
    public void resetPriceField() {
        priceInput.setText("");
    }

    /**
     * Disposes the regular vending machine's 
     * price setting screen.
     */
    public void disposePriceFrame() {
        priceFrame.dispose();
    }

    /**
     * Empties the regular vending machine's
     * payment fields.
     */
    public void resetPaymentField() {
        paymentInput.setText("");
    }

    /**
     * Empties the regular vending machine's
     * payment screen message.
     */
    public void clearPaymentText() {
        paymentText.setText("");
    }

    /**
     * Displays the regular vending machine's
     * denomination replenishing screen.
     */
    public void replenishScreen() {
        replenishFrame = new JFrame("5. Replenish Change");
        replenishFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        replenishFrame.setLayout(new FlowLayout());
        replenishFrame.setSize(500, 250);

        replenishPanel = new JPanel();
        replenishPanel.setLayout(new GridLayout(2, 6, 1, 1));

        JLabel replenishLabel = new JLabel("Denominations");

        replenishText = new JTextArea();
        replenishText.setEditable(false);
        replenishText.setText("Enter quantity then select denomination to replenish.");
        replenishText.setColumns(40);

        replenishInput = new JTextField();
        replenishInput.setColumns(40);

        replenishFinishBtn.setText("Finish");

        replenishFrame.add(replenishLabel);
        replenishFrame.add(replenishText);
        replenishFrame.add(replenishInput);

        for (int i = 0; i < 11; i++) {
            replenishPanel.add(denominationBtn[i]);
        }

        replenishPanel.add(replenishFinishBtn);

        replenishFrame.add(replenishPanel);
        
        replenishFrame.setLocationRelativeTo(null);
        replenishFrame.setVisible(true);
    }

    /**
     * Resets the text in the regular vending machine's
     * replenish field.
     */
    public void resetReplenishField() {
        replenishInput.setText("");
    }

    /**
     * Disposes the regular vending machine's
     * denomination replenishing screen.
     */
    public void disposeReplenishFrame() {
        replenishFrame.dispose();
    }
    
    /**
     * Displays the regular vending machine's
     * payment collecting screen.
     */
    public void collectScreen() { 
        collectFrame = new JFrame("5. Collect Payment");
        collectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        collectFrame.setLayout(new FlowLayout());
        collectFrame.setSize(250, 150);
        
        JLabel collectLabel = new JLabel();
        collectLabel.setText("Collect Payment Menu");

        collectFinishBtn.setText("Finish");

        collectFrame.add(collectLabel);
        collectFrame.add(collectText);
        collectFrame.add(collectFinishBtn);

        collectFrame.setLocationRelativeTo(null);
        collectFrame.setVisible(true);
    }

    /**
     * Disposes the regular vending machine's
     * payment collecting screen.
     */
    public void disposeCollectFrame() {
        collectFrame.dispose();
    }
    
    /**
     * Displays the regular vending machine's
     * transaction summary screen.
     */
    public void transactionScreen() {
        transactionFrame = new JFrame("5. Transaction Summary");
        transactionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        transactionFrame.setLayout(new FlowLayout());
        transactionFrame.setSize(425, 500);

        transactionFinishBtn.setText("Finish");

        JLabel transactionLabel = new JLabel();
        transactionLabel.setText("Restocks since last restock session: ");

        JLabel transactionLabel2 = new JLabel();
        transactionLabel2.setText("Transactions since last restock session: ");

        transactionFrame.add(transactionLabel);
        transactionFrame.add(restockScrollPane);
        transactionFrame.add(transactionLabel2);
        transactionFrame.add(transactionScrollPane);
        transactionFrame.add(transactionFinishBtn);

        transactionFrame.setLocationRelativeTo(null);
        transactionFrame.setVisible(true);
    }

    /**
     * Disposes the regular vending machine's
     * transaction summary screen.
     */
    public void disposeTransactionFrame() {
        transactionFrame.dispose();
    }

    /**
     * Displays the menu for the special vending machine.
     */
    public void specialScreen() {
        specialFrame = new JFrame("2. Special Vending Machine");
        specialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        specialFrame.setLayout(new FlowLayout());
        specialFrame.setSize(250, 200);

        JLabel specialLabel = new JLabel();
        specialLabel.setText("Special Vending Machine");

        JPanel specialPanel = new JPanel();
        specialPanel.setLayout(new GridLayout(3, 1, 1, 1));

        specialFrame.add(specialLabel);
        specialPanel.add(specialBuyBtn);
        specialPanel.add(specialMaintenanceBtn);
        specialPanel.add(specialFinishBtn);
        specialFrame.add(specialPanel);

        specialFrame.setLocationRelativeTo(null);
        specialFrame.setVisible(true);
    }

    /**
     * Disposes the menu for the special vending machine.
     */
    public void disposeSpecialFrame() {
        specialFrame.dispose();
    }

    /**
     * Displays the payment screen for the special vending machine where the user
     * can insert money and buy items.
     */
    public void specialPaymentScreen() {
        specialPaymentFrame = new JFrame("Special Menu");
        specialPaymentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        specialPaymentFrame.setLayout(new FlowLayout());
        specialPaymentFrame.setSize(550, 250);
        specialPaymentFrame.getContentPane().setBackground(new Color(255, 214, 165));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 1, 1));

        JLabel specialPaymentLabel = new JLabel();
        specialPaymentLabel.setText("Insert Money");

        specialPaymentInput = new JTextField();
        specialPaymentInput.setColumns(20);

        specialBalanceText = new JTextArea();
        specialBalanceText.setColumns(20);
        specialBalanceText.setEditable(false);

        specialPaymentText = new JTextArea();
        specialPaymentText.setColumns(20);
        specialPaymentText.setEditable(false);

        JPanel specialPaymentPanel = new JPanel();
        specialPaymentPanel.setLayout(new GridLayout(1, 4, 1, 1));

        specialPaymentFrame.add(specialPaymentLabel);
        specialPaymentFrame.add(specialPaymentInput);
        specialPaymentFrame.add(specialAddBtn);

        panel.add(specialBalanceText);
        panel.add(specialPaymentText);
        specialPaymentFrame.add(panel);

        for (int i = 0; i < 4; i++) {
            specialPaymentPanel.add(specialItemBtn[i]);
        }
        
        specialPaymentFrame.add(specialPaymentPanel);
        specialPaymentFrame.add(specialPaymentFinishBtn);
         
        specialPaymentFrame.setLocationRelativeTo(null);
        specialPaymentFrame.setVisible(true);
    }

    /**
     * Hides the special vending machine's
     * payment and item menu screen.
     */
    public void hideSpecialPaymentFrame() {
        specialPaymentFrame.setVisible(false);
    }

    /**
     * Shows the special vending machine's
     * payment and item menu screen.
     */
    public void showSpecialPaymentFrame() {
        specialPaymentFrame.setVisible(true);
    }

    /**
     * Disposes the special vending machine's
     * payment and item menu screen.
     */
    public void disposeSpecialPaymentFrame() {
        specialPaymentFrame.dispose();
    }

    /**
     * Empties the special vending machine's
     * payment screen message.
     */
    public void clearSpecialPaymentText() {
        specialPaymentText.setText("");
    }

    /**
     * Empties the special vending machine's
     * payment fields.
     */
    public void resetSpecialPaymentField() {
        specialPaymentInput.setText("");
    }

    /**
     * Displays the special vending machine's
     * change dispensed and its denominations.
     */
    public void specialDispenseChangeScreen() {
        specialDispenseChangeFrame = new JFrame("Dispense Change");
        specialDispenseChangeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        specialDispenseChangeFrame.setLayout(new FlowLayout());
        specialDispenseChangeFrame.setSize(250, 300);

        specialDispenseChangeFrame.add(specialDispenseChangeText);
        specialDispenseChangeFrame.add(specialOkBtn);

        specialDispenseChangeFrame.setLocationRelativeTo(null);
        specialDispenseChangeFrame.setVisible(true);
    }

    /**
     * Sets the text for the regular vending machine's
     * display for the change dispensing.
     */
    public void disposeSpecialDispenseChangeFrame() {
        specialDispenseChangeFrame.dispose();
    }

    /**
     * Displays the special vending machine's
     * item customization options when ice cream
     * is selected.
     * @param itemList Item list
     */
    public void iceCreamScreen(ArrayList<Item> itemList) {
        iceCreamFrame = new JFrame("Ice Cream");
        iceCreamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iceCreamFrame.setLayout(new FlowLayout());
        iceCreamFrame.setSize(300, 300);
        iceCreamFrame.getContentPane().setBackground(new Color(174, 189, 202));

        Color color = new Color(120, 149, 178);
  
        JLabel iceCreamLabel = new JLabel();
        iceCreamLabel.setText("<html>Ice Cream & Bread available:<br>Upgrade to Ice Cream Sandwich?<html>");
        iceCreamLabel.setForeground(Color.white);

        JPanel iceCreamPanel = new JPanel();
        iceCreamPanel.setLayout(new GridLayout(3, 1, 1, 1));
  
        customizeItemBtn[3].setText("<html>" + itemList.get(9).getName() + 
        "<br>PHP " + itemList.get(9).getPrice() +  
        "<br>Calories: " + itemList.get(9).getCalories() + "<html>");
        noBtn[0].setText("<html>Ice Cream<br>PHP " + itemList.get(0).getPrice() + "<br>(Don't Upgrade)<html>");
  
        iceCreamFrame.add(iceCreamLabel);

        customizeItemBtn[3].setBackground(color);
        customizeItemBtn[3].setForeground(Color.white);
        iceCreamPanel.add(customizeItemBtn[3]);
        noBtn[0].setBackground(color);
        noBtn[0].setForeground(Color.white);
        iceCreamPanel.add(noBtn[0]);
        returnBtn[0].setBackground(color);
        returnBtn[0].setForeground(Color.white);
        iceCreamPanel.add(returnBtn[0]);

        iceCreamFrame.add(iceCreamPanel);

        iceCreamFrame.setLocationRelativeTo(null);
        iceCreamFrame.setVisible(true);
    }

    /**
     * Disposes the special vending machine's
     * ice cream customization screen.
     */
    public void disposeIceCreamFrame() {
        iceCreamFrame.dispose();
    }
  
    /**
     * Displays the special vending machine's
     * item customization options when bread
     * is selected.
     * @param itemList Item list
     */
    public void breadScreen(ArrayList<Item> itemList) {
        breadFrame = new JFrame("Bread");
        breadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        breadFrame.setLayout(new FlowLayout());
        breadFrame.setSize(300, 350);
        breadFrame.getContentPane().setBackground(new Color(109, 139, 116));

        Color color = new Color(95, 113, 97);
    
        JLabel breadLabel = new JLabel();
        breadLabel.setText("<html>Ice Cream & Bread available:<br>Upgrade to Ice Cream Sandwich<br>or Egg Sandwich?<html>");
        breadLabel.setForeground(Color.white);
    
        JPanel breadPanel = new JPanel();
        breadPanel.setLayout(new GridLayout(4, 1, 1, 1));
    
        customizeItemBtn[3].setText("<html>" + itemList.get(9).getName() + 
        "<br>PHP " + itemList.get(9).getPrice() +  
        "<br>Calories: " + itemList.get(9).getCalories() + "<html>");
        customizeItemBtn[2].setText("<html>" + itemList.get(8).getName() + 
        "<br>PHP " + itemList.get(8).getPrice() +  
        "<br>Calories: " + itemList.get(8).getCalories() + "<html>");
        noBtn[1].setText("<html>Bread<br>(Don't Upgrade)<html>");
    
        breadFrame.add(breadLabel);
    
        customizeItemBtn[3].setBackground(color);
        customizeItemBtn[3].setForeground(Color.white);
        breadPanel.add(customizeItemBtn[3]);
        customizeItemBtn[2].setBackground(color);
        customizeItemBtn[2].setForeground(Color.white);
        breadPanel.add(customizeItemBtn[2]);
        noBtn[1].setBackground(color);
        noBtn[1].setForeground(Color.white);
        breadPanel.add(noBtn[1]);
        returnBtn[1].setBackground(color);
        returnBtn[1].setForeground(Color.white);
        breadPanel.add(returnBtn[1]);
    
        breadFrame.add(breadPanel);
    
        breadFrame.setLocationRelativeTo(null);
        breadFrame.setVisible(true);
    }

    /**
     * Disposes the special vending machine's
     * bread customization screen.
     */
    public void disposeBreadFrame() {
        breadFrame.dispose();
    }

    /**
     * Disposes the special vending machine's
     * ice cream or bread customization screen
     * based on which one is present already.
     */
    public void disposeSandwichFrame() {
        if (iceCreamFrame == null) {
            breadFrame.dispose();
        } else if (breadFrame == null) {
            iceCreamFrame.dispose();
        } else {
            iceCreamFrame.dispose();
            breadFrame.dispose();
        }
    }

    /**
     * Displays the special vending machine's
     * item customization options when pork cutlet
     * is selected.
     * @param itemList Item list
     */
    public void porkCutletScreen(ArrayList<Item> itemList) {
        porkCutletFrame = new JFrame("Pork Cutlet");
        porkCutletFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        porkCutletFrame.setLayout(new FlowLayout());
        porkCutletFrame.setSize(300, 300);
        porkCutletFrame.getContentPane().setBackground(new Color(136, 111, 111));
    
        Color color = new Color(105, 78, 78);

        JLabel porkCutletLabel = new JLabel();
        porkCutletLabel.setText("<html>Pork Cutlet & (2) Eggs available:<br>Upgrade to Katsudon?<html>");
        porkCutletLabel.setForeground(Color.white);
    
        JPanel porkCutletPanel = new JPanel();
        porkCutletPanel.setLayout(new GridLayout(3, 1, 1, 1));
    
        customizeItemBtn[0].setText("<html>" + itemList.get(6).getName() + 
        "<br>PHP " + itemList.get(6).getPrice() +  
        "<br>Calories: " + itemList.get(6).getCalories() + "<html>");
        noBtn[2].setText("<html>Pork Cutlet<br>(Don't Upgrade)<html>");
    
        porkCutletFrame.add(porkCutletLabel);
    
        customizeItemBtn[0].setBackground(color);
        customizeItemBtn[0].setForeground(Color.white);
        porkCutletPanel.add(customizeItemBtn[0]);
        noBtn[2].setBackground(color);
        noBtn[2].setForeground(Color.white);
        porkCutletPanel.add(noBtn[2]);
        returnBtn[2].setBackground(color);
        returnBtn[2].setForeground(Color.white);
        porkCutletPanel.add(returnBtn[2]);
    
        porkCutletFrame.add(porkCutletPanel);
    
        porkCutletFrame.setLocationRelativeTo(null);
        porkCutletFrame.setVisible(true);
    }

    /**
     * Disposes the special vending machine's
     * pork cutlet customization screen.
     */
    public void disposePorkCutletFrame() {
        porkCutletFrame.dispose();
    }
  
    /**
     * Displays the special vending machine's
     * item customization options when beef soup
     * is selected.
     * @param itemList Item list
     */
    public void beefSoupScreen(ArrayList<Item> itemList) {
        beefSoupFrame = new JFrame("Beef Soup");
        beefSoupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        beefSoupFrame.setLayout(new FlowLayout());
        beefSoupFrame.setSize(300, 300);
        beefSoupFrame.getContentPane().setBackground(new Color(255, 159, 159));
    
        Color color = new Color(233, 119, 119);

        JLabel beefSoupLabel = new JLabel();
        beefSoupLabel.setText("<html>Beef Soup & Noodles available:<br>Upgrade to Ramen?<html>");
        beefSoupLabel.setForeground(Color.white);
    
        JPanel beefSoupPanel = new JPanel();
        beefSoupPanel.setLayout(new GridLayout(3, 1, 1, 1));
    
        customizeItemBtn[1].setText("<html>" + itemList.get(7).getName() + 
        "<br>PHP " + itemList.get(7).getPrice() +  
        "<br>Calories: " + itemList.get(7).getCalories() + "<html>");
        noBtn[3].setText("<html>Beef Soup<br>(Don't Upgrade)<html>");
    
        beefSoupFrame.add(beefSoupLabel);
    
        customizeItemBtn[1].setBackground(color);
        customizeItemBtn[1].setForeground(Color.white);
        beefSoupPanel.add(customizeItemBtn[1]);
        noBtn[3].setBackground(color);
        noBtn[3].setForeground(Color.white);
        beefSoupPanel.add(noBtn[3]);
        returnBtn[3].setBackground(color);
        returnBtn[3].setForeground(Color.white);
        beefSoupPanel.add(returnBtn[3]);
    
        beefSoupFrame.add(beefSoupPanel);
    
        beefSoupFrame.setLocationRelativeTo(null);
        beefSoupFrame.setVisible(true);
    }

    /**
     * Disposes the special vending machine's
     * beef soup customization screen.
     */
    public void disposeBeefSoupFrame() {
        beefSoupFrame.dispose();
    }

    /**
     * Displays the menu for the special vending machine's
     * maintenance menu.
     */
    public void specialMaintenanceScreen() {
        specialMaintenanceFrame = new JFrame("3. Special Maintenance Menu");
        specialMaintenanceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        specialMaintenanceFrame.setLayout(new FlowLayout());
        specialMaintenanceFrame.setSize(250, 200);

        JLabel specialMaintenanceLabel = new JLabel();
        specialMaintenanceLabel.setText("Special Maintenance Menu");

        specialReturnMainBtn.setText("Finish");

        specialTestVFBtn.setText("    Test Vending Features    ");

        specialTestMFBtn.setText("Test Maintenance Features");
        
        specialMaintenanceFrame.add(specialMaintenanceLabel);
        specialMaintenanceFrame.add(specialTestVFBtn);
        specialMaintenanceFrame.add(specialTestMFBtn);
        specialMaintenanceFrame.add(specialReturnMainBtn);

        specialMaintenanceFrame.setLocationRelativeTo(null);
        specialMaintenanceFrame.setVisible(true);
    }

    /**
     * Disposes the maintenance menu 
     * for the special vending machine.
     */
    public void disposeSpecialMaintenanceFrame() {
        specialMaintenanceFrame.dispose();
    }

    /**
     * Displays the menu for the special vending machine's
     * maintenance features.
     */
    public void specialMaintenanceFeaturesScreen() {
        specialMaintenanceFeaturesFrame = new JFrame("4. Special Maintenance Features");
        specialMaintenanceFeaturesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        specialMaintenanceFeaturesFrame.setLayout(new FlowLayout());
        specialMaintenanceFeaturesFrame.setSize(250, 250);
    
        JLabel specialMFLabel = new JLabel();
        specialMFLabel.setText("Maintenance Features");
    
        specialReturnMaintenanceMenuBtn.setText("Finish");
        
        specialRestockBtn.setText("Restock Items");
    
        specialSetPriceBtn.setText("Set Price");
    
        specialCollectPaymentBtn.setText("              Collect Payment              ");
    
        specialReplenishBtn.setText("            Replenish Change            ");
    
        specialTransactionBtn.setText("Print Summary of Transactions");
            
        specialMaintenanceFeaturesFrame.add(specialMFLabel);
        specialMaintenanceFeaturesFrame.add(specialRestockBtn);
        specialMaintenanceFeaturesFrame.add(specialSetPriceBtn);
        specialMaintenanceFeaturesFrame.add(specialCollectPaymentBtn);
        specialMaintenanceFeaturesFrame.add(specialReplenishBtn);
        specialMaintenanceFeaturesFrame.add(specialTransactionBtn);
        specialMaintenanceFeaturesFrame.add(specialReturnMaintenanceMenuBtn);
    
        specialMaintenanceFeaturesFrame.setLocationRelativeTo(null);
        specialMaintenanceFeaturesFrame.setVisible(true);
    }

    /**
     * Disposes the menu for the special vending machine's
     * maintenance features.
     */
    public void disposeSpecialMaintenanceFeaturesFrame() {
        specialMaintenanceFeaturesFrame.dispose();
    }

    /**
     * Displays the menu for the special vending machine's
     * item restocking.
     */
    public void specialRestockScreen() {
        specialRestockFrame = new JFrame("5. Restock Menu");
        specialRestockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        specialRestockFrame.setLayout(new FlowLayout());
        specialRestockFrame.setSize(450, 225);
    
        specialRestockPanel = new JPanel();
        specialRestockPanel.setLayout(new GridLayout(2, 4, 1, 1));
    
        specialRestockText = new JTextArea();
        specialRestockText.setEditable(false);
        specialRestockText.setText("Enter item quantity then select item to restock.");
        specialRestockText.setColumns(25);
    
        specialRestockSessionText = new JTextArea();
        specialRestockSessionText.setEditable(false);
        specialRestockSessionText.setColumns(10);
    
        JLabel specialRestockLabel = new JLabel("                    Item Restock Menu                    ");
    
        specialRestockInput = new JTextField();
        specialRestockInput.setColumns(35);
    
        specialRestockFinishBtn.setText("Finish");
    
        specialRestockFrame.add(specialRestockLabel);
        specialRestockFrame.add(specialRestockText);
        specialRestockFrame.add(specialRestockSessionText);
        specialRestockFrame.add(specialRestockInput);
        for (int i = 0; i < 6; i++) {
            specialRestockPanel.add(specialRItemBtn[i]);
        }
        specialRestockFrame.add(specialRestockPanel);
        specialRestockFrame.add(specialRestockFinishBtn);
    
        specialRestockFrame.setLocationRelativeTo(null);
        specialRestockFrame.setVisible(true);
    }

    /**
     * Disposes the special vending machine's
     * restock screen.
     */
    public void disposeSpecialRestockFrame() {
        specialRestockFrame.dispose();
    }

    /**
     * Empties the special vending machine's
     * restock input.
     */
    public void resetSpecialRestockField() {
        specialRestockInput.setText("");
    }

    /**
     * Displays the menu for the special vending machine's
     * price setting.
     */
    public void specialSetPriceScreen() {
        specialPriceFrame = new JFrame("5. Set Price Menu");
        specialPriceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        specialPriceFrame.setLayout(new FlowLayout());
        specialPriceFrame.setSize(350, 250);
    
        specialPricePanel = new JPanel();
        specialPricePanel.setLayout(new GridLayout(2, 4, 1, 1));
    
        specialPriceText = new JTextArea();
        specialPriceText.setEditable(false);
        specialPriceText.setText("Enter new item price then select item to set price.");
        specialPriceText.setColumns(25);
    
        JLabel specialPriceLabel = new JLabel("Set Item Price Menu");
    
        specialPriceInput = new JTextField();
        specialPriceInput.setColumns(25);
    
        specialPriceFinishBtn.setText("Finish");
    
        specialPriceFrame.add(specialPriceLabel);
        specialPriceFrame.add(specialPriceText);
        specialPriceFrame.add(specialPriceInput);
    
        for (int i = 0; i < 6; i++) {
            specialPricePanel.add(specialPItemBtn[i]);
        }
    
        specialPriceFrame.add(specialPricePanel);
        specialPriceFrame.add(specialPriceFinishBtn);
    
        specialPriceFrame.setLocationRelativeTo(null);
        specialPriceFrame.setVisible(true);
    }
    
    /**
     * Empties the special vending machine's 
     * price setting input.
     */
    public void resetSpecialPriceField() {
        specialPriceInput.setText("");
    }
    
    /**
     * Disposes the special vending machine's 
     * price setting screen.
     */
    public void disposeSpecialPriceFrame() {
        specialPriceFrame.dispose();
    }

    /**
     * Displays the special vending machine's
     * denomination replenishing screen.
     */
    public void specialReplenishScreen() {
        specialReplenishFrame = new JFrame("5. Replenish Change");
        specialReplenishFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        specialReplenishFrame.setLayout(new FlowLayout());
        specialReplenishFrame.setSize(500, 250);
    
        specialReplenishPanel = new JPanel();
        specialReplenishPanel.setLayout(new GridLayout(2, 6, 1, 1));
    
        JLabel specialReplenishLabel = new JLabel("Denominations");
    
        specialReplenishText = new JTextArea();
        specialReplenishText.setEditable(false);
        specialReplenishText.setText("Enter quantity then select denomination to replenish.");
        specialReplenishText.setColumns(40);
    
        specialReplenishInput = new JTextField();
        specialReplenishInput.setColumns(40);
    
        specialReplenishFinishBtn.setText("Finish");
    
        specialReplenishFrame.add(specialReplenishLabel);
        specialReplenishFrame.add(specialReplenishText);
        specialReplenishFrame.add(specialReplenishInput);
    
        for (int i = 0; i < 11; i++) {
            specialReplenishPanel.add(specialDenominationBtn[i]);
        }
    
        specialReplenishPanel.add(specialReplenishFinishBtn);
    
        specialReplenishFrame.add(specialReplenishPanel);
        
        specialReplenishFrame.setLocationRelativeTo(null);
        specialReplenishFrame.setVisible(true);
    }
    
    /**
     * Resets the text in the special vending machine's
     * replenish field.
     */
    public void resetSpecialReplenishField() {
        specialReplenishInput.setText("");
    }
    
    /**
     * Disposes the special vending machine's
     * denomination replenishing screen.
     */
    public void disposeSpecialReplenishFrame() {
        specialReplenishFrame.dispose();
    }

    /**
     * Displays the special vending machine's
     * payment collecting screen.
     */
    public void specialCollectScreen() {
        specialCollectFrame = new JFrame("5. Collect Payment");
        specialCollectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        specialCollectFrame.setLayout(new FlowLayout());
        specialCollectFrame.setSize(250, 150);
        
        JLabel specialCollectLabel = new JLabel();
        specialCollectLabel.setText("Collect Payment Menu");
    
        specialCollectFinishBtn.setText("Finish");
    
        specialCollectFrame.add(specialCollectLabel);
        specialCollectFrame.add(specialCollectText);
        specialCollectFrame.add(specialCollectFinishBtn);
    
        specialCollectFrame.setLocationRelativeTo(null);
        specialCollectFrame.setVisible(true);
    }

    /**
     * Disposes the special vending machine's
     * payment collecting screen.
     */
    public void disposeSpecialCollectFrame() {
        specialCollectFrame.dispose();
    }

    /**
     * Displays the special vending machine's
     * transaction summary screen.
     */
    public void specialTransactionScreen() {
        specialTransactionFrame = new JFrame("5. Transaction Summary");
        specialTransactionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        specialTransactionFrame.setLayout(new FlowLayout());
        specialTransactionFrame.setSize(425, 500);
    
        specialTransactionFinishBtn.setText("Finish");
    
        JLabel specialTransactionLabel = new JLabel();
        specialTransactionLabel.setText("Restocks since last restock session: ");
    
        JLabel specialTransactionLabel2 = new JLabel();
        specialTransactionLabel2.setText("Transactions since last restock session: ");
    
        specialTransactionFrame.add(specialTransactionLabel);
        specialTransactionFrame.add(specialRestockScrollPane);
        specialTransactionFrame.add(specialTransactionLabel2);
        specialTransactionFrame.add(specialTransactionScrollPane);
        specialTransactionFrame.add(specialTransactionFinishBtn);
    
        specialTransactionFrame.setLocationRelativeTo(null);
        specialTransactionFrame.setVisible(true);
    }
    
    /**
     * Disposes the special vending machine's
     * transaction summary screen.
     */
    public void disposeSpecialTransactionFrame() {
        specialTransactionFrame.dispose();
    }

    /**
     * Displays the special vending machine's
     * item process screen.
     */
    public void makeScreen() {
        makeFrame = new JFrame("Item Process Frame");
        makeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        makeFrame.setLayout(new FlowLayout());
        makeFrame.setSize(250, 250);
        makeFrame.getContentPane().setBackground(new Color(109, 103, 228));
        
        JLabel makeLabel = new JLabel();
        makeLabel.setText("Item Process Menu");
        makeLabel.setForeground(Color.white);
    
        makeFinishBtn.setText("Finish");
    
        makeFrame.add(makeLabel);
        makeFrame.add(makeText);
        makeFinishBtn.setBackground(new Color(69, 60, 103));
        makeFinishBtn.setForeground(Color.white);
        makeFrame.add(makeFinishBtn);
    
        makeFrame.setLocationRelativeTo(null);
        makeFrame.setVisible(true);
    }
    
    /**
     * Disposes the special vending machine's
     * item process screen.
     */
    public void disposeMakeFrame() {
        makeFrame.dispose();
    }

    /**
     * Gets the input in the regular vending machine's
     * restock text field.
     * 
     * @return restockInput.getText()
     */
    public String getRestockInput() {
        return restockInput.getText();
    }

    /**
     * Gets the input in the regular vending machine's
     * price setting text field.
     * 
     * @return priceInput.getText()
     */
    public String getPriceInput() {
        return priceInput.getText();
    }

    /**
     * Gets the input in the regular vending machine's
     * payment field.
     * 
     * @return paymentInput.getText()
     */
    public String getPaymentInput() {
        return paymentInput.getText();
    }

    /**
     * Gets the text in the regular vending machine's
     * replenish field.
     * 
     * @return replenishInput.getText()
     */
    public String getReplenishInput() {
        return replenishInput.getText();
    }

    /**
     * Gets the input in the special vending machine's
     * payment field.
     * 
     * @return specialPaymentInput.getText()
     */
    public String getSpecialPaymentInput() {
        return specialPaymentInput.getText();
    }

    /**
     * Gets the input in the special vending machine's
     * restock text field.
     * 
     * @return specialRestockInput.getText()
     */
    public String getSpecialRestockInput() {
        return specialRestockInput.getText();
    }

    /**
     * Gets the input in the special vending machine's
     * price setting text field.
     * 
     * @return specialPriceInput.getText()
     */
    public String getSpecialPriceInput() {
        return specialPriceInput.getText();
    }

    /**
     * Gets the text in the special vending machine's
     * replenish field.
     * 
     * @return specialReplenishInput.getText()
     */
    public String getSpecialReplenishInput() {
        return specialReplenishInput.getText();
    }

    /**
     * Sets the text for the regular vending machine's
     * display for the change dispensing.
     * 
     * @param text String text
     */
    public void setDispenseChangeText(String text) {
        dispenseChangeText = new JTextArea();
        dispenseChangeText.setColumns(20);
        dispenseChangeText.setEditable(false);
        dispenseChangeText.setText(text);
    }

    /**
     * Sets the regular vending machine's
     * restock display message.
     * 
     * @param text String text
     */
    public void setRestockText(String text) {
        restockText.setText(text);
    }

    /**
     * Sets the display message for 
     * the regular vending machine's
     * current restock session.
     * 
     * @param text String text
     */
    public void setRestockSessionText(String text) {
        restockSessionText.setText(text);
    }

    /**
     * Sets the text in the regular vending machine's
     * restock buttons to the corresponding item quantities.
     * 
     * @param itemList Item list
     */
    public void setItemQuantity(ArrayList<Item> itemList) {
        for (int i = 0; i < 8; i++) {
            rItemBtn[i].setText("<html>" + itemList.get(i).getName() + "<br>(" + itemList.get(i).getQuantity() + ")<html>");
        }
    }

    /**
     * Sets the text for the regular vending machine's
     * price setting display message.
     * 
     * @param text String text
     */
    public void setPriceText(String text) {
        priceText.setText(text);
    }

    /**
     * Sets the text in the regular vending machine's
     * price setting buttons to the corresponding item prices.
     * 
     * @param itemList Item list
     */
    public void setItemPrices(ArrayList<Item> itemList) {
        for (int i = 0; i < 8; i++) {
            pItemBtn[i].setText("<html>" + itemList.get(i).getName() + "<br>PHP " + itemList.get(i).getPrice() + "<html>");
        }
    }

    /**
     * Sets the text in the regular vending machine's
     * item buttons to the corresponding item prices,
     * availabilities, and calories.
     * 
     * @param itemList Item list
     */
    public void setItems(ArrayList<Item> itemList) {
        for (int i = 0; i < 8; i++) {
            itemBtn[i].setText("<html>" + itemList.get(i).getName() + "<br>PHP " + itemList.get(i).getPrice() + 
            "<br>" + itemList.get(i).availableToString() + "<br>Calories: " + itemList.get(i).getCalories() + "<html>");
            itemBtn[i].setBackground(new Color(96, 150, 180));
            itemBtn[i].setForeground(Color.white);
        }
    }

    /**
     * Sets the regular vending machine's
     * balance text.
     * 
     * @param text String text
     */
    public void setBalanceText(String text) {
        balanceText.setText(text);
    }

    /**
     * Sets the regular vending machine's
     * payment message.
     * 
     * @param text String text
     */
    public void setPaymentText(String text) {
        paymentText.setText(text);
    }

    /**
     * Sets the regular vending machine's
     * repelenish message.
     * 
     * @param text String text
     */
    public void setReplenishText(String text) {
        replenishText.setText(text);
    }

    /**
     * Sets the text in the regular vending machine's
     * denomination buttons to the corresponding denomination counts.
     * 
     * @param denominationList Denomination list
     */
    public void setDenominationCount(ArrayList<Denomination> denominationList) {
        for (int i = 0; i < 11; i++) {
            denominationBtn[i].setText("<html>" + denominationList.get(i).getAmount() + "<br>(" + denominationList.get(i).getQuantity() + ")<html>");
        }
    }

    /**
     * Sets the regular vending machine's 
     * payment collecting message.
     * 
     * @param text String text
     */
    public void setCollectText(String text) {
        collectText = new JTextArea();
        collectText.setColumns(20);
        collectText.setEditable(false);
        collectText.setText(text);
    }

    /**
     * Sets the regular vending machine's
     * restock history table.
     * 
     * @param data Table data
     */
    public void setRestockTable(Object[][] data) {
        String[] columnNames = {
            "Item",
            "Initial Qty",
            "Current Qty"
        };
    
        restockTable = new JTable(data, columnNames);
        restockScrollPane = new JScrollPane(restockTable);
        restockScrollPane.getViewport().setPreferredSize(new Dimension(350, 125));

        restockTable.setEnabled(false);
        restockTable.getTableHeader().setReorderingAllowed(false);
    }

    /**
     * Sets the regular vending machine's
     * transaction summary table.
     * 
     * @param data Table data
     */
    public void setTransactionTable(Object [][] data) {
        String[] columnNames = {
            "Item",
            "Qty",
            "Price"
        };
    
        transactionTable = new JTable(data, columnNames);
        transactionScrollPane = new JScrollPane(transactionTable);
        transactionScrollPane.getViewport().setPreferredSize(new Dimension(350, 200));

        transactionTable.setEnabled(false);
        transactionTable.getTableHeader().setReorderingAllowed(false);
    }

    /**
     * Sets the text in the special vending machine's
     * item buttons to the corresponding item prices,
     * availabilities, and calories.
     * 
     * @param itemList Item list
     */
    public void setSpecialItems(ArrayList<Item> itemList) {
        for (int i = 0; i < 4; i++) {
            specialItemBtn[i].setText("<html>" + itemList.get(i).getName() + 
            "<br>PHP " + itemList.get(i).getPrice() + 
            "<br>" + itemList.get(i).availableToString() + 
            "<br>Calories: " + itemList.get(i).getCalories() + "<html>");
            specialItemBtn[i].setBackground(new Color(255, 155, 155));
            specialItemBtn[i].setForeground(Color.white);
        }
    }

    /**
     * Sets the special vending machine's
     * balance text.
     * 
     * @param text String text
     */
    public void setSpecialBalanceText(String text) {
        specialBalanceText.setText(text);
    }

    /**
     * Sets the special vending machine's
     * payment message.
     * 
     * @param text String text
     */
    public void setSpecialPaymentText(String text) {
        specialPaymentText.setText(text);
    }

    /**
     * Sets the text for the regular vending machine's
     * display for the change dispensing.
     * 
     * @param text String text
     */
    public void setSpecialDispenseChangeText(String text) {
        specialDispenseChangeText = new JTextArea();
        specialDispenseChangeText.setColumns(20);
        specialDispenseChangeText.setEditable(false);
        specialDispenseChangeText.setText(text);
    }

    /**
     * Sets the special vending machine's
     * restock display message.
     * 
     * @param text String text
     */
    public void setSpecialRestockText(String text) {
        specialRestockText.setText(text);
    }

    /**
     * Sets the display message for 
     * the special vending machine's
     * current restock session.
     * 
     * @param text String text
     */
    public void setSpecialRestockSessionText(String text) {
        specialRestockSessionText.setText(text);
    }

    /**
     * Sets the text in the special vending machine's
     * restock buttons to the corresponding item quantities.
     * 
     * @param itemList Item list
     */
    public void setSpecialItemQuantity(ArrayList<Item> itemList) {
        for (int i = 0; i < 6; i++) {
            specialRItemBtn[i].setText("<html>" + itemList.get(i).getName() + 
            "<br>(" + itemList.get(i).getQuantity() + ")<html>");
        }
    }

    /**
     * Sets the text for the special vending machine's
     * price setting display message.
     * 
     * @param text String text
     */
    public void setSpecialPriceText(String text) {
        specialPriceText.setText(text);
    }

    /**
     * Sets the text in the special vending machine's
     * price setting buttons to the corresponding item prices.
     * 
     * @param itemList Item list
     */
    public void setSpecialItemPrices(ArrayList<Item> itemList) {
        for (int i = 0; i < 6; i++) {
            specialPItemBtn[i].setText("<html>" + itemList.get(i).getName() + "<br>PHP " + itemList.get(i).getPrice() + "<html>");
        }
    }

    /**
     * Sets the special vending machine's
     * repelenish message.
     * 
     * @param text String text
     */
    public void setSpecialReplenishText(String text) {
        specialReplenishText.setText(text);
    }
    
    /**
     * Sets the text in the special vending machine's
     * denomination buttons to the corresponding denomination counts.
     * 
     * @param denominationList Denomination list
     */
    public void setSpecialDenominationCount(ArrayList<Denomination> denominationList) {
        for (int i = 0; i < 11; i++) {
            specialDenominationBtn[i].setText("<html>" + denominationList.get(i).getAmount() + "<br>(" + denominationList.get(i).getQuantity() + ")<html>");
        }
    }

    /**
     * Sets the special vending machine's 
     * payment collecting message.
     * 
     * @param text String text
     */
    public void setSpecialCollectText(String text) {
        specialCollectText = new JTextArea();
        specialCollectText.setColumns(20);
        specialCollectText.setEditable(false);
        specialCollectText.setText(text);
    }

    /**
     * Sets the special vending machine's
     * restock history table.
     * 
     * @param data Table data
     */
    public void setSpecialRestockTable(Object[][] data) {
        String[] columnNames = {
            "Item",
            "Initial Qty",
            "Current Qty"
        };

        
        specialRestockTable = new JTable(data, columnNames);
        specialRestockScrollPane = new JScrollPane(specialRestockTable);
        specialRestockScrollPane.getViewport().setPreferredSize(new Dimension(350, 125));

        specialRestockTable.setEnabled(false);
        specialRestockTable.getTableHeader().setReorderingAllowed(false);
    }
    
    /**
     * Sets the special vending machine's
     * transaction summary table.
     * 
     * @param data Table data
     */
    public void setSpecialTransactionTable(Object [][] data) {
        String[] columnNames = {
            "Item",
            "Qty",
            "Price"
        };
    
        specialTransactionTable = new JTable(data, columnNames);
        specialTransactionScrollPane = new JScrollPane(specialTransactionTable);
        specialTransactionScrollPane.getViewport().setPreferredSize(new Dimension(350, 200));

        specialTransactionTable.setEnabled(false);
        specialTransactionTable.getTableHeader().setReorderingAllowed(false);
        
    }

    /**
     * Sets the special vending machine's
     * item process text.
     * 
     * @param text String text
     */
    public void setMakeText(String text) {
        makeText = new JTextArea();
        makeText.setColumns(20);
        makeText.setEditable(false);
        makeText.setText(text);
    }

    /**
     * Sets listener for the exitProgramBtn
     * 
     * @param actionListener Action listener
     */ 
    public void setExitProgramBtnListener(ActionListener actionListener) {
        this.exitProgramBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the createRVMBtn
     * 
     * @param actionListener Action listener
     */ 
    public void setCreateRVMBtnListener(ActionListener actionListener) {
        this.createRVMBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the createSVMBtn
     * 
     * @param actionListener Action listener
     */ 
    public void setCreateSVMBtnListener(ActionListener actionListener) {
        this.createSVMBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the regularBuyBtn
     * 
     * @param actionListener Action listener
     */ 
    public void setRegularBuyBtnListener(ActionListener actionListener) {
        this.regularBuyBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the regularFinishBtn
     * 
     * @param actionListener Action listener
     */ 
    public void setRegularFinishBtnListener(ActionListener actionListener) {
        this.regularFinishBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the maintenanceBtn
     * 
     * @param actionListener Action listener
     */ 
    public void setMaintenanceBtnListener(ActionListener actionListener) {
        this.maintenanceBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the addBtn
     * 
     * @param actionListener Action listener
     */ 
    public void setAddBtnListener(ActionListener actionListener) {
		this.addBtn.addActionListener(actionListener);
    } 

    /**
     * Sets listener for the finishBtn
     * 
     * @param actionListener Action listener
     */ 
    public void setFinishBtnListener(ActionListener actionListener) {
        this.finishBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the returnMainBtn
     * 
     * @param actionListener Action listener
     */ 
    public void setReturnMainBtnListener(ActionListener actionListener) {
        this.returnMainBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the testVFBtn
     * 
     * @param actionListener Action listener
     */ 
    public void setTestVFBtnListener(ActionListener actionListener) {
        this.testVFBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the testMFBtn
     * 
     * @param actionListener Action listener
     */
    public void setTestMFBtnListener(ActionListener actionListener) {
        this.testMFBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the returnMaintenanceMenuBtn
     * 
     * @param actionListener Action listener
     */
    public void setReturnMaintenanceMenuBtnListener(ActionListener actionListener) {
        this.returnMaintenanceMenuBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the restockBtn
     * 
     * @param actionListener Action listener
     */
    public void setRestockBtnListener(ActionListener actionListener) {
        this.restockBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the setPriceBtn
     * 
     * @param actionListener Action listener
     */
    public void setSetPriceBtnListener(ActionListener actionListener) {
        this.setPriceBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the collectPaymentBtn
     * 
     * @param actionListener Action listener
     */
    public void setCollectPaymentBtnListener(ActionListener actionListener) {
        this.collectPaymentBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the replenishBtn
     * 
     * @param actionListener Action listener
     */
    public void setReplenishBtnListener(ActionListener actionListener) {
        this.replenishBtn.addActionListener(actionListener);
    }
    
    /**
     * Sets listener for the transactionBtn
     * 
     * @param actionListener Action listener
     */
    public void setTransactionBtnListener(ActionListener actionListener) {
        this.transactionBtn.addActionListener(actionListener);
    }

    /**
     * Sets listeners for the itemBtn(s)
     * 
     * @param actionListener Action listener
     * @param i Index
     */
    public void setItemBtnListener(ActionListener actionListener, int i) {
        this.itemBtn[i].addActionListener(actionListener);
    }

    /**
     * Sets listener for the okBtn
     * 
     * @param actionListener Action listener
     */
    public void setOkBtnListener(ActionListener actionListener) {
        this.okBtn.addActionListener(actionListener);
    }

    /**
     * Sets listeners for the rItemBtn(s)
     * 
     * @param actionListener Action listener
     * @param i Index
     */
    public void setRItemBtnListener(ActionListener actionListener, int i) {
        this.rItemBtn[i].addActionListener(actionListener);
    }

    /**
     * Sets listener for the restockFinishBtn
     * 
     * @param actionListener Action listener
     */
    public void setRestockFinishBtnListener(ActionListener actionListener) {
        this.restockFinishBtn.addActionListener(actionListener);
    }

    /**
     * Sets listeners for the pItemBtn(s)
     * 
     * @param actionListener Action listener
     * @param i Index
     */
    public void setPItemBtnListener(ActionListener actionListener, int i) {
        this.pItemBtn[i].addActionListener(actionListener);
    }

    /**
     * Sets listener for the priceFinishBtn
     * 
     * @param actionListener Action listener
     */
    public void setPriceFinishBtnListener(ActionListener actionListener) {
        this.priceFinishBtn.addActionListener(actionListener);
    }

    /**
     * Sets listeners for the denominationBtn(s)
     * 
     * @param actionListener Action listener
     * @param i Index
     */
    public void setDenominationBtnListener(ActionListener actionListener, int i) {
        this.denominationBtn[i].addActionListener(actionListener);
    }

    /**
     * Sets listener for the replenishFinishBtn
     * 
     * @param actionListener Action listener
     */
    public void setReplenishFinishBtnListener(ActionListener actionListener) {
        this.replenishFinishBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the transactionFinishBtn
     * 
     * @param actionListener Action listener
     */
    public void setTransactionFinishBtnListener(ActionListener actionListener) {
        this.transactionFinishBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the collectFinishBtn
     * 
     * @param actionListener Action listener
     */
    public void setCollectFinishBtnListener(ActionListener actionListener) {
        this.collectFinishBtn.addActionListener(actionListener);
    }

    /**
     * Sets listeners for the noBtn(s)
     * 
     * @param actionListener Action listener
     * @param i Index
     */
    public void setNoBtnListener(ActionListener actionListener, int i) {
        this.noBtn[i].addActionListener(actionListener);
    }

    /**
     * Sets listeners for the specialItemBtn(s)
     * 
     * @param actionListener Action listener
     * @param i Index
     */
    public void setSpecialItemBtnListener(ActionListener actionListener, int i) {
        this.specialItemBtn[i].addActionListener(actionListener);
    }

    /**
     * Sets listeners for the customizeItemBtn(s)
     * 
     * @param actionListener Action listener
     * @param i Index
     */
    public void setCustomizeItemBtnListener(ActionListener actionListener, int i) {
        this.customizeItemBtn[i].addActionListener(actionListener);
    }

    /**
     * Sets listeners for the returnBtn(s)
     * 
     * @param actionListener Action listener
     * @param i Index
     */
    public void setReturnBtnListener(ActionListener actionListener, int i) {
        this.returnBtn[i].addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialBuyBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialBuyBtnListener(ActionListener actionListener) {
        this.specialBuyBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialMaintenanceBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialMaintenanceBtnListener(ActionListener actionListener) {
        this.specialMaintenanceBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialFinishBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialFinishBtnListener(ActionListener actionListener) {
        this.specialFinishBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialAddBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialAddBtnListener(ActionListener actionListener) {
        this.specialAddBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialPaymentFinishBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialPaymentFinishBtnListener(ActionListener actionListener) {
        this.specialPaymentFinishBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialOkBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialOkBtnListener(ActionListener actionListener) {
        this.specialOkBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialReturnMainBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialReturnMainBtnListener(ActionListener actionListener) {
        this.specialReturnMainBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialTestVFBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialTestVFBtnListener(ActionListener actionListener) {
        this.specialTestVFBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialTestMFBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialTestMFBtnListener(ActionListener actionListener) {
        this.specialTestMFBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialRestockBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialRestockBtnListener(ActionListener actionListener) {
        this.specialRestockBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialSetPriceBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialSetPriceBtnListener(ActionListener actionListener) {
        this.specialSetPriceBtn.addActionListener(actionListener);
    }
    
    /**
     * Sets listener for the specialCollectPaymentBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialCollectPaymentBtnListener(ActionListener actionListener) {
        this.specialCollectPaymentBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialReplenishBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialReplenishBtnListener(ActionListener actionListener) {
        this.specialReplenishBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialTransactionBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialTransactionBtnListener(ActionListener actionListener) {
        this.specialTransactionBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialReturnMaintenanceMenuBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialReturnMaintenanceMenuBtnListener(ActionListener actionListener) {
        this.specialReturnMaintenanceMenuBtn.addActionListener(actionListener);
    }


    /**
     * Sets listeners for the specialRItemBtn(s)
     * 
     * @param actionListener Action listener
     * @param i Index
     */
    public void setSpecialRItemBtnListener(ActionListener actionListener, int i) {
        this.specialRItemBtn[i].addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialRestockFinishBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialRestockFinishBtnListener(ActionListener actionListener) {
        this.specialRestockFinishBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialPriceFinishBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialPriceFinishBtnListener(ActionListener actionListener) {
        this.specialPriceFinishBtn.addActionListener(actionListener);
    }

    /**
     * Sets listeners for the specialPItemBtn(s)
     * 
     * @param actionListener Action listener
     * @param i Index
     */
    public void setSpecialPItemBtnListener(ActionListener actionListener, int i) {
        this.specialPItemBtn[i].addActionListener(actionListener);
    }

    /**
     * Sets listeners for the specialDenominationBtn(s)
     * 
     * @param actionListener Action listener
     * @param i Index
     */
    public void setSpecialDenominationBtnListener(ActionListener actionListener, int i) {
        this.specialDenominationBtn[i].addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialReplenishFinishBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialReplenishFinishBtnListener(ActionListener actionListener) {
        this.specialReplenishFinishBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialCollectFinishBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialCollectFinishBtnListener(ActionListener actionListener) {
        this.specialCollectFinishBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the specialTransactionFinishBtn
     * 
     * @param actionListener Action listener
     */
    public void setSpecialTransactionFinishBtnListener(ActionListener actionListener) {
        this.specialTransactionFinishBtn.addActionListener(actionListener);
    }

    /**
     * Sets listener for the makeFinishBtn
     * 
     * @param actionListener Action listener
     */
    public void setMakeFinishBtnListener(ActionListener actionListener) {
        this.makeFinishBtn.addActionListener(actionListener);
    }
}