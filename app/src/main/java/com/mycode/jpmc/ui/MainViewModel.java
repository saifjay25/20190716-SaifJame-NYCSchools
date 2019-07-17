package com.mycode.jpmc.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import com.mycode.jpmc.entity.SATResults;
import com.mycode.jpmc.network.MainAPI;
import com.mycode.jpmc.entity.HighSchools;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private MainAPI mainAPI;

    @Inject
    public MainViewModel(MainAPI mainAPI){
        this.mainAPI = mainAPI;
    }

    public LiveData<List<HighSchools>> HighSchoolAPICall(){
        return LiveDataReactiveStreams.fromPublisher(mainAPI.getHighSchools().subscribeOn(Schedulers.io()));
    }
    public LiveData<List<SATResults>> SATResultsAPICall(){
        return LiveDataReactiveStreams.fromPublisher(mainAPI.getSATResults().subscribeOn(Schedulers.io()));
    }

}
