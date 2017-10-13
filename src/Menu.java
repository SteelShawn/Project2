import java.util.Scanner;

public class Menu {
    Inventory inventory;
    Scanner k = new Scanner(System.in);

    public Menu(){
        inventory = new Inventory();
        inventory.uploadInformation("Inventory.txt");
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
            inventory.uploadInformation("delivery.txt");
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
            inventory.searchFor(getInput());
            menuInteraction();
        }
        if (action.equals("D")){
            inventory.decrement(getInput());
            menuInteraction();
        }
        if (action.equals("R")) {
            inventory.remove(getInput());
            menuInteraction();
        }
        if (action.equals("Q")) {
            inventory.saveInventory();
            quit();
            }
        }

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
