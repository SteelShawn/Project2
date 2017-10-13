import java.util.ArrayList;
import java.util.Collections;

public class Inventory {
    ArrayList<FoodProduct> inven = new ArrayList();
    InventoryIO io = new InventoryIO();
    public Inventory(){ }

    public void uploadInformation(String filename) {
        try{
            inven = io.uploadFromFile(inven, filename);
        } catch (java.io.FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
    }

    public void printByName() {
        sortByName();
        io.printByName(inven);
    }

    private void sortByName() {
        Collections.sort(inven, new ComparatorByName());
    }

    public void printByExpDate() {
        sortByDate();
        io.printByDate(inven);
    }

    private void sortByDate() {
        Collections.sort(inven, new ComparatorByDate());
    }

    public void searchFor(String name) {
        if(inven.contains(getFoodProductFromList(name))){
            System.out.println(getFoodProductFromList(name));
        }
        else{
            System.out.println(name + " was not found");
        }

    }

    public void decrement(String name) {
        FoodProduct foodProductToDecrement = getFoodProductFromList(name);
        int currentQuantity = foodProductToDecrement.getQuantity();
        foodProductToDecrement.setQuantity(currentQuantity - 1);
    }

    public void remove(String name) {
        inven.remove(getFoodProductFromList(name));
    }

    private FoodProduct getFoodProductFromList(String name) {
        for (FoodProduct fp : inven) {
            if (fp.getName().equals(name))
                return fp;
        }
        return null;
        }


    public void saveInventory() {
    }
}
