 package ua.lviv.iot;

import ua.lviv.iot.ComputerGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerGameTest {

    private ComputerGame computerGame;

    @BeforeEach
    public void setUp() {
        computerGame = new ComputerGame("Game Title", 2, 4, 0, "Publisher", 2021, "PC", 50, "50GB");
    }

    @Test
    public void testConnectPlayer() {
        int currentPlayers = 0;
        int maxPlayers = computerGame.getMaxPlayers();

        assertEquals(1, computerGame.connectPlayer(currentPlayers, maxPlayers));
    }

    @Test
    public void testConnectPlayerWithMaxPlayersReached() {
        int currentPlayers = computerGame.getMaxPlayers();
        int maxPlayers = computerGame.getMaxPlayers();

        assertEquals(currentPlayers, computerGame.connectPlayer(currentPlayers, maxPlayers));
    }

    @Test
    public void testDisconnectPlayer() {
        int currentPlayers = 0;
        int minPlayers = computerGame.getMinPlayers();

        assertEquals(0, computerGame.disconnectPlayer(currentPlayers, minPlayers));
    }

    @Test
    public void testDisconnectPlayerWithMinPlayersReached() {
        int currentPlayers = computerGame.getMinPlayers();
        int minPlayers = computerGame.getMinPlayers();

        assertEquals(currentPlayers, computerGame.disconnectPlayer(currentPlayers, minPlayers));
    }

}
