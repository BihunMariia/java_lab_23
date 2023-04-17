package ua.lviv.iot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MobileGameTest {

    @Test
    public void testConstructor() {
        MobileGame mobileGame = new MobileGame("Title", 1, 4, 0, "Publisher", 2021, 100, 12);
        assertEquals(1, mobileGame.getMinPlayers());
        assertEquals(4, mobileGame.getMaxPlayers());
        assertEquals(100, mobileGame.getDownloadSize());
        assertEquals(12, mobileGame.getMinAge());
    }
    @Test
    public void testConnectPlayer() {
        MobileGame mobileGame = new MobileGame();
        int currentPlayers = 2;
        int maxPlayers = 4;
        int connectedPlayers = mobileGame.connectPlayer(currentPlayers, maxPlayers);
        assertEquals(currentPlayers + 1, connectedPlayers);
    }

    @Test
    public void testDisconnectPlayer() {
        MobileGame mobileGame = new MobileGame();
        int currentPlayers = 3;
        int minPlayers = 1;
        int disconnectedPlayers = mobileGame.disconnectPlayer(currentPlayers, minPlayers);

        assertEquals(currentPlayers - 1, disconnectedPlayers);
    }

}
