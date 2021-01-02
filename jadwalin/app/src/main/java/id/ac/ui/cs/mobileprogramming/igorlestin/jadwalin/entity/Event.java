package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_event")
public class Event {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;

    @ColumnInfo(name = "eMessage")
    String message;

    @ColumnInfo(name = "eRemindDate")
    String remindDate;

    @ColumnInfo(name = "eRemindTime")
    String remindTime;

    public int getEventId() {
        return id;
    }

    public void setEventId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(String remindDate) {
        this.remindDate = remindDate;
    }

    public String getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(String remindTime) {
        this.remindTime = remindTime;
    }
}
