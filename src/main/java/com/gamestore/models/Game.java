package com.gamestore.models;
import java.util.Objects;


public class Game {
    private final String id;
    private final String title;
    private final String genre;
    private double price;
    private int stock;

    public Game(String id, String title, String genre, double price, int stock) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.stock = stock;
    }

    // Getters //

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    // Setters //

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }

    // Reducing stock when any games are purchased //
    public void reduceStock(int amount) {
        if (amount > 0 && stock >= amount) {
            stock -= amount;
        }
    }

    public void addStock(int amount) {
        if (amount > 0) {
            stock += amount;
        }
    }

    @Override
    public String toString() {
        return String.format("Game ID: '%s' - Title: '%s' - Genre: '%s' - Price: $%.2f - Stock: %d",
                id, title, genre, price, stock);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Game game = (Game) obj;
        return Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
