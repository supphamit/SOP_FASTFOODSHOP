package com.smartshop.fastfoodshop;

public class menu {
    private int id;
    private String name;
    private String type;
    private int    price;
    public menu(int id, String name, String type, int price){
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.type = name;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String name) {
        this.name = type;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

}
