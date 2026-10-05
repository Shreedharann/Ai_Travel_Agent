package com.substring.agent.backend.tools;

import java.util.Map;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class InventoryTools {
    


    // dummy data
    private final Map<String, Integer> stock = Map.of(
        "Bluetooth Headphones", 5,
        "Wireless Mouse", 42,
        "USB-C Cable", 0,
        "Laptop Stand", 12,
        "External Hard Drive", 7,
        "Smartphone Case", 0,
        "Portable Charger", 15,
        "Gaming Keyboard", 3,
        "Webcam", 8,
        "Noise-Cancelling Earbuds", 0
    );


    @Tool(description = "Check the stock availability of a product by its name")
    public String checkStock(String productName) {
        System.out.println("calling checkStock Tool");
        System.out.println("Checking stock for product: " + productName);
        Integer quantity = stock.get(productName);
        if (quantity == null) {
            return "Product not found";
        } else if (quantity > 0) {
            return "In Stock: " + quantity + " units available";
        } else {
            return "Out of Stock";
        }
    }

    @Tool(description = "Get the total count of products in stock")
    public Integer getTotalProductsInStock() {
        System.out.println("calling getTotalProductsInStock Tool");
        return stock.size();
    }

    // tools to get all products
    @Tool(description = "Get a list of all products in stock")
    public java.util.List<String> getAllProductsInStock() {
        System.out.println("calling getAllProductsInStock Tool");
        return stock.keySet().stream().filter(name -> stock.get(name) > 0).collect(java.util.stream.Collectors.toList());
    }


}
