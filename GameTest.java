package ua.lviv.iot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setUp() {
        game = new GameImpl("Test Game", 2, 4, 0, "Test Publisher", 2021);
    }

    @Test
    public void testGetMaxPlayers() {
        assertEquals(4, game.getMaxPlayers(), "Should return the correct max players value");
    }

    @Test
    public void testGetMinPlayers() {
        assertEquals(2, game.getMinPlayers(), "Should return the correct min players value");
    }

    @Test
    public void testConnectPlayer() {
        int currentPlayers = 0;
        int maxPlayers = 4;
        int expected = 1;
        int result = game.connectPlayer(currentPlayers, maxPlayers);
        assertEquals(expected, result, "Should return the correct number of current players after connecting one player");
    }

    @Test
    public void testDisconnectPlayer() {
        int currentPlayers = 3;
        int minPlayers = 2;
        int expected = 2;
        int result = game.disconnectPlayer(currentPlayers, minPlayers);
        assertEquals(expected, result, "Should return the correct number of current players after disconnecting one player");
    }

    private static class GameImpl extends Game {
        public GameImpl(String title, int minPlayers, int maxPlayers, int currentPlayers, String gamePublisher, int yearOfRelease) {
            this.title = title;
            this.minPlayers = minPlayers;
            this.maxPlayers = maxPlayers;
            this.currentPlayers = currentPlayers;
            this.gamePublisher = gamePublisher;
            this.yearOfRelease = yearOfRelease;
        }

        @Override
        int connectPlayer(int currentPlayers, int maxPlayers) {
            return currentPlayers + 1;
        }

        @Override
        int disconnectPlayer(int currentPlayers, int minPlayers) {
            return currentPlayers - 1;
        }
    }
}
