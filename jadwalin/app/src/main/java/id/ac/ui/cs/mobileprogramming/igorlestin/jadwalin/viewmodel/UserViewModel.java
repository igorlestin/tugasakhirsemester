package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity.User;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.repositories.UserRepository;

public class UserViewModel extends AndroidViewModel {

    private UserRepository uRepository;
    private LiveData<List<User>> mAllUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        uRepository = new UserRepository(application);
        mAllUsers = uRepository.getmAllUsers();
    }

    public LiveData<List<User>> getmAllUsers() {
        return mAllUsers;
    }

    public void addUser(User u) {
        uRepository.addUser(u);
    }

    public void updateUser(User u) {
        uRepository.updateUser(u);
    }

    public void deleteUser(User u) {
        uRepository.deleteUser(u);
    }

    public void deleteAllUsers() {
        uRepository.deleteAllUsers();
    }

}