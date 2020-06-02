package se.kth.iv1350.pos.dbhandler;

import se.kth.iv1350.pos.model.Receipt;
import se.kth.iv1350.pos.model.SaleDTO;

/**
 * The following class is the printer class.
 * This class calls printReceipt in order to print
 * the receipt.
 */

public class Printer
{
    /**
     * Creates new instance of class Printer
     */
    public Printer()
    {

    }

    /**
     * Creates a receipt.
     * @param saleDTO The given <code>SaleDTO</code> to create a receipt from.
     * @return An instance of <code>Receipt</code>.
     */
    public Receipt printReceipt(SaleDTO saleDTO)
    {
        return new Receipt(saleDTO);
    }
}