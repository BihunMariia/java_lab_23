package ua.lviv.iot.algo.part1.lab1;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@Setter
@Getter

public class PlayStationGame extends Game{
    private String genre;
    private boolean offlinePlayAble;

    public PlayStationGame(){}

    public PlayStationGame(String title, int minPlayers, int maxPlayers, int currentPlayers,
                        String gamePublisher, int yearOfRelease, String genre, boolean offlinePlayAble ){
        this.title = title;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.currentPlayers = currentPlayers;
        this.gamePublisher = gamePublisher;
        this.yearOfRelease = yearOfRelease;
        this.genre = genre;
        this.offlinePlayAble = offlinePlayAble;

    }
    @Override
    int connectPlayer(int currentPlayers, int maxPlayers) {
        return 0;
    }

    @Override
    int disconnectPlayer(int currentPlayers, int minPlayers) {
        return 0;
    }
}
