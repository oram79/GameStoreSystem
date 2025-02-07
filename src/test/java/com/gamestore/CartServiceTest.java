package com.gamestore;

import com.gamestore.Game;
import com.gamestore.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTest {
    @Test
    public void testAddToCart() {
        CartService cartService = new CartService();
        Game game = new Game("1", "NHL 25", "Sport", 89.99, 10);

        boolean added = cartService.addToCart(game, 2);

        assertTrue(added);
        assertEquals(2, cartService.getCart().getItems().get(game).intValue());
    }


}
