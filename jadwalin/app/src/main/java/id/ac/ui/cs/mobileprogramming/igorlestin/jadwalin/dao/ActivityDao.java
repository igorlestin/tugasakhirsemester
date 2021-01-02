package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity.Activity;


@Dao
public interface ActivityDao {
    @Insert
    public long addLog(Activity consumption);

    @Update
    public void updateLog(Activity consumption);

    @Delete
    public void deleteLog(Activity consumption);

    @Query("SELECT * FROM activity where wid == :wid")
    public Activity getLog(long wid);

    @Query("SELECT * FROM activity ORDER BY wid ASC")
    public LiveData<List<Activity>> getAllLog();

    @Query("SELECT SUM(log_activity_energy) as total FROM Activity")
    public LiveData<Integer> totalConsumption();
}
