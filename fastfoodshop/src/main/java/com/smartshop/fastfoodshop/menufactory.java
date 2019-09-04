package com.smartshop.fastfoodshop;

public class menufactory {
    public static final menu[] FASTFOOD_MENU = new menu[]{
      new menu(1,"fish_burger", "main course", 89),
            new menu(2, "cheese_burger", "main course", 89),
            new menu(3, "seafood_pizza", "main course", 349),
            new menu(4, "pepperoni_pizza", "main course", 349),
            new menu(5, "cheese_burger", "main course", 89),
            new menu(6, "french fries", "orderf", 59),
            new menu(7, "onion ling", "orderf", 59)
    };
    public static menu[] getFastfoodMenu(){
        return FASTFOOD_MENU;
    }
    public static menu getFastfoodMenuOne(int id){
        return FASTFOOD_MENU[id];
    }
}
