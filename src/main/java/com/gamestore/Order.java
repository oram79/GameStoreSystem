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


}
