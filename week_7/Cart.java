public class Cart {
    private final String id;
    private static final int MAX_ITEMS = 100; // Assumed maximum
    private double[] prices;
    private int itemCount;

    public Cart(String id, int maxItems) {
        this.id = id;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (price < 0 || itemCount >= prices.length) {
            return; // Ignore negative prices or if array is full
        }
        prices[itemCount] = price;
        itemCount++;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return id;
    }

    // No getter for prices array - it's private and cannot be accessed directly
}
