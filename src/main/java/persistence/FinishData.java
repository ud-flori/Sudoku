package persistence;

import java.util.Date;

public class FinishData {

    String player;
    String map;
    int time;
    Date date;

    public FinishData(String player, String map, int time, Date date){
            this.player = player;
            this.map = map;
            this.time = time;
            this.date = date;
    }

    public String getPlayer() {
        return player;
    }

    public String getMap() {
        return map;
    }

    public int getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
