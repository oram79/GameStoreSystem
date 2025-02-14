package com.gamestore;

import com.gamestore.models.Game;
import com.gamestore.service.GameService;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GameServiceTest {
    @Test
    public void testAddAndRetrieveGames() {
        GameService gameService = new GameService();
        Game game = new Game("1", "Farming Simulator 25", "RPG", 79.99, 150);

        gameService.addGame(game);
        List<Game> games = gameService.getAllGames();

        assertEquals(1, games.size());
        assertEquals("Farming Simulator 25", games.get(0).getTitle());
    }
}
