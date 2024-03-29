package ua.lviv.iot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    private final List<Game> gameList = new ArrayList<Game>();

    public void addGame(Game game) {
        this.gameList.add(game);
    }

    public List<Game> findGamesWithMoreThanFiveMaxPlayers() {
        return gameList.stream()
                .filter(game -> game.getMaxPlayers() > 5)
                .collect(Collectors.toList());
    }

    public static void someMethod() {

    }

    public List<Game> findGamesWithMinPlayersEqualsTwo() {
        return gameList.stream()
                .filter(game -> game.getMinPlayers() == 2)
                .collect(Collectors.toList());
    }
    public static void main(String[] args) throws IOException {
        GameWriter gameWriter = new GameWriter();
        GameManager gameManager = new GameManager();

        gameManager.addGame(new BoardGame("Monopolia", 2, 6,
                3, "Hasbro", 1935, 5));
        gameManager.addGame(new BoardGame("Chess", 2, 2,
                1, "Hasbro", 1935, 100));
        gameManager.addGame(new ComputerGame("Counter-Strike", 1, 20, 5, "Valve Corporation",
                2012, "PC", 450, "15 GB"));
        gameManager.addGame(new MobileGame("Call Of Duty", 1, 20, 4,
                "Activision Publishing", 2023, 500, 16));
        gameManager.addGame(new PlayStationGame("Horizon Forbidden West", 1, 1, 0,
                "Sony Interactive Entertainment", 2022, "action", false));

        System.out.println("Games:");

        gameManager.gameList.forEach(System.out::println);

        System.out.println("\n Games with more than five max players: \n");

        gameWriter.writeToFile(gameManager.gameList, "test.csv");

        System.out.println(gameManager.findGamesWithMoreThanFiveMaxPlayers());

        System.out.println("\n Games with min players equals two: \n");

        System.out.println(gameManager.findGamesWithMinPlayersEqualsTwo());
    }

    public List<Game> getGameList() {
        return gameList;
    }
}
