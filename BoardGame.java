package ua.lviv.iot.algo.part1.lab1;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardGame {
    private String title;
    private int minPlayers;
    private int maxPlayers;
    private int currentPlayers;

    private static BoardGame defaultBoardGame = new BoardGame();

    public static BoardGame getInstance() {
        return defaultBoardGame;
    }

    public int addPlayer(int currentPlayers, int maxPlayers) {
        if (currentPlayers < maxPlayers) {
            currentPlayers += 1;
        }
        return currentPlayers;
    }

    public int removePlayer(int currentPlayers, int minPlayers) {
        if (currentPlayers > minPlayers) {
            currentPlayers -= 1;
        }
        return currentPlayers;
    }

    public boolean canPlay(int currentPlayers, int minPlayers) {
        return currentPlayers >= minPlayers;
    }

    public static void main(String[] args) {
        BoardGame[] boardgames = {
                new BoardGame(),
                new BoardGame("Monopolia", 3, 6, 4),
                BoardGame.getInstance(),
                BoardGame.getInstance()
        };

        for (BoardGame i: boardgames) {
            System.out.println(i);
        }
    }
}

