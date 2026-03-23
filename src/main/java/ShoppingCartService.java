public class ShoppingCartService {
    private double totalCost = 0.0;

    public double addItem(double price, int quantity) {
        double itemTotal = price * quantity;
        totalCost += itemTotal;
        return itemTotal;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
