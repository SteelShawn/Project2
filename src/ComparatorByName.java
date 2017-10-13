import java.util.Comparator;

/**
 * Comparator class to compare Food Products by their name
 * @author Shawn
 */
public class ComparatorByName implements Comparator<FoodProduct> {

    /**
     * Compares two food products by their name
     * @param a The first food product
     * @param b The second food product
     * @return The value 0,1,-1 for the comparison
     */
    public int compare(FoodProduct a, FoodProduct b){
        return a.compareTo(b);
    }
}
