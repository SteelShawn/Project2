import java.util.Comparator;
public class ComparatorByUPC implements Comparator<FoodProduct> {

    public int compare(FoodProduct a, FoodProduct b){
        return a.getUpc() - b.getUpc();
    }
}
