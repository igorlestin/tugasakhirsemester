package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.dao.ActivityDao;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.database.ActivityDatabase;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity.Activity;

public class WaterConsumptionRepository {

    private ActivityDao mLogDao;
    private LiveData<List<Activity>> mAllLog;
    private LiveData<Integer> mTotal;

    public WaterConsumptionRepository(Application application) {
        ActivityDatabase db = ActivityDatabase.getDatabase(application);
        mLogDao = db.getLogDAO();
        mAllLog = mLogDao.getAllLog();
        mTotal = mLogDao.totalConsumption();
    }

    public LiveData<List<Activity>> getAllLog() {
        return mAllLog;
    }

    public LiveData<Integer> getTotal() {
        return mTotal;
    }

    public void addLog(Activity log) {

        new InsertLogAsyncTask(mLogDao).execute(log);
    }

    public void updateLog(Activity log) {

        new UpdateLogAsyncTask(mLogDao).execute(log);
    }

    public void deleteLog(Activity log) {

        new DeleteLogAsyncTask(mLogDao).execute(log);
    }

    private static class InsertLogAsyncTask extends AsyncTask<Activity, Void, Void> {

        private ActivityDao mAsyncTaskDao;

        InsertLogAsyncTask(ActivityDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Activity... params) {
            mAsyncTaskDao.addLog(params[0]);
            return null;
        }

    }

    private static class UpdateLogAsyncTask extends AsyncTask<Activity, Void, Void> {

        private ActivityDao mAsyncTaskDao;

        UpdateLogAsyncTask(ActivityDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Activity... params) {
            mAsyncTaskDao.updateLog(params[0]);
            return null;
        }

    }

    private static class DeleteLogAsyncTask extends AsyncTask<Activity, Void, Void> {

        private ActivityDao mAsyncTaskDao;

        DeleteLogAsyncTask(ActivityDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Activity... params) {
            mAsyncTaskDao.deleteLog(params[0]);
            return null;
        }

    }

}
