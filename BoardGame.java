package ua.lviv.iot;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;
@Getter
@Setter
@ToString(callSuper = true)

public class BoardGame extends Game {
    private int numberOfSteps;

    public String getHeaders(){
        return super.getHeaders() + "," + "numberOfSteps";
    }

    public String toCSV(){
        return  String.format("%s, %s",super.toCSV(), numberOfSteps);
    }
    private static BoardGame defaultBoardGame = new BoardGame();

    public static BoardGame getInstance() {
        return defaultBoardGame;
    }

    public boolean canPlay(int currentPlayers, int minPlayers) {
        return currentPlayers >= minPlayers;
    }

    public BoardGame(){}

    public BoardGame(String title, int minPlayers, int maxPlayers, int currentPlayers,
                        String gamePublisher, int yearOfRelease, int numberOfSteps){
        this.title = title;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.currentPlayers = currentPlayers;
        this.gamePublisher = gamePublisher;
        this.yearOfRelease = yearOfRelease;
        this.numberOfSteps = numberOfSteps;
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

