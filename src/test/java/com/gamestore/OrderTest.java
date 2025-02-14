package com.gamestore;

import com.gamestore.models.Game;
import com.gamestore.models.Order;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    // Testing to see if the stock of items reduces when a purchase is made //
    @Test
    public void TestReduceStock() {
        Game game1 = new Game("1","Farming Simulator 25","RPG",79.99, 150);
        Game game2 = new Game("2", "NHL 25", "Sports", 89.99, 150);

        // adding games to the cart //
        Map<Game, Integer> cartItems = new HashMap<>();
        cartItems.put(game1, 2);
        cartItems.put(game2, 1);

        double totalPrice = (2 * game1.getPrice()) + (1 * game2.getPrice());

        Order order = new Order(cartItems, totalPrice);

        assertEquals(8, game1.getStock());
        assertEquals(4,game2.getStock());
    }
}
