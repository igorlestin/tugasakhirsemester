package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.dao.EventDao;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.dao.UserDao;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.dao.ActivityDao;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity.Event;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity.Activity;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity.User;

@Database(entities = {Activity.class, User.class, Event.class}, version = 4, exportSchema = false)
public abstract class ActivityDatabase extends RoomDatabase {
    public abstract ActivityDao getLogDAO();
    public abstract UserDao getUserDao();
    public abstract EventDao getEventDao();
    private static ActivityDatabase INSTANCE;

    public static ActivityDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ActivityDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ActivityDatabase.class, "waterConsumption_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onCreate (@NonNull SupportSQLiteDatabase db){
                    super.onCreate(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private ActivityDao mDao;
        private UserDao userDao;
        private EventDao eDao;
        PopulateDbAsync(ActivityDatabase db) {
            mDao = db.getLogDAO();
            userDao = db.getUserDao();
            eDao = db.getEventDao();

        }


        @Override
        protected Void doInBackground(Void... voids) {

            User init_user = new User("Your Name", "umur 19", 0, 0);
            userDao.addUser(init_user);

            Activity log = new Activity("text", "20/10/2020", "9:00");
            mDao.addLog(log);
            mDao.addLog(new Activity("text", "20/10/2020", "9:10"));
            return null;
        }
    }
}