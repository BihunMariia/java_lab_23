package ua.lviv.iot;

import lombok.ToString;

@ToString

public abstract class Game {
    protected String title;
    protected int minPlayers;
    public int maxPlayers;
    protected int currentPlayers;
    protected String gamePublisher;
    protected int yearOfRelease;

    public String getHeaders(){
        return "title, maxPlayers, currentPlayers, gamePublisher, yearOfRelease";
    }

    public String toCSV(){
        return String.format("%s, %d, %d, %s, %d", title, maxPlayers, currentPlayers, gamePublisher, yearOfRelease);
    }

    abstract int connectPlayer(int currentPlayers, int maxPlayers);

    abstract int disconnectPlayer(int currentPlayers, int minPlayers);

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }


}
