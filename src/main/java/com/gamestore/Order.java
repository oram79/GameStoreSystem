package com.gamestore;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class Order {
    private String orderId;
    private Map<Game, Integer> purchasedItems;
    private double totalPrice;
    private LocalDateTime orderDate;

    public Order(Map<Game, Integer> purchasedItems, double totalPrice) {
        this.orderId = UUID.randomUUID().toString();
        this.purchasedItems = purchasedItems;
        this.totalPrice = totalPrice;
        this.orderDate = LocalDateTime.now();
        processOrder();
    }

    // Reducing stock when a order is placed bu users //
    private void processOrder() {
        for (Map.Entry<Game, Integer> entry : purchasedItems.entrySet()) {
            Game game = entry.getKey();
            int quantity = entry.getValue();
            game.reduceStock(quantity);
        }
    }

    // Getters //
    public String getOrderId() {
        return orderId;
    }

    public Map<Game, Integer> getPurchasedItems() {
        return purchasedItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order Summary:\n");
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Order Date: ").append(orderDate).append("\n");
        sb.append("Items Purchased:\n");
        for (Map.Entry<Game, Integer> entry : purchasedItems.entrySet()) {
            sb.append(String.format("%s x%d - $%.2f%n", entry.getKey().getTitle(), entry.getValue(),
                    entry.getKey().getPrice() * entry.getValue()));
        }
        sb.append(String.format("Total Price: $%.2f", totalPrice));
        return sb.toString();
    }
}
