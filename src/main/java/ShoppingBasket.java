import java.util.HashMap;

public class ShoppingBasket {

    private boolean loyaltyCard;
    private HashMap<String, Double> items;
    private double basketTotal;

    public ShoppingBasket(boolean loyaltyCard){
        this.loyaltyCard = loyaltyCard;
        this.items = new HashMap<String, Double>();
        this.basketTotal = 0;
    }

    public boolean hasALoyaltyCard() {
        return this.loyaltyCard;
    }

    public HashMap<String, Double> getItems() {
        return this.items;
    }

    public double getBasketTotal() {
        return basketTotal;
    }

    public int countItems() {
        return this.items.size();
    }

    public void addItem(Product product) {
        this.items.put(product.getName(), product.getPrice());
        this.basketTotal += product.getPrice();
    }

    public double totalPrice() {
        double total = 0;
        if (hasALoyaltyCard()) {
            total = this.basketTotal - (basketTotal * 0.02);
            return total;
        } else {
            return this.basketTotal;
        }
    }

     public void removeItem(Product product) {
        this.items.remove(product.getName());
        this.basketTotal -= product.getPrice();
     }

    public void emptyItems() {
        this.items.clear();
        this.basketTotal = 0;
    }


}
