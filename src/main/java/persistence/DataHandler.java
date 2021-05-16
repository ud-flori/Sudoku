package persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * This class give interface between Java and JSON files.
 */
public class DataHandler {

    ObjectMapper handler;

    /**
     * The constructor which creates Jackson object mapper.
     */
    public DataHandler(){
        this.handler = new ObjectMapper();
    }

    /**
     * Set the data to an object and export to JSON file.
     * @param player The player name.
     * @param map The chosen map.
     * @param time The elapsed time.
     * @throws IOException Exception for file handling
     */
    public void setData(String player, String map, String time) throws IOException {

        new File("assets").mkdir();

        Date date = new Date();
        System.out.println(time);
        FinishData result = new FinishData(player,map,time,date);
        handler.writeValue(new File(("assets/" + player + System.currentTimeMillis() + ".json")), result);

    }

    /**
     * Gets the JSON data files.
     * @return List with data Objects.
     * @throws IOException Exception for file handling.
     */
    public List<FinishData> getData() throws IOException {

        new File("assets").mkdir();
        File actual;
        List<FinishData> list = new ArrayList<>();

            actual = new File("assets/");
            for( File f : Objects.requireNonNull(actual.listFiles())) {
                if(f.getName().matches(".+\\.json$")) {
                    list.add(handler.readValue(new File(String.valueOf(f)), FinishData.class));
                }
            }

        return list;

    }

}
