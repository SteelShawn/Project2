import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 *Comparator class to compare Food Products by their expiration date.
 * @author Shawn
 */
public class ComparatorByDate implements Comparator<FoodProduct> {

    /**
     * Compares 2 food products by their expiration date
     * @param a The first food product
     * @param b the second food product
     * @return returns either a -1,0,1 for the comparison
     */
    public int compare(FoodProduct a, FoodProduct b) {
        String aString = a.getExpDate();
        String bString = b.getExpDate();
        try {
            Date dateA = new SimpleDateFormat("MMddyy").parse(aString);
            Date dateB = new SimpleDateFormat("MMddyy").parse(bString);
            return dateA.compareTo(dateB);
        }catch(java.text.ParseException e){
        e.printStackTrace();
        }
        return 0;
    }
}
