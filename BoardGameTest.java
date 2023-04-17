package ua.lviv.iot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardGameTest {

    private BoardGame boardGame;

    @Test
    public void testGetInstance() {
        BoardGame instance1 = BoardGame.getInstance();
        BoardGame instance2 = BoardGame.getInstance();

        assertNotNull(instance1);
        assertNotNull(instance2);
        assertEquals(instance1, instance2);
    }
}