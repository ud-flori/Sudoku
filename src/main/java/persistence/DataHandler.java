package persistence;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class DataHandler {

    ObjectMapper handler;

    public DataHandler(){
        this.handler = new ObjectMapper();
    }

    public void setData(String player, String map, int time) throws IOException {
        Date date = new Date();
        FinishData result = new FinishData(player,map,time,date);
        handler.writeValue(new FileWriter(String.valueOf("src/main/java/persistence/"+player + "_" + map + ".json")), result);

    }

    public void getData(){

    }

}
