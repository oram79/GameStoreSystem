package com.gamestore;
import java.util.HashMap;
import java.util.Map;
import java.lang.StringBuilder;

public class Cart {
    private Map<Game, Integer> items = new HashMap<>();

    public Cart() {
        this.items = new HashMap<>();
    }

    // add a game to the cart //
    public boolean addGame(Game game, int quantity) {
        if (game != null && quantity > 0 && game.getStock() >= quantity) {
            items.put(game, items.getOrDefault(game, 0) + quantity);
            return true;
        }
        return false;
    }

    // Remove a game from the cart //
    public boolean removeGame(Game game, int quantity) {
        if (game != null && items.containsKey(game) && quantity > 0) {
            int currentQuantity = items.get(game);
            if (currentQuantity <= quantity) {
                items.remove(game);
            } else {
                items.put(game, currentQuantity - quantity);
            }
            return true;
        }
        return false;
    }

    // Adding total cost of items being bought //
    public double getTotalPrice() {
        return items.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    // Adding all the items to the cart //
    public Map<Game, Integer> getItems() {
        return new HashMap<>(items);
    }

    // Clearing items in the cart //
    public void clearCart() {
        items.clear();
    }

    @Override
    public String toString() {
        if (items.isEmpty()) {
            return "Cart Is Empty";
        }
        StringBuilder sb = new StringBuilder("Cart Items:\n");
        System.out.println("\n====================");
        for (Map.Entry<Game, Integer> entry : items.entrySet()) {
            sb.append(String.format("%s x%d - $%.2f%n", entry.getKey().getTitle(), entry.getValue(),
                    entry.getKey().getPrice() * entry.getValue()));
        }

        sb.append(String.format("Total: $%.2f",getTotalPrice()));
        return sb.toString();
    }
}
