package com.tamanna.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private int counter = 0;

    //Live data

private MutableLiveData<Integer> countlivedata = new MutableLiveData<>();

    // When the app first launched
//    public int getInitialCounter(){
//        return counter;
//    }

    public MutableLiveData<Integer> getInitialCounter(){
        countlivedata.setValue(counter);
        return countlivedata;
    }

    // When user clicks the button
//    public int getCounter(){
//        counter++;
//        return counter;
//
//    }

    public void getCounter(){
        counter++;
        countlivedata.setValue(counter);
    }
}

