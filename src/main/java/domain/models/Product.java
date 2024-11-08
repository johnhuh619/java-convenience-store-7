package domain.models;

public class Product {
    private String name;
    private int price;
    private int stockQuantity;
    private Promotion promotion;


    public Product(String name, int price, int stockQuantity, Promotion promotion) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.promotion = promotion;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void reduceStock(int quantity){
        if(quantity > stockQuantity){
            throw new IllegalArgumentException("[ERROR] 재고가 부족하여 구매가 불가합니다.");
        }
        this.stockQuantity -= quantity;
    }

    public boolean hasPromotion(){
        return promotion != null;
    }

}
