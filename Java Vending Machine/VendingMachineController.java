// ANG, Janell & DIMLA, Kian <S17A>

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * VendingMachineController class that acts as the connecting piece between
 * the VendingMachineView, RegularModel, and SpecialModel objects.
 */
public class VendingMachineController {
    private VendingMachineView view;
    private RegularModel modelR;
    private SpecialModel modelS;

    /**
     * VendingMachineController object constructor that initializes the VendingMachineView,
     * RegularModel, and SpecialModel.
     * 
     * @param view VendingMachineView object
     * @param modelR RegularModel object
     * @param modelS SpecialModel object
     */
    public VendingMachineController(VendingMachineView view, RegularModel modelR, SpecialModel modelS) {
        this.view = view;
        this.modelR = modelR;
        this.modelS = modelS;

        /**
         * Button for exitting the program.
         */
        this.view.setExitProgramBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        /**
         * Button for creating a regular vending machine.
         */
        this.view.setCreateRVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeMenuFrame();
                view.regularScreen();
            }
        });

        /**
         * Button for the regular vending machine menu.
         */
        this.view.setRegularFinishBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeRegularFrame();
                view.mainMenuScreen();
            }
        });

        /**
         * Button to open the item purchasing menu.
         */
        this.view.setRegularBuyBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeRegularFrame();
                view.setItems(modelR.getItemList());
                view.paymentScreen();
                updateBalance();
            }
        });

        /**
         * Button for creating a special vending machine.
         */
        this.view.setCreateSVMBtnListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeMenuFrame();
                view.specialScreen();
            }
        });

        /**
         * Button to open the regular vending machine's maintenance menu.
         */
        this.view.setMaintenanceBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeRegularFrame();
                view.maintenanceScreen();
            }
        });

        /**
         * Button to add balance in the regular vending machine.
         */
        this.view.setAddBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearPaymentText();
                if (view.getPaymentInput().isBlank()) {
                    view.setPaymentText("Please insert money.");
                } else if (modelR.addBalance(view.getPaymentInput())) {
                    String text = ("Balance: " + modelR.getBalance());
                    view.setBalanceText(text);
                    view.setPaymentText("Amount added successfully!");
                } else {
                    view.setPaymentText("Invalid denomination.");
                    view.resetPaymentField();
                }
            }
        });

        /**
         * Button to finish buying in the regular vending machine.
         */
        this.view.setFinishBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposePaymentFrame();
                view.setDispenseChangeText(modelR.dispenseChange());
                view.dispenseChangeScreen();
            }
        });

        /**
         * Button to return to the main menu from the
         * regular vending machine menu.
         */
        this.view.setReturnMainBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeMaintenanceFrame();
                view.regularScreen();
            }
        });

        /**
         * Button to test the regular vending machine's 
         * vending features.
         */
        this.view.setTestVFBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeMaintenanceFrame();
                view.setItems(modelR.getItemList());
                view.paymentScreen();
                updateBalance();
                modelR.setIsVF(true);
            }
        });
        
        /**
         * Button to test the regular vending machine's 
         * maintenance features.
         */
        this.view.setTestMFBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeMaintenanceFrame();
                view.maintenanceFeaturesScreen();
            }
        });

        /**
         * Button to return from the regular vending machine's 
         * maintenance menu.
         */
        this.view.setReturnMaintenanceMenuBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeMaintenanceFeaturesFrame();
                view.maintenanceScreen();
            }
        });

        /**
         * Button to open the regular vending machine's 
         * restock menu.
         */
        this.view.setRestockBtnListener(new ActionListener() { // Restock
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeMaintenanceFeaturesFrame();
                view.setItemQuantity(modelR.getItemList());
                modelR.setDidRestock(false);
                view.restockScreen();
                view.setRestockSessionText("Restock Session: " + modelR.getRestockSession());
            }
        });

        /**
         * Button to open the regular vending machine's 
         * price setting menu.
         */
        this.view.setSetPriceBtnListener(new ActionListener() { // Set Price
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeMaintenanceFeaturesFrame();
                view.setItemPrices(modelR.getItemList());
                view.setPriceScreen();
            }
        });
            
        /**
         * Button to open the regular vending machine's 
         * payment collecting menu.
         */
        this.view.setCollectPaymentBtnListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeMaintenanceFeaturesFrame();
                view.setCollectText("Amount collected: PHP " + modelR.collectPayment());
                view.collectScreen();
            }
        });

        /**
         * Button to open the regular vending machine's 
         * denomination replenishing menu.
         */
        this.view.setReplenishBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeMaintenanceFeaturesFrame();
                view.setDenominationCount(modelR.getDenominationList());
                view.replenishScreen();
            }
        });

        /**
         * Button to open the regular vending machine's 
         * transaction summary menu.
         */
        this.view.setTransactionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeMaintenanceFeaturesFrame();
                view.setRestockTable(modelR.getStockSummaryData());
                view.setTransactionTable(modelR.getTransactionData());
                view.transactionScreen();
            }
        }); 

        /**
         * Buttons in the regular vending machine's 
         * purchasing menu.
         */
        for (int i = 0; i < 8; i++) {
            final int index = i;

            this.view.setItemBtnListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    Item item = modelR.getItemList().get(index);
                    if (!item.isAvailable()) {
                        view.setPaymentText(item.getName() + " is unavailable.");
                    } else {
                        if (item.getPrice() > modelR.getBalance()) {
                            view.setPaymentText("Insufficient funds.");
                        } else {
                            modelR.dispense(index);
                            view.setPaymentText("(1) " + item.getName() + " dispensed.");
                            updateBalance();
                        }
                    }
                    view.resetPaymentField();
                    view.setItems(modelR.getItemList());
                }
            }, index); 
        }

        /**
         * Button to close the regular vending machine's 
         * change dispensing menu.
         */
        this.view.setOkBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeDispenseChangeFrame();
                if (!modelR.getIsVF()) {
                    view.regularScreen();
                } else {
                    view.maintenanceScreen();
                }
                modelR.setIsVF(false);
            }
        });

        for (int i = 0; i < 8; i++) {
            final int index = i;
            /**
             * Buttons in the regular vending machine's 
             * restocking menu.
             */
            view.setRItemBtnListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (view.getRestockInput().isBlank()) {
                        view.setRestockText("Please input quantity.");
                    } else if (modelR.restock(index, view.getRestockInput())) {
                        view.setRestockText("(" + view.getRestockInput() + ") " + modelR.getItemList().get(index).getName() + " successfully restocked!");
                        view.setItemQuantity(modelR.getItemList());
                        view.resetRestockField();
                        modelR.setDidRestock(true);
                    } else {
                        view.setRestockText("Invalid quantity.");
                        view.resetRestockField();
                    }
                }
            }, index);
        }

        /**
         * Button to close the regular vending machine's 
         * restocking menu.
         */
        this.view.setRestockFinishBtnListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeRestockFrame();
                modelR.incrementRestockSession();
                view.maintenanceFeaturesScreen();
            }
        });

        for (int i = 0; i < 8; i++) {
            final int index = i;

            /**
             * Buttons in the regular vending machine's 
             * price setting menu.
             */
            this.view.setPItemBtnListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (view.getPriceInput().isBlank()) {
                        view.setPriceText("Please input price.");
                    } else if (modelR.setPrice(index, view.getPriceInput())) {
                        view.setPriceText(modelR.getItemList().get(index).getName() + " price successfully set to PHP " + view.getPriceInput());
                        view.setItemPrices(modelR.getItemList());
                        view.resetPriceField();
                    } else {
                        view.setPriceText("Invalid price.");
                        view.resetPriceField();
                    }
                }
            }, index);
        }

        /**
         * Buttons in the regular vending machine's 
         * price setting menu.
         */
        this.view.setPriceFinishBtnListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposePriceFrame();
                view.maintenanceFeaturesScreen();
            }
        });

        for (int i = 0; i < 11; i++) {
            final int index = i;

            /**
             * Buttons in the regular vending machine's 
             * denomination replenishing menu.
             */
            this.view.setDenominationBtnListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (view.getReplenishInput().isBlank()) {
                        view.setReplenishText("Please input quantity");
                    } else if (modelR.replenishChange(index, view.getReplenishInput())) {
                        view.setReplenishText("(" + view.getReplenishInput() + ") " + modelR.getDenominationList().get(index).getAmount() + "'s replenished.");
                        view.setDenominationCount(modelR.getDenominationList());
                        view.resetReplenishField();
                    } else {
                        view.setReplenishText("Invalid quantity.");
                        view.resetReplenishField();
                    }
                }
            }, index);
        }

        /**
         * Button to close the regular vending machine's 
         * denomination replenishing menu.
         */
        this.view.setReplenishFinishBtnListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeReplenishFrame();
                view.maintenanceFeaturesScreen();
            }
        });

        /**
         * Button to close the regular vending machine's 
         * transaction summary menu.
         */
        this.view.setTransactionFinishBtnListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeTransactionFrame();
                view.maintenanceFeaturesScreen();
            }
        });

        /**
         * Button to close the regular vending machine's 
         * payment collecting menu.
         */
        this.view.setCollectFinishBtnListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeCollectFrame();
                view.maintenanceFeaturesScreen();
            }
        });

        // Special Vending Machine Buttons

        for (int i = 0; i < 4; i++) {
            final int index = i;

            /**
             * Buttons in the special vending machine's 
             * purchasing menu.
             */
            this.view.setSpecialItemBtnListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Item item = modelS.getItemList().get(index);
                    if (!item.isAvailable()) {
                        view.setSpecialPaymentText(item.getName() + " is unavailable.");
                    } else {
                        if (item.getPrice() > modelS.getBalance()) { 
                            view.setSpecialPaymentText("Insufficient funds.");
                        } else {
                            switch (index) {
                                case 0:
                                    if (modelS.getItemList().get(1).getQuantity() == 0) {
                                        modelS.dispense(index);
                                        view.setSpecialPaymentText("(1) " + item.getName() + " dispensed, no ingredients for upgrade.");
                                        updateSpecialBalance();
                                    } else {
                                        view.iceCreamScreen(modelS.getItemList());
                                        view.hideSpecialPaymentFrame();
                                    }
                                    break;
                            
                                case 1:
                                    if (modelS.getItemList().get(0).getQuantity() == 0) {
                                        modelS.dispense(index);
                                        view.setSpecialPaymentText("(1) " + item.getName() + " dispensed, no ingredients for upgrade.");
                                        updateSpecialBalance();
                                    } else {
                                        view.breadScreen(modelS.getItemList());
                                        view.hideSpecialPaymentFrame();
                                    }
                                    break;
                                
                                case 2:
                                    if (modelS.getItemList().get(4).getQuantity() == 1) {
                                        modelS.dispense(index);
                                        view.setSpecialPaymentText("(1) " + item.getName() + " dispensed, no ingredients for upgrade.");
                                        updateSpecialBalance();
                                    } else {
                                        view.porkCutletScreen(modelS.getItemList());
                                        view.hideSpecialPaymentFrame();
                                    }
                                    break;

                                case 3:
                                    if (modelS.getItemList().get(5).getQuantity() == 0) {
                                        modelS.dispense(index);
                                        view.setSpecialPaymentText("(1) " + item.getName() + " dispensed, no ingredients for upgrade.");
                                        updateSpecialBalance();
                                    } else {
                                        view.beefSoupScreen(modelS.getItemList());
                                        view.hideSpecialPaymentFrame();
                                    }
                                    break;
                            }
                        }
                    }
                    view.resetSpecialPaymentField();
                    view.setSpecialItems(modelS.getItemList());
                }
            }, index);
        }

        for (int i = 0; i < 4; i++) {
            final int index = i;

            /**
             * Buttons in the special vending machine's 
             * item customization menu.
             */
            this.view.setCustomizeItemBtnListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Item item = modelS.getItemList().get(index + 6);
                    if (modelS.getBalance() < item.getPrice()) {
                        view.setSpecialPaymentText("Insufficient funds.");
                    } else {
                        String text = "";
                        modelS.dispense(index + 6);
                        view.setSpecialPaymentText("(1) " + item.getName() + " dispensed.");
                        updateSpecialBalance();

                        switch (index) {
                            case 0:
                                text = "Dipping meat in batter...\nFrying meat...\n\nScrambling eggs...\nCooking eggs...\n\nCombining...\n\nKatsudon ready!";
                                break;
                        
                            case 1:
                                text = "Boiling noodles...\nAdding to bowl...\n\nAdding beef soup\n\nRamen ready!";
                                break;
    
                            case 2:
                                text = "Scrambling egg...\nCooking egg...\n\nToasting bread...\n\nCombining...\n\nEgg Sandwich ready!";
                                break;
    
                            case 3:
                                text = "Scooping ice cream...\n\nAdding ice cream to bread\n\nIce Cream Sandwich ready!";
                                break;
                        }

                        view.setMakeText(text);
                        view.makeScreen();
                    }

                    switch (index) {
                        case 0:
                            view.disposePorkCutletFrame();
                            break;
                    
                        case 1:
                            view.disposeBeefSoupFrame();
                            break;

                        case 2:
                            view.disposeSandwichFrame();
                            break;

                        case 3:
                            view.disposeSandwichFrame();
                            break;
                    }
                }
            }, index);
        }

        for (int i = 0; i < 4; i++) {
            final int index = i;

            /**
             * Buttons in the special vending machine's 
             * item customization menu to decline.
             */
            this.view.setNoBtnListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    modelS.dispense(index);
                    view.setSpecialPaymentText("(1) " + modelS.getItemList().get(index).getName() + " dispensed.");
                    updateSpecialBalance();
                    switch (index) {
                        case 0:
                            view.disposeIceCreamFrame(); // Ice Cream
                            break;
                    
                        case 1:
                            view.disposeBreadFrame(); // Bread
                            break;
                        
                        case 2:
                            view.disposePorkCutletFrame(); 
                            break;

                        case 3:
                            view.disposeBeefSoupFrame();
                            break;
                    }
                    
                    view.showSpecialPaymentFrame();
                }
            }, index);
        }

        for (int i = 0; i < 4; i++) {
            final int index = i;

            /**
             * Buttons in the special vending machine's 
             * to return from the item customization menu.
             */
            this.view.setReturnBtnListener((new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (index) {
                        case 0:
                            view.disposeIceCreamFrame(); // Ice Cream
                            break;
                    
                        case 1:
                            view.disposeBreadFrame(); // Bread
                            break;
                        
                        case 2:
                            view.disposePorkCutletFrame(); 
                            break;

                        case 3:
                            view.disposeBeefSoupFrame();
                            break;
                    }
                    view.showSpecialPaymentFrame();
                    view.setSpecialPaymentText("");
                }
            }), index);
        }

        /**
         * Button to open the special vending machine's 
         * purchasing menu.
         */
        this.view.setSpecialBuyBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialFrame();
                view.setSpecialItems(modelS.getItemList());
                view.specialPaymentScreen();
                updateSpecialBalance();
            }
        });

        /**
         * Button to return from the 
         * special vending machine's menu.
         */
        this.view.setSpecialFinishBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialFrame();
                view.mainMenuScreen();
            }
        }); 

        /**
         * Button to add balance in the 
         * special vending machine's purchasing menu.
         */
        this.view.setSpecialAddBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearSpecialPaymentText();
                if (view.getSpecialPaymentInput().isBlank()) {
                    view.setSpecialPaymentText("Please insert money.");
                } else if (modelS.addBalance(view.getSpecialPaymentInput())) {
                    String text = ("Balance: " + modelS.getBalance());
                    view.setSpecialBalanceText(text);
                    view.setSpecialPaymentText("Amount added successfully!");
                } else {
                    view.setSpecialPaymentText("Invalid denomination.");
                    view.resetSpecialPaymentField();
                }
            }
        });

        /**
         * Button to return from the special vending machine's 
         * purchasing menu.
         */
        this.view.setSpecialPaymentFinishBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialPaymentFrame();
                view.setSpecialDispenseChangeText(modelS.dispenseChange());
                view.specialDispenseChangeScreen();
            }
        });

        /**
         * Button to return from the special vending machine's 
         * change dispensing menu.
         */
        this.view.setSpecialOkBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialDispenseChangeFrame();
                if (!modelS.getIsVF()) {
                    view.specialScreen();
                } else {
                    view.specialMaintenanceScreen();
                }
                modelS.setIsVF(false);
            }
        });

        /**
         * Button to open the special vending machine's 
         * maintenance menu.
         */
        this.view.setSpecialMaintenanceBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialFrame();
                view.specialMaintenanceScreen();
            }
        });

        /**
         * Button to return from the special vending machine's 
         * maintenance menu.
         */
        this.view.setSpecialReturnMainBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialMaintenanceFrame();
                view.specialScreen();
            }
        });

        /**
         * Button to test the special vending machine's 
         * vending features.
         */
        this.view.setSpecialTestVFBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialMaintenanceFrame();
                view.setSpecialItems(modelS.getItemList());
                view.specialPaymentScreen();
                updateSpecialBalance();
                modelS.setIsVF(true);
            }
        });

        /**
         * Button to open the special vending machine's 
         * maintenance features menu.
         */
        this.view.setSpecialTestMFBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialMaintenanceFrame();
                view.specialMaintenanceFeaturesScreen();
            }
        });

        /**
         * Button to returnf rom the special vending machine's 
         * maintenance features menu.
         */
        this.view.setSpecialReturnMaintenanceMenuBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialMaintenanceFeaturesFrame();
                view.specialMaintenanceScreen();
            }
        });

        /**
         * Button to open the special vending machine's 
         * restocking menu.
         */
        this.view.setSpecialRestockBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialMaintenanceFeaturesFrame();
                view.setSpecialItemQuantity(modelS.getItemList());
                modelS.setDidRestock(false);
                view.specialRestockScreen();
                view.setSpecialRestockSessionText("Restock Session: " + modelS.getRestockSession());
            }
        });

        for (int i = 0; i < 6; i++) {
            final int index = i;

            /**
             * Buttons in the special vending machine's 
             * restocking menu.
             */
            this.view.setSpecialRItemBtnListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (view.getSpecialRestockInput().isBlank()) {
                        view.setSpecialRestockText("Please input quantity.");
                    } else if (modelS.restock(index, view.getSpecialRestockInput())) {
                        view.setSpecialRestockText("(" + view.getSpecialRestockInput() + ") " + 
                        modelS.getItemList().get(index).getName() + " successfully restocked!");

                        view.setSpecialItemQuantity(modelS.getItemList());
                        view.resetSpecialRestockField();
                        modelS.setDidRestock(true);
                    } else {
                        view.setSpecialRestockText("Invalid quantity.");
                        view.resetSpecialRestockField();
                    }
                }
            }, index);
        }

        /**
         * Button to return from the special vending machine's 
         * restocking menu.
         */
        this.view.setSpecialRestockFinishBtnListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialRestockFrame();
                modelS.incrementRestockSession();
                view.specialMaintenanceFeaturesScreen();
            }
        });

        /**
         * Button to open the special vending machine's 
         * price setting menu.
         */
        this.view.setSpecialSetPriceBtnListener(new ActionListener() { // Set Price
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialMaintenanceFeaturesFrame();
                view.setSpecialItemPrices(modelS.getItemList());
                view.specialSetPriceScreen();
            }
        });

        /**
         * Button to return from the special vending machine's 
         * price setting menu.
         */
        this.view.setSpecialPriceFinishBtnListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialPriceFrame();
                view.specialMaintenanceFeaturesScreen();
            }
        });

        for (int i = 0; i < 6; i++) {
            final int index = i;
        
            /**
             * Buttons in the special vending machine's 
             * price setting menu.
             */
            this.view.setSpecialPItemBtnListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (view.getSpecialPriceInput().isBlank()) {
                        view.setSpecialPriceText("Please input price.");
                    } else if (modelS.setPrice(index, view.getSpecialPriceInput())) {
                        view.setSpecialPriceText(modelS.getItemList().get(index).getName() + " price successfully set to PHP " + view.getSpecialPriceInput());
                        view.setSpecialItemPrices(modelS.getItemList());
                        view.resetSpecialPriceField();
                    } else {
                        view.setSpecialPriceText("Invalid price.");
                        view.resetSpecialPriceField();
                    }
                }
            }, index);
        }

        /**
         * Button to open the special vending machine's 
         * denomination replenishing menu.
         */
        this.view.setSpecialReplenishBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialMaintenanceFeaturesFrame();
                view.setSpecialDenominationCount(modelS.getDenominationList());
                view.specialReplenishScreen();
            }
        });

        for (int i = 0; i < 11; i++) {
            final int index = i;

            /**
             * Buttons in the special vending machine's 
             * denomination replenishing menu.
             */
            this.view.setSpecialDenominationBtnListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (view.getSpecialReplenishInput().isBlank()) {
                        view.setSpecialReplenishText("Please input quantity");
                    } else if (modelS.replenishChange(index, view.getSpecialReplenishInput())) {
                        view.setSpecialReplenishText("(" + view.getSpecialReplenishInput() + ") " + modelS.getDenominationList().get(index).getAmount() + "'s replenished.");
                        view.setSpecialDenominationCount(modelS.getDenominationList());
                        view.resetSpecialReplenishField();
                    } else {
                        view.setSpecialReplenishText("Invalid quantity.");
                        view.resetSpecialReplenishField();
                    }
                }
            }, index);
        }

        /**
         * Button to return from the special vending machine's 
         * denomination replenishing menu.
         */
        this.view.setSpecialReplenishFinishBtnListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialReplenishFrame();
                view.specialMaintenanceFeaturesScreen();
            }
        });

        /**
         * Button to open the special vending machine's 
         * payment collecting menu.
         */
        this.view.setSpecialCollectPaymentBtnListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialMaintenanceFeaturesFrame();
                view.setSpecialCollectText("Amount collected: PHP " + modelS.collectPayment());
                view.specialCollectScreen();
            }
        });

        /**
         * Button to return from the special vending machine's 
         * payment collecting menu.
         */
        this.view.setSpecialCollectFinishBtnListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialCollectFrame();
                view.specialMaintenanceFeaturesScreen();
            }
        });

        /**
         * Button to open the special vending machine's 
         * transaction summary menu.
         */
        this.view.setSpecialTransactionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialMaintenanceFeaturesFrame();
                view.setSpecialRestockTable(modelS.getStockSummaryData());
                view.setSpecialTransactionTable(modelS.getTransactionData());
                view.specialTransactionScreen();
            }
        }); 

        /**
         * Button to return from the special vending machine's 
         * transaction summary menu.
         */
        this.view.setSpecialTransactionFinishBtnListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeSpecialTransactionFrame();
                view.specialMaintenanceFeaturesScreen();
            }
        });

        /**
         * Button to return from the special vending machine's 
         * customizable item making process menu.
         */
        this.view.setMakeFinishBtnListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                view.disposeMakeFrame();
                view.showSpecialPaymentFrame();
            }
        });
    }

    /**
     * Updates the regular vending machine's balance text.
     */
    public void updateBalance() {
        String text = ("Balance: " + modelR.getBalance());
        view.setBalanceText(text);
    }

    /**
     * Updates the special vending machine's balance text.
     */
    public void updateSpecialBalance() { 
        String text = ("Balance: " + modelS.getBalance());
        view.setSpecialBalanceText(text);
    }

    /**
     * Main Class of the vending machine creator.
     * 
     * @param args Main
     */
    public static void main(String[] args) {
        VendingMachineView view = new VendingMachineView();
        RegularModel modelR = new RegularModel();
        SpecialModel modelS = new SpecialModel();

        VendingMachineController vendingMachineController = new VendingMachineController(view, modelR, modelS);
    }
}