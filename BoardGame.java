package ua.lviv.iot;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;
@Getter
@Setter
@ToString(callSuper = true)

public class BoardGame extends Game {
    private static BoardGame defaultBoardGame = new BoardGame();

    public static BoardGame getInstance() {
        return defaultBoardGame;
    }

    public boolean canPlay(int currentPlayers, int minPlayers) {
        return currentPlayers >= minPlayers;
    }

    public BoardGame(){}

    public BoardGame(String title, int minPlayers, int maxPlayers, int currentPlayers,
                        String gamePublisher, int yearOfRelease){
        this.title = title;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.currentPlayers = currentPlayers;
        this.gamePublisher = gamePublisher;
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    int connectPlayer(int currentPlayers, int maxPlayers) {
        if (currentPlayers < maxPlayers) {
            currentPlayers += 1;
        }
        return currentPlayers;
    }

    @Override
    int disconnectPlayer(int currentPlayers, int minPlayers) {
        if (currentPlayers > minPlayers) {
            currentPlayers -= 1;
        }
        return currentPlayers;
    }
}

