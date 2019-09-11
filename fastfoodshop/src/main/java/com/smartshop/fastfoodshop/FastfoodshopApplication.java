package com.smartshop.fastfoodshop;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@SpringBootApplication
public class FastfoodshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastfoodshopApplication.class, args);
    }
    private static ArrayList<menu> shoppingCart = new ArrayList<>();
    CartDeliverySingleton cart = CartDeliverySingleton.getInstance();
    static String totalprice;


    public static void fileWriter() {
        try {
            FileWriter w = new FileWriter("totalprice.txt");
            w.write(totalprice);
            w.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @RequestMapping("/")
    String home(){
        return "Welcome to Fastfoodshop let's enjoy";
    }

    @RequestMapping("/menu")
    menu[] fastfoodMenuList(){
        return menufactory.getFastfoodMenu();
    }

    @RequestMapping("/menu/{id}")
    menu fastfoodMenu(@PathVariable int id) {
        return menufactory.getFastfoodMenuOne(id);
    }

    @RequestMapping("/menu/add/{id}")
    String addToCart(@PathVariable int id) {
        int count = cart.getCount();
        int price = cart.getPrice();
        shoppingCart.add(menufactory.getFastfoodMenuOne(id));
        price += shoppingCart.get(id).getPrice();
        count += 1;
        cart.setCount(count);
        cart.setPrice(price);
        totalprice = Integer.toString(cart.getPrice());
        fileWriter();

        return String.format("\"%s\" add you food to the cart", menufactory.getFastfoodMenuOne(id).getName());
    }

    @RequestMapping("/cart")
    ArrayList<menu> viewCart(){

        return FastfoodshopApplication.shoppingCart;
    }

    @RequestMapping("/bill")
    Object[] viewCartDeliver(){

//        return cart.getPrice();
        return new Object[]{cart.getPrice(), cart.getCount()};
    }
}
