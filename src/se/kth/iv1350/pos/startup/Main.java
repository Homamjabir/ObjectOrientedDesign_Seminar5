package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.dbhandler.ItemDTO;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.view.View;
import java.util.Scanner;

/**
 * The following class is the Main class.
 * This class is responsible for starting the sale,
 * scanning the items, ending the sale and printing the receipt
 */

class Main
{
    public static void main(String[] args)
    {
        Controller contr = new Controller();
        View view = new View(contr);
        Scanner scanner = new Scanner(System.in);

        contr.startSale();

        int itemIdentifier;


        while(true) {
            System.out.print("Enter itemID: ");
            itemIdentifier = scanner.nextInt();

            if(itemIdentifier == 404) { break; }

            ItemDTO newItem;

            try
            {
                newItem = contr.scanItem(itemIdentifier);
            }
            catch (DatabaseFailureException ex)
            {
                System.out.println("USER MESSAGE: A database error occured, please contact the administrator.");
                newItem = null;
            }
            catch (Exception ex)
            {
                System.out.println("USER MESSAGE: Item not found, did you enter the correct identifier?");
                newItem = null;
            }

            if(newItem == null) { continue; }

            contr.uppdateSale(newItem);

            System.out.println("\n=======================================================");

            for (ItemDTO itemDTO : contr.getItems())
                System.out.println(itemDTO.getName() + " - " + itemDTO.getQuantity() + "x - " + itemDTO.getPrice() * itemDTO.getQuantity() + ":-");

            System.out.println(contr.getRunningTotal() + " SEK");
            System.out.println("=======================================================\n");
        }

        Receipt receipt = contr.getReceipt(contr.endCurrentSale());
        System.out.println(receipt.toString());
    }
}