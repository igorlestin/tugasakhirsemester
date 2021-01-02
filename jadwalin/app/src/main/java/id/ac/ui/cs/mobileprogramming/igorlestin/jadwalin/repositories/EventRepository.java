package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.repositories;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.dao.EventDao;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.database.ActivityDatabase;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity.Event;

public class EventRepository {
    private EventDao eventDao;
    private List<Event> allEvents;
    public EventRepository(Application application) {
        ActivityDatabase db = ActivityDatabase.getDatabase(application);
        eventDao = db.getEventDao();
        allEvents = eventDao.getAll();
    }

    public List<Event> getAllEvents() {
        return allEvents;
    }

    public void addEvent(Event e) {

        new EventRepository.InsertEventAsyncTask(eventDao).execute(e);
    }

    public void updateEvent(Event e) {

        new EventRepository.UpdateEventAsyncTask(eventDao).execute(e);
    }

    public void deleteEvent(Event e) {

        new EventRepository.DeleteEventAsyncTask(eventDao).execute(e);
    }

    public void deleteAllEvents() {
        new EventRepository.DeleteAllEventsAsyncTask(eventDao).execute();
    }

    private static class InsertEventAsyncTask extends AsyncTask<Event, Void, Void> {

        private EventDao eventDao;

        InsertEventAsyncTask(EventDao eventDao) {
            this.eventDao = eventDao;
        }

        @Override
        protected Void doInBackground(Event... params) {
            eventDao.insert(params[0]);
            return null;
        }

    }

    private static class UpdateEventAsyncTask extends AsyncTask<Event, Void, Void> {

        private EventDao eventDao;

        UpdateEventAsyncTask(EventDao eventDao) {
            this.eventDao = eventDao;
        }

        @Override
        protected Void doInBackground(Event... params) {
            eventDao.update(params[0]);
            return null;
        }

    }

    private static class DeleteEventAsyncTask extends AsyncTask<Event, Void, Void> {

        private EventDao eventDao;

        DeleteEventAsyncTask(EventDao eventDao) {
            this.eventDao = eventDao;
        }

        @Override
        protected Void doInBackground(Event... params) {
            eventDao.delete(params[0]);
            return null;
        }

    }
    private static class DeleteAllEventsAsyncTask extends AsyncTask<Void, Void, Void> {
        private EventDao eventDao;
        DeleteAllEventsAsyncTask(EventDao eventDao) {
            this.eventDao = eventDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            eventDao.deleteAllEvents();
            return null;
        }
    }
}
