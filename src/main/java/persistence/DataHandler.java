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

/**
 * This class give interface between Java and JSON files.
 */
public class DataHandler {

    ObjectMapper handler;

    /**
     * The constructor which creates Jackson objectmapper.
     */
    public DataHandler(){
        this.handler = new ObjectMapper();
    }

    /**
     * Set the data to an object and export to JSON file.
     * @param player
     * @param map
     * @param time
     * @throws IOException
     */
    public void setData(String player, String map, String time) throws IOException {

        new File("assets").mkdir();

        Date date = new Date();
        System.out.println(time);
        FinishData result = new FinishData(player,map,time,date);
        handler.writeValue(new File(("assets/" + player + System.currentTimeMillis() + ".json")), result);

    }

    /**
     * Return List with Data objects.
     * @return List
     * @throws IOException
     */
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
