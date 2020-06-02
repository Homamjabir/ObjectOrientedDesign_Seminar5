package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.dbhandler.ItemDTO;
import se.kth.iv1350.pos.model.*;
import java.util.ArrayList;

/**
 * The following class is the controller class.
 * All calls to the model pass through the controller class.
 */

public class Controller
{
    private CashRegister cashRegister;
    private Sale sale;

    /**
     * Constructor to create the Controller object
     */
    public Controller() {
        this.cashRegister = new CashRegister();
        this.sale = new Sale();
    }

    /**
     * Calls createNewSale in cashRegister to create a new sale object
     * @return
     */
    public void startSale() {
        cashRegister.createNewSale();
    }

    /**
     * Calls scanIdentifier in cashRegister to scan a specific itemIdentifier
     * @param itemIdentifier Identifier of an item
     * @return ItemDTO of the found item
     */
    public ItemDTO scanItem(int itemIdentifier) throws Exception {
        try {
            return cashRegister.scanIdentifier(itemIdentifier);
        }
        catch (DatabaseFailureException ex) {
            throw new DatabaseFailureException();
        }
        catch (Exception ex) {
            throw new InvalidIdentifierException();
        }
    }

    /**
     * Calls createReceipt in cashRegister to create a Receipt object
     * @param saleDTO Sale information that will be included in the receipt
     * @return Receipt from the SaleDTO
     */
    public Receipt getReceipt(SaleDTO saleDTO) {
        return cashRegister.createReceipt(saleDTO);
    }

    /**
     * Ends a given sale by calling enCurrentSale in cashRegister
     * @return SaleDTO from Sale
     */
    public SaleDTO endCurrentSale() { return cashRegister.endCurrentSale(sale); }

    public void uppdateSale(ItemDTO item) {
        sale.uppdateSale(item);
    }

    public ArrayList<ItemDTO> getItems() {
        return sale.getItems();
    }

    public double getRunningTotal() {
        return sale.getRunningTotal();
    }


}
