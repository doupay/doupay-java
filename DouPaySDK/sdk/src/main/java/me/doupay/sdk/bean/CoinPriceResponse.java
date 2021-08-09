package me.doupay.sdk.bean;

public class CoinPriceResponse {


    /**
     * price : 6.45
     */

    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CoinPriceResponse{" +
                "price='" + price + '\'' +
                '}';
    }
}
