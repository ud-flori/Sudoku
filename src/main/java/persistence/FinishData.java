package persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * Java object to format JSON file.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinishData {

    String player;
    String map;
    String time;
    Date date;

}
