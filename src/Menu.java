import java.util.Scanner;

/**
 * Class to manage the interaction between the program and the user
 * @author Shawn
 */
public class Menu {
    Inventory inventory;
    Scanner k = new Scanner(System.in);

    /**
     * Default constructor for the menu class
     * Creates a new inventory and uploads from the inventory.txt file
     */
    public Menu(){
        inventory = new Inventory();
        inventory.uploadInformation("inventory.txt");
    }

    /**
     * Method to get the user's input
     * @return action a String of the user's input
     */
    private String getInput() {
        return k.next();
    }
    /**
     * Method to display the menu options
     */
    private void displayOptions(){
        System.out.println("Please select your option from the following menu:");
        System.out.println("U: Upload product information for a delivery");
        System.out.println("P: Print the current inventory sorted by product name");
        System.out.println("E: List the current inventory sorted by expiration date");
        System.out.println("S: Search for an item by product name");
        System.out.println("D: Decrement the quantity for an item");
        System.out.println("R: Remove/discontinue an item");
        System.out.println("Q: Quit the System");
        System.out.print("Enter your choice");
    }
    /**
     * method to process the user's action
     * @param action String of the user's input
     */
    private void processAction(String action){
        if (action.equals("U")){
            System.out.println("Please enter the Delivery file:");
            inventory.uploadInformation(getInput());
            System.out.println();
            menuInteraction();
        }
        if (action.equals("P")){
            inventory.printByName();
            menuInteraction();
        }
        if (action.equals("E")){
            inventory.printByExpDate();
            menuInteraction();
        }
        if (action.equals("S")){
            System.out.println("Please enter the name of the product you would like to search for:");
            inventory.searchByName(getInput());
            System.out.println();
            menuInteraction();
        }
        if (action.equals("D")){
            System.out.println("Please enter the UPC:");
            inventory.decrement(getInput());
            System.out.println();
            menuInteraction();
        }
        if (action.equals("R")) {
            System.out.println("Please enter the name of Product to be discontinued:");
            inventory.remove(getInput());
            System.out.println();
            menuInteraction();
        }
        if (action.equals("Q")) {
            inventory.saveInventory();
            quit();
            }
        }

    /**
     * Method to quit the program
     */
    private void quit() {
        System.exit(0);
    }
    /**
         * Method combining displayOptions, getActions, ProcessActions
         */
    public void menuInteraction(){
            displayOptions();
            processAction(getInput());
        }

    }
