package webshop;

public class Product {

    private long id;
    private String productName;
    private int price;
    private int stock;

    public Product(long id, String productName, int price, int stock) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public long getId() {
        return this.id;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getPrice() {
        return this.price;
    }

    public int getStock() {
        return this.stock;
    }
}