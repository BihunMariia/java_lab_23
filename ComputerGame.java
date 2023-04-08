package ua.lviv.iot;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class ComputerGame extends Game {
    private String platform;
    private int price;
    private String occupiedSpaceOnTheDisk;

    public ComputerGame(){}

    public ComputerGame(String title, int minPlayers, int maxPlayers, int currentPlayers,
                        String gamePublisher, int yearOfRelease, String platform, int price,String occupiedSpaceOnTheDisk){
        this.title = title;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.currentPlayers = currentPlayers;
        this.gamePublisher = gamePublisher;
        this.yearOfRelease = yearOfRelease;
        this.platform = platform;
        this.price = price;
        this.occupiedSpaceOnTheDisk = occupiedSpaceOnTheDisk;
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
