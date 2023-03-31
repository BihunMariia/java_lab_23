package ua.lviv.iot.algo.part1.lab1;

import lombok.ToString;
@ToString

public abstract class Game{
    protected String title;
    protected int minPlayers;
    public int maxPlayers;
    protected int currentPlayers;
    protected String gamePublisher;
    protected int yearOfRelease;

    abstract int connectPlayer(int currentPlayers, int maxPlayers);

    abstract int disconnectPlayer(int currentPlayers, int minPlayers);

    public int getMaxPlayers(){
        return maxPlayers;
    }

    public int getMinPlayers(){
        return minPlayers;
    }


}
