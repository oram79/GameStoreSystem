package com.gamestore.service;

import com.gamestore.models.Cart;
import com.gamestore.models.Game;
import com.gamestore.models.Order;

public class CartService {
    private Cart cart;

    public CartService() {
        this.cart = new Cart();
    }

    // adding a game to the cart //
    public boolean addToCart(Game game, int quantity) {
        if (game != null && quantity > 0 && game.getStock() >= quantity) {
            cart.addGame(game, quantity);
            return true;
        }
        return false;
    }

    // removing a game from your cart //
    public boolean removeFromCart(Game game, int quantity) {
        if (game != null && quantity > 0) {
            return cart.removeGame(game, quantity);
        }
        return false;
    }

    // view the cart //
    public String viewCart() {
        return cart.toString();
    }

    // Checkout and submit order
    public Order checkout() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Cart is empty. Cannot proceed with checkout.");
            return null;
        }

        Order order = new Order(cart.getItems(), cart.getTotalPrice());
        cart.clearCart();
        return order;
    }
}
