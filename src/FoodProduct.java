public class FoodProduct extends Product {
    int upc;
    String expDate;

    /**
     * Default FoodProduct ocnstructor
     */
    public FoodProduct(){
        quantity = 0;
        price = new Double(0.0);
        upc = 0;
        expDate = "";
    }

    /**
     * Non default constructor for a FoodProduct Object
     * @param name String of the name of the product
     * @param quantity int of the number of products
     * @param price Double of the cost of the product
     * @param upc int of the UPC code of the product
     * @param exp String of the experation date of the product
     */
    public FoodProduct(String name, int quantity, Double price, int upc, String exp){
        super(name, quantity, price);
        this.upc = upc;
        expDate = exp;
    }

    /**
     * Method to get the UPC of a specific product
     * @return int of the UPC
     */
    public int getUpc(){
        return upc;
    }

    /**
     * Method to get the Expiration date of the product
     * @return String of the exp date
     */
    public String getExpDate(){
        return expDate;
    }

    public String leadingZeroUPC(int upc){
        return String.format("%010d", upc);
    }

}
