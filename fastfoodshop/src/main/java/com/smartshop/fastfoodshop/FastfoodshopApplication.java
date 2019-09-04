package com.smartshop.fastfoodshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class FastfoodshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastfoodshopApplication.class, args);
    }
    private static ArrayList<menu> shoppingCart = new ArrayList<>();

    @RequestMapping("/")
    String home(){
        return "Welcome to my shop let's enjoy";
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
        shoppingCart.add(menufactory.getFastfoodMenuOne(id));
        return String.format("\"%s\" add you food to the cart", menufactory.getFastfoodMenuOne(id).getName());
    }

    @RequestMapping("/cart")
    ArrayList<menu> viewCart(){
        return FastfoodshopApplication.shoppingCart;
    }
}
