package ua.lviv.iot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayStationGameTest {
    private PlayStationGame game;

    @BeforeEach
    public void setUp() {
        game = new PlayStationGame("Test Game", 2, 4, 0, "Test Publisher", 2021, "Test Genre", true);
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

    @Test
    public void testGetGenre() {
        String expected = "Test Genre";
        String result = game.getGenre();
        assertEquals(expected, result, "Should return the correct genre");
    }

    @Test
    public void testIsOfflinePlayable() {
        boolean expected = true;
        boolean result = game.isOfflinePlayAble();
        assertEquals(expected, result, "Should return the correct offlinePlayAble value");
    }
}

