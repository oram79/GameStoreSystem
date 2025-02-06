package com.gamestore;

import com.gamestore.Game;
import com.gamestore.Order;
import com.gamestore.CartService;
import com.gamestore.GameService;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameService gameService = new GameService();
        CartService cartService = new CartService();

        // sample games //
        gameService.addGame(new Game("1", "Farming Simulator 25", "RPG", 79.99, 150));
        gameService.addGame(new Game("2", "NHL 25", "Sport", 89.99, 150));
        gameService.addGame(new Game("3", "Hogwarts Legacy", "Fantasy", 89.99, 200));

        while (true) {
            System.out.println("\n=== Game Store System ===");
            System.out.println("1. Games For Sale");
            System.out.println("2. Search For A Game");
            System.out.println("3. Add Game To Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Remove Game From Cart");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(gameService);
                    break;

                case 2:
                    System.out.print("Enter Game title To Search: ");
                    String searchTitle = scanner.nextLine();
                    Optional<Game> foundGame = gameService.searchGameByTitle(searchTitle);
                    if (foundGame.isPresent()) {
                        System.out.println("Game Found: " + foundGame.get());
                    } else {
                        System.out.println("Game not Found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Game Title To Add To Cart: ");
                    String addTitle = scanner.nextLine();
                    foundGame = gameService.searchGameByTitle(addTitle);
                    if (foundGame.isPresent()) {
                        System.out.print("Enter Quantity: ");
                        int quantity = scanner.nextInt();
                        if (cartService.addToCart(foundGame.get(), quantity)) {
                            System.out.println("Game Added To Cart.");
                        } else {
                            System.out.println("Not Enough Stock Available.");
                        }
                    } else {
                        System.out.println("Game Not Found.");
                    }
                    break;

                case 4:
                    System.out.println(cartService.viewCart());
                    break;

                case 5:
                    System.out.print("Enter Game Title To Remove From Cart: ");
                    String removeTitle = scanner.nextLine();
                    foundGame = gameService.searchGameByTitle(removeTitle);
                    if (foundGame.isPresent()) {
                        System.out.print("Enter Quantity To Remove: ");
                        int quantity = scanner.nextInt();
                        if (cartService.removeFromCart(foundGame.get(), quantity)) {
                            System.out.println("Game Removed From Cart.");
                        } else {
                            System.out.println("Game Not Found In Cart.");
                        }
                    } else {
                        System.out.println("Game Not Found.");
                    }
                    break;

                case 6:
                    Order order = cartService.checkout();
                    if (order != null) {
                        System.out.println(order);
                    }
                    break;

                case 7:
                    System.out.println("Thanks For Shopping With Us, We Hope To See You Again");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Option. Try Again.");
            }
        }
    }
}
