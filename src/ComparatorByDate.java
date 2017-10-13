import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
public class ComparatorByDate implements Comparator<FoodProduct> {

    public int compare(FoodProduct a, FoodProduct b) {
        String aString = a.getExpDate();
        String bString = b.getExpDate();
        try {
            Date dateA = new SimpleDateFormat("ddMMyy").parse(aString);
            Date dateB = new SimpleDateFormat("ddMMyy").parse(bString);
            return dateA.compareTo(dateB);
        }catch(java.text.ParseException e){
        e.printStackTrace();
        }
        return 0;
    }
}





        /* if (Integer.parseInt(aString.substring(4,5)) - Integer.parseInt(bString.substring(4,5)) < 0){
            return 1;
        }
        if (Integer.parseInt(aString.substring(4,5)) - Integer.parseInt(bString.substring(4,5)) > 0){
            return -1;
        }
        if (Integer.parseInt(aString.substring(0,1)) - Integer.parseInt(bString.substring(0,1)) < 0){
            return 1;
        }
        if (Integer.parseInt(aString.substring(0,1)) - Integer.parseInt(bString.substring(0,1)) > 0){
            return -1;
        }
        if (Integer.parseInt(aString.substring(2,3)) - Integer.parseInt(bString.substring(2,3)) < 0){
            return 1;
        }
        if (Integer.parseInt(aString.substring(2,3)) - Integer.parseInt(bString.substring(2,3)) > 0){
            return -1;
        }

        else return 0;

    }
}
*/