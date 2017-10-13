import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class InventoryIO {

    public void printByName(ArrayList<FoodProduct> list){
        System.out.println();
        System.out.format("%-20s%-11s%-9s%-16s", "Product Name", "UPC", "Quantity", "Expiration Date");
        System.out.println();
        for(FoodProduct f : list){
            System.out.format("%-20s%-11s%-9s%-16s", f.getName(),
                    f.leadingZeroUPC(f.getUpc()), f.getQuantity(), f.getExpDate());
            System.out.println();
        }
        System.out.println();
        }

    public void printByDate(ArrayList<FoodProduct> list) {
        System.out.println();
        System.out.format("%-16s%-11s%-9s%-20s", "Expiration Date", "UPC", "Quantity", "Product Name");
        System.out.println();
        for(FoodProduct f : list){
            System.out.format("%-16s%-11s%-9s%-20s", f.getExpDate(),
                    f.leadingZeroUPC(f.getUpc()), f.getQuantity(), f.getName());
            System.out.println();
        }
        System.out.println();
    }

    public ArrayList<FoodProduct> uploadFromFile(ArrayList<FoodProduct> inven, String fileName) throws java.io.FileNotFoundException {
        ArrayList<FoodProduct> returnList = null;
        if (fileName == null || fileName.equals(""))
            return returnList;

        File file = new File(fileName);
            returnList = inven;
            Scanner read = new Scanner(file);

            while (read.hasNextLine()) {
                String line = read.nextLine();
                String regExp = "\\s*(\\s|,)\\s*";
                String[] sValues = line.split(regExp);
                //System.out.println(Arrays.toString(sValues));
                FoodProduct s = new FoodProduct(sValues[0],Integer.parseInt(sValues[2]),
                        Double.parseDouble(sValues[3]),Integer.parseInt(sValues[1]), sValues[4]);
                returnList.add(s);
            }//end while
        return returnList;

    }//end readFile()
}
