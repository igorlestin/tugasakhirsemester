package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.dao.UserDao;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.database.ActivityDatabase;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity.User;

public class UserRepository {
    private UserDao profileDao;
    private LiveData<List<User>> mAllUsers;
    public UserRepository(Application application) {
        ActivityDatabase db = ActivityDatabase.getDatabase(application);
        profileDao = db.getUserDao();
        mAllUsers = profileDao.getAllUsers();
    }

    public LiveData<List<User>> getmAllUsers() {
        return mAllUsers;
    }

    public void addUser(User u) {

        new InsertUserAsyncTask(profileDao).execute(u);
    }

    public void updateUser(User u) {

        new UpdateUserAsyncTask(profileDao).execute(u);
    }

    public void deleteUser(User u) {

        new DeleteUserAsyncTask(profileDao).execute(u);
    }

    public void deleteAllUsers() {
        new DeleteAllUsersAsyncTask(profileDao).execute();
    }

    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao userDao;

        InsertUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... params) {
            userDao.addUser(params[0]);
            return null;
        }

    }

    private static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao userDao;

        UpdateUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... params) {
            userDao.updateUser(params[0]);
            return null;
        }

    }

    private static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao userDao;

        DeleteUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... params) {
            userDao.deleteUser(params[0]);
            return null;
        }

    }
    private static class DeleteAllUsersAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDao userDao;
        DeleteAllUsersAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            userDao.deleteAllUsers();
            return null;
        }
    }
}
