import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

/**
 * The InventoryIO class handles the formatting of a printed lists, and the input and output with the file
 * @author Shawn
 */
public class InventoryIO {

    /**
     * Default constructor for InventoryIO
     */
    public InventoryIO(){
    }
    /**
     * Method to display a formatted list organized by the name of the products
     * @param list The list that is going to be displayed
     */
    public void printByName(ArrayList<FoodProduct> list){
        System.out.println();
        System.out.format("%-20s%-11s%-9s%-5s%-16s", "Product Name", "UPC", "Quantity", "Cost", "Expiration Date");
        System.out.println();
        for(FoodProduct f : list){
            System.out.format("%-20s%-11s%-9s%-5s%-16s", f.getName(),
                    f.leadingZeroUPC(f.getUpc()), f.getQuantity(), f.getPrice(), f.getExpDate());
            System.out.println();
        }
        System.out.println();
        }

    /**
     * Method to display a formatted list organized by the expiration date
     * @param list The list that is going to be displayed
     */
    public void printByDate(ArrayList<FoodProduct> list) {
        System.out.println();
        System.out.format("%-16s%-20s%-11s%-9s%-5s","Expiration Date", "Product Name", "UPC", "Quantity", "Cost");
        System.out.println();
        for(FoodProduct f : list){
            System.out.format("%-16s%-20s%-11s%-9s%-5s",f.getExpDate(), f.getName(),
                    f.leadingZeroUPC(f.getUpc()), f.getQuantity(), f.getPrice());
            System.out.println();
        }
        System.out.println();
    }

    /**
     * A method that takes a file and adds all of the items from the file to the list
     * The method will update products already on the list by the new quantity instead of adding a new product
     * @param inven The list that is recieving the new updated products
     * @param fileName The name of the file being opened
     * @return An ArrayList that has all of the products from the file
     * @throws java.io.FileNotFoundException For when the given file name is invalid
     */
    public ArrayList<FoodProduct> uploadFromFile(ArrayList<FoodProduct> inven, String fileName) throws java.io.FileNotFoundException {
        ArrayList<FoodProduct> returnList = null;

        if (fileName == null || fileName.equals(""))
            return inven;

        File file = new File(fileName);
            returnList = inven;
            Scanner read = new Scanner(file);
            Boolean contains;

            while (read.hasNextLine()) {
                contains = false;
                String line = read.nextLine();
                String regExp = "\\s*(\\s|,)\\s*";
                String[] sValues = line.split(regExp);
                FoodProduct s = new FoodProduct(sValues[0],Integer.parseInt(sValues[2]),
                        Double.parseDouble(sValues[3]),Integer.parseInt(sValues[1]), sValues[4]);
                if(inven.isEmpty()){
                    returnList.add(s);
                }else {
                    for (FoodProduct fp : inven) {
                        if (fp.getName().equals(s.getName())) {
                            fp.setQuantity(fp.getQuantity() + s.getQuantity());
                            contains = true;
                        }
                    }
                    if (contains == false) {
                        returnList.add(s);
                    }
                }
            }
        return returnList;
    }

    /**
     * Writes the current inventory to a file to be uploaded when the program is next executed
     * @param inven The array list being added to the file
     * @throws java.io.FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public void writeInventoryToFile(ArrayList<FoodProduct> inven) throws java.io.FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("inventory.txt", "UTF-8");
        for(FoodProduct fp : inven) {
            writer.println(fp);
        }
        writer.close();


    }

}
