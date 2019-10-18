public class Product {

    private String name;
    private double price;
    private boolean buyOneGetOneFree;

    public Product(String name, double price, boolean buyOneGetOneFree){
        this.name = name;
        this.price = price;
        this.buyOneGetOneFree = buyOneGetOneFree;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean isBuyOneGetOneFree() {
        return this.buyOneGetOneFree;
    }


}
