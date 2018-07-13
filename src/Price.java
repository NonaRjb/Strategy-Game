public class Price {

    private int price;
    static final int basePrice = 10;
    static final int lowPrice = 10;
    static final int medPrice = 20;
    static final int highPrice = 30;
    static final int veryHighPrice = 40;



    // Constructor
    public Price(int price) {
        this.price = price;
    }

    // Getters
    public int getPrice() {
        return price;
    }

    // Other Methods
    public String decreasePrice(Price dPrice) {
        if (this.price - dPrice.price >= 0) {
            this.price -= dPrice.price;
            return "Successfully Bought";
        } else {
            return "Not Enough Money";
        }
    }

    public void increasePrice(Price dPrice){
        this.price += dPrice.price;
    }

}
