package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity.Event;

@Dao
public interface EventDao {
    @Insert
    public void insert(Event... reminders);

    @Update
    public void update(Event... reminders);

    @Delete
    public void delete(Event reminders);

    @Query("Select * from table_event Limit 1")
    public Event getRecentEnteredData();

    @Query("Select * from table_event")
    public List<Event> getAll();

    @Query("DELETE FROM table_event")
    public void deleteAllEvents();
}
