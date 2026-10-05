package com.substring.agent.backend.tools;

import java.util.Map;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class OrderTools {

    // fake data :
    private final Map<String, String> orders = Map.of(
            "1042", "Shipped - arriving tomorrow",
            "1043", "Processing - not yet shipped",
            "1044", "Cancelled - out of stock",
            "1045", "Shipped - arriving next week"
    );

    @Tool(description = "Get the status of an customer order by its  order ID")
    public String getOrderStatus(String orderId) {
        System.out.println("calling getOrderStatus Tool");
        System.out.println("Fetching order status for order ID: " + orderId);
        return orders.getOrDefault(orderId, "Order not found");
    }

    @Tool(description = "Cancel a customer order by its order ID")
    public String cancelOrder(String orderId) {
        System.out.println("calling cancelOrder Tool");
        System.out.println("Attempting to cancel order with ID: " + orderId);
        if (orders.containsKey(orderId)) {
            return "Order " + orderId + " has been cancelled.";
        } else {
            return "Order not found";
        }
    }

    @Tool(description = "Get the total count of customer orders")
    public Integer getOrderCount() {
        System.out.println("calling getOrderCount Tool");
        return orders.size();
    }

    // order tools create kar sakte ho.
    // database queries kar sakte ho.

}
