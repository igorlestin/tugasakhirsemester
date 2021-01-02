package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "activity")
public class Activity {
    @ColumnInfo(name = "wid")
    @PrimaryKey(autoGenerate = true)
    private long wid;

    @ColumnInfo(name = "log_activity_energy")
    private String act;

    @ColumnInfo(name = "log_date")
    private String date;

    @ColumnInfo(name = "log_time")
    private String time;

    public Activity(String act, String date, String time){
        this.act = act;
        this.date = date;
        this.time = time;
    }

    public long getWid() {
        return wid;
    }

    public void setWid(long wid) {
        this.wid = wid;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
