package ua.lviv.iot;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GameWriter {
    public void writeToFile(List<Game> gameList, String fileName) throws  IOException{
        if (gameList == null || gameList.isEmpty()){
            return;
        }

        FileWriter writer = new FileWriter(fileName);
        Map<String, Boolean> headerMap = new HashMap<>();

        gameList.sort(new Comparator<Game>(){
            @Override
            public int compare(Game g1, Game g2){
                return g1.getClass().getSimpleName().compareTo(g2.getClass().getSimpleName());
            }
        });

        for (Game game: gameList){
            if (!headerMap.containsKey(game.getClass().getSimpleName())){
                writer.write(game.getHeaders() + "\n");
                headerMap.put(game.getClass().getSimpleName(), true);
            }
            writer.write(game.toCSV() + "\n");
        }
        writer.close();
    }

}