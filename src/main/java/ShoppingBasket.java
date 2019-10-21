import java.util.ArrayList;
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
        return this.basketTotal;
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


        if (total > 20) {
            total -= (total * 0.1);
        }
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

    public double bOGOF(){
        double discount = 0;
        ArrayList offerItems = new ArrayList();
        for ( Product product : items){
            if (product.isBuyOneGetOneFree()){
                offerItems.add(product);
            }
        }
        for (Product product : offerItems){
            if (product.getQuantity() >=2 && product.getQuantity() / 2 == 0 ){
                discount = ((product.getQuantity() / 2) * product.getPrice());
                this.basketTotal -= discount;
            }
        }
        return this.basketTotal;
    }


}
