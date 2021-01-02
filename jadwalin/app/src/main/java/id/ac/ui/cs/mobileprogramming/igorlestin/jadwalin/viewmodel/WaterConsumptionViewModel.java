package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity.Activity;
import id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.repositories.WaterConsumptionRepository;

public class WaterConsumptionViewModel extends AndroidViewModel {

    private WaterConsumptionRepository mRepository;

    private LiveData<List<Activity>> mAllLog;

    private LiveData<Integer> mTotal;

    public WaterConsumptionViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WaterConsumptionRepository(application);
        mAllLog = mRepository.getAllLog();
        mTotal = mRepository.getTotal();
    }

    public LiveData<Integer> getTotalConsumption() {
        return mTotal;
    }

    public LiveData<List<Activity>> getAllLog() {
        return mAllLog;
    }

    public void addLog(Activity log) {
        mRepository.addLog(log);
    }

    public void updateLog(Activity log) {
        mRepository.updateLog(log);
    }

    public void deleteLog(Activity log) {
        mRepository.deleteLog(log);
    }
}