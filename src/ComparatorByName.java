import java.util.Comparator;

public class ComparatorByName implements Comparator<FoodProduct> {

    public int compare(FoodProduct a, FoodProduct b){
        return a.compareTo(b);
    }
}
