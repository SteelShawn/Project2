import java.util.Comparator;

/**
 * Comp
 */
public class ComparatorByUPC implements Comparator<FoodProduct> {

    public int compare(FoodProduct a, FoodProduct b){
        return a.getUpc() - b.getUpc();
    }
}
