package com.gamestore.service;

import com.gamestore.models.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameService {
    private List<Game> games;

    public GameService() {
        this.games = new ArrayList<>();
    }

    // adding a game to the store //
    public void addGame(Game game) {
        if (game != null) {
            games.add(game);
        }
    }

    // viewing all the games that are for sale //
    public List<Game> getAllGames() {
        return new ArrayList<>(games);
    }

    // searching for a game by the name //
    public Optional<Game> searchGameByTitle(String title) {
        return games.stream()
                .filter(game -> game.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    // update the stock for a specific game //
    public boolean updateStock(String gameId, int newStock) {
        for (Game game : games) {
            if (game.getId().equals(gameId) && newStock >= 0) {
                game.setStock(newStock);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (games.isEmpty()) {
            return "No Games For Sale.";
        }
        StringBuilder sb = new StringBuilder("Games For Sale:\n");
        for (Game game : games) {
            sb.append(game).append("\n");
        }
        return sb.toString();
    }
}
