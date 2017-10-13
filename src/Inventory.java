import java.util.ArrayList;
import java.util.Collections;

/**
 * Class to manage and modify the Inventory of Food Products
 * Creates an ArrayList of food products to store them
 */
public class Inventory {
    ArrayList<FoodProduct> inven = new ArrayList();
    InventoryIO io = new InventoryIO();
    public Inventory(){ }

    /**
     * Method to upload information from a user inputed file name.
     * @param filename A string from the user of the file name
     */
    public void uploadInformation(String filename) {
        try{
            inven = io.uploadFromFile(inven, filename);
        } catch (java.io.FileNotFoundException e) {
            System.out.println("file not found");
            //e.printStackTrace();
        }
    }

    /**
     * Method to sort the list by Product Name and then print the list formatted
     */
    public void printByName() {
        sortByName();
        io.printByName(inven);
    }

    /**
     * Method to sort the list By Product Name
     */
    private void sortByName() {
        Collections.sort(inven, new ComparatorByName());
    }

    /**
     * Method to sort the list by expiration date and then print the list formatted
     */
    public void printByExpDate() {
        sortByDate();
        io.printByDate(inven);
    }

    /**
     * method to sort the list by date
     */
    private void sortByDate() {
        Collections.sort(inven, new ComparatorByDate());
    }

    /**
     * Method to search a product by name to get the Stock Report
     * @param name The name of the Food Product the user is searching for.
     */
    public void searchByName(String name) {
        if(inven.contains(getFoodProductByName(name))){
            System.out.println("Current Stock Report:");
            System.out.println(getFoodProductByName(name));
        }
        else{
            System.out.println(name + " was not found");
        }
    }

    /**
     * A method to get a food product using the UPC of the product
     * @param upc The UPC of the product the user wants to search for
     * @return The Food Product in the list that has the UPC the user inputted
     */
    private FoodProduct getFoodProductByUPC(String upc) {
        for (FoodProduct fp : inven) {
            if (fp.getUpc() == Integer.parseInt(upc))
                return fp;
        }
        return null;
    }

    /**
     * A method to decrement a food product by 1 using the UPC
     * @param upc The UPC of the product that needs to be decremented
     */
    public void decrement(String upc) {
        if (getFoodProductByUPC(upc) != null) {
            FoodProduct foodProductToDecrement = getFoodProductByUPC(upc);
            int currentQuantity = foodProductToDecrement.getQuantity();
            if (currentQuantity > 0) {
                foodProductToDecrement.setQuantity(currentQuantity - 1);
                System.out.println("Updated Stock Information:");
                System.out.println(foodProductToDecrement);
            } else {
                System.out.println("Error: this item is not found in the inventory records");
            }
        }else{
            System.out.println("Error: this item is not found in the inventory records");
        }
    }

    /**
     * Method to remove and discontinue a food product from the list
     * @param name The Name of the food product that is wanted to be discontinued.
     */
    public void remove(String name) {
        FoodProduct foodProductToRemove = getFoodProductByName(name);
        if(inven.contains(foodProductToRemove)){
            inven.remove(foodProductToRemove);
            System.out.println("The item:");
            System.out.println(foodProductToRemove.getName() + " " + foodProductToRemove.getUpc());
            System.out.println("Has successfully been removed");
        }else{
            System.out.println("Error: this item is not found in the inventory records");
        }
    }

    /**
     * Method that eturns the Food Product with the name that is being asked for.
     * @param name The Name of the Food Product the user wants
     * @return A Food Product with the name the user inputted
     */
    public FoodProduct getFoodProductByName(String name) {
        for (FoodProduct fp : inven) {
            if (fp.getName().equals(name))
                return fp;
        }
        return null;
        }

    /**
     * Method to save the current inventory to the inventory.txt file
     * Called in the quit option from the menu class
     */
    public void saveInventory() {
        try{
            io.writeInventoryToFile(inven);
        } catch (java.io.FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        } catch (java.io.UnsupportedEncodingException e){
            System.out.println("Error writing to file");
            e.printStackTrace();
        }
    }
}
