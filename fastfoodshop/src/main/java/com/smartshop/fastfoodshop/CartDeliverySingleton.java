package com.smartshop.fastfoodshop;

public class CartDeliverySingleton {
    private static CartDeliverySingleton instance;
    private int count;


    private int price;
    private CartDeliverySingleton() {

    }

    public static CartDeliverySingleton getInstance() {
        if (instance == null) {
            instance = new CartDeliverySingleton();
        }
        return instance;
    }
    public void delivery() {

    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
