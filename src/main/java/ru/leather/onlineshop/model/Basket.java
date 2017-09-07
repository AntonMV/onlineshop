package ru.leather.onlineshop.model;

public class Basket {

    private Integer productId;

    private String productName;

    private Integer productQuantity;

    private Double productPrice;

    public Basket(Integer productId, String productName, Integer productQuantity, Double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
