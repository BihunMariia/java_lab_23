package ua.lviv.iot;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameWriterTest {
    public static final String RESULT_FILENAME = "result.csv";
    public static final String EXPECTED_FILENAME = "test.csv";
    private List<Game> gameList;
    private GameWriter gameWriter;
    private final File test = new File(EXPECTED_FILENAME);
    private File actualFile;

    @BeforeEach
    public void setUp() {
        gameList = new ArrayList<>();
        gameWriter = new GameWriter();
        gameList.add(new PlayStationGame("Horizon Forbidden West", 1, 1, 0,
                "Sony Interactive Entertainment", 2022, "action", false));
        gameList.add(new MobileGame("Call Of Duty", 1, 20, 4,
                "Activision Publishing", 2023, 500, 16));
        gameList.add(new ComputerGame("Counter-Strike", 1, 20, 5, "Valve Corporation",
                2012, "PC", 450, "15 GB"));
        gameList.add(new BoardGame("Monopolia", 2, 6,
                3, "Hasbro", 1935, 5));
        actualFile = new File(RESULT_FILENAME);
    }

    @Test
    public void writeToFileSuccess() throws IOException {
        gameWriter.writeToFile(gameList, RESULT_FILENAME);
        assertTrue(Files.exists(actualFile.toPath()));
        assertEquals(Files.readAllLines(test.toPath()),
                Files.readAllLines(actualFile.toPath()));
    }

    @Test
    public void writeToFileEmptyList() throws IOException {
        gameList = new ArrayList<>();
        gameWriter.writeToFile(gameList, RESULT_FILENAME);
        assertFalse(actualFile.exists());
    }

    @Test
    public void writeToFileExistingFile() throws IOException {
        Files.createFile(Path.of(RESULT_FILENAME));
        writeToFileSuccess();
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(RESULT_FILENAME));
    }
}