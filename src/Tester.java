import java.util.*;
import java.util.Collections;
public class Tester {
    public static void main(String[] args){
        //ArrayList<FoodProduct> FPlist = new ArrayList<>();
        //Scanner k = new Scanner(System.in);
        //Inventory inventory = new Inventory();
        Menu menu = new Menu();
        menu.menuInteraction();
        //inventory.uploadInformation("Inventory.txt");
        //inventory.printByName();
        //inventory.decrement("0011112000");
        //inventory.printByName();
        //inventory.printByExpDate();


/*
        //Testing Sorting my using the Comparator interface with the FoodProduct Class
        FoodProduct a = new FoodProduct("Atem1", 10, 9.69, 12347, "100795");
        FoodProduct b = new FoodProduct("Dtem2", 11, 9.79, 12346, "100796");
        FoodProduct c = new FoodProduct("Ctem3", 12, 9.89, 12345, "100797");
        FoodProduct d = new FoodProduct("Btem4", 13, 9.89, 12344, "100798");
        FoodProduct e = new FoodProduct("TItem5", 14, 9.89, 12343, "100799");
        FPlist.add(a);
        FPlist.add(b);
        FPlist.add(c);
        FPlist.add(d);
        FPlist.add(e);
        //inventory.printByName(FPlist);
/*
        System.out.println("Unsorted List");
        for(FoodProduct p:FPlist){
            System.out.println(p);
        }
        System.out.println("Sorted By Date");
        Collections.sort(FPlist, new ComparatorByDate());
        for(FoodProduct p:FPlist){
            System.out.println(p);
        }
        System.out.println( "Sorted By UPC");
        Collections.sort(FPlist, new ComparatorByUPC());
        for(FoodProduct p:FPlist){
            System.out.println(p);
        }


/*      Testing for searching through ArrayList of FoodProducts
        String testName = k.next();
        for(FoodProduct p:FPlist){
            if (p.getName().equals(testName)){
                System.out.print("Found " + p.getName() + " UPC " + p.getUpc() + " Quantity " + p.getQuantity() +
                        " Price: " + p.getPrice() + " Expiration Date " + p.getExpDate());
            }
        }
*/

/*
 //Testing sorting a product using the comparable interface with the product class
        ArrayList<Product> list = new ArrayList<>();
        Product aa = new Product("eight", 10, 9.98);
        Product bb = new Product("seven", 101, 9.97);
        Product dd = new Product("erg", 102, 9.69);
        Product ee = new Product("jkl", 103, 9.59);
        Product ff = new Product("abc", 104, 9.49);
        list.add(aa);
        list.add(bb);
        list.add(dd);
        list.add(ee);
        list.add(ff);
        for (Product p:list) {
            System.out.println(p);
        }
        Collections.sort(list);
        for (Product p:list) {
            System.out.println(p);
        }
        */
    }
}
