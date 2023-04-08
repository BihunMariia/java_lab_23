package ua.lviv.iot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameManagerTest {
    private GameManager gameManager = new GameManager();
    private BoardGame boardGame = new BoardGame("Monopolia", 2, 6, 3, "Hasbro", 1935);;
    private ComputerGame computerGame  = new ComputerGame("Counter-Strike", 1, 20, 5, "Valve Corporation", 2012, "PC", 450, "15 GB");;
    private MobileGame mobileGame = new MobileGame("Call Of Duty", 1, 20, 4, "Activision Publishing", 2023, 500, 16);

    private PlayStationGame playStationGame = new PlayStationGame("Horizon Forbidden West", 1, 1, 0, "Sony Interactive Entertainment", 2022, "action", false);



    @Test
    public void testAddGame() {
        gameManager.addGame(boardGame);
        gameManager.addGame(computerGame);
        gameManager.addGame(mobileGame);
        gameManager.addGame(playStationGame);

        List<Game> expectedGameList = new ArrayList<>();
        expectedGameList.add(boardGame);
        expectedGameList.add(computerGame);
        expectedGameList.add(mobileGame);
        expectedGameList.add(playStationGame);

        List<Game> resultGameList = gameManager.getGameList();
        assertEquals(expectedGameList, resultGameList, "Should add games to gameList");
    }

    @Test
    public void testFindGamesWithMoreThanFiveMaxPlayers() {
        gameManager.addGame(boardGame);
        gameManager.addGame(computerGame);
        gameManager.addGame(mobileGame);
        gameManager.addGame(playStationGame);

        List<Game> expectedGames = new ArrayList<>();
        expectedGames.add(boardGame);
        expectedGames.add(computerGame);
        expectedGames.add(mobileGame);
        expectedGames.add(playStationGame);

        List<Game> resultGames = gameManager.findGamesWithMoreThanFiveMaxPlayers();
        assertEquals(3, resultGames.size(), "Should find games with maxPlayers more than five");
    }

    @Test
    public void testFindGamesWithMinPlayersEqualsTwo() {
        gameManager.addGame(boardGame);
        gameManager.addGame(computerGame);
        gameManager.addGame(mobileGame);
        gameManager.addGame(playStationGame);

        List<Game> expectedGames = new ArrayList<>();
        expectedGames.add(boardGame);
        expectedGames.add(computerGame);
        expectedGames.add(mobileGame);
        expectedGames.add(playStationGame);
        List<Game> resultGames = gameManager.findGamesWithMinPlayersEqualsTwo();
        assertEquals(1, resultGames.size(), "Should find games with minPlayers equals two");
    }
}

