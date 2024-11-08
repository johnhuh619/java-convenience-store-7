package domain.models;

public class Promotion {
    private int requiredQuantity; // N개 구매 -> N+1
    private int freeQuantity; // N+1 의 1 개수
    private int promotionStock; // 프로모션 재고

    public Promotion(int requiredQuantity, int freeQuantity, int promotionStock) {
        this.requiredQuantity = requiredQuantity;
        this.freeQuantity = freeQuantity;
        this.promotionStock = promotionStock;
    }

    public boolean isApplicable(int quantity){
        return quantity >= requiredQuantity && promotionStock >= freeQuantity;
    }

    public int calculateToPromotionPrice(int price, int quantity){
        int applicablePromotions = quantity / requiredQuantity;
        int freeItems = Math.min(applicablePromotions*freeQuantity, promotionStock);
        int totalCost = (quantity - freeItems) * price;
        return totalCost;
    }
}
