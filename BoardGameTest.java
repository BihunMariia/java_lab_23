package ua.lviv.iot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardGameTest {

    private BoardGame boardGame;

    @BeforeEach
    public void setUp() {
        boardGame = new BoardGame();
    }

    @Test
    public void testGetInstance() {
        BoardGame instance1 = BoardGame.getInstance();
        BoardGame instance2 = BoardGame.getInstance();

        assertNotNull(instance1);
        assertNotNull(instance2);
        assertEquals(instance1, instance2);
    }

    @Test
    public void testCanPlay() {
        int currentPlayers = 3;
        int minPlayers = 2;
        boolean result = boardGame.canPlay(currentPlayers, minPlayers);

        assertTrue(result);
    }

    @Test
    public void testConnectPlayer() {
        int currentPlayers = 3;
        int maxPlayers = 4;
        int result = boardGame.connectPlayer(currentPlayers, maxPlayers);

        assertEquals(4, result);
    }

    @Test
    public void testDisconnectPlayer() {
        int currentPlayers = 3;
        int minPlayers = 2;
        int result = boardGame.disconnectPlayer(currentPlayers, minPlayers);

        assertEquals(2, result);
    }
}
