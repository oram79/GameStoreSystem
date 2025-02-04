package com.gamestore;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Game, Integer> items;

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
}
