package ua.lviv.iot.algo.part1.lab1;

import lombok.ToString;
import lombok.Setter;
import lombok.Getter;
@Getter
@Setter
@ToString(callSuper = true)

public class MobileGame extends Game{
    private int downloadSize;
    private int minAge;

    @Override
    int connectPlayer(int currentPlayers, int maxPlayers) {
        return 0;
    }

    @Override
    int disconnectPlayer(int currentPlayers, int minPlayers) {
        return 0;
    }

    public MobileGame(){}

    public MobileGame(String title, int minPlayers, int maxPlayers, int currentPlayers,
                        String gamePublisher, int yearOfRelease, int downloadSize, int minAge){
        this.title = title;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.currentPlayers = currentPlayers;
        this.gamePublisher = gamePublisher;
        this.yearOfRelease = yearOfRelease;
        this.downloadSize = downloadSize;
        this.minAge = minAge;
    }
}