package persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import sudoku.SudokuMap;

import java.io.DataOutput;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class DataHandler {

    ObjectMapper handler;

    public DataHandler(){
        this.handler = new ObjectMapper();
    }

    public void setData(String player, String map, String time) throws IOException {

        new File("assets").mkdir();

        Date date = new Date();
        System.out.println(time);
        FinishData result = new FinishData(player,map,time,date);
        handler.writeValue(new File(("assets/" + player + System.currentTimeMillis() + ".json")), result);

    }

    public List<FinishData> getData() throws IOException {

        new File("assets").mkdir();
        File actual;
        List<FinishData> list = new ArrayList<>();

            actual = new File("assets/");
            for( File f : actual.listFiles()) {
                if(f.getName().matches(".+\\.json$")) {
                    list.add(handler.readValue(new File(String.valueOf(f)), FinishData.class));
                }
            }

        return list;

    }

}
