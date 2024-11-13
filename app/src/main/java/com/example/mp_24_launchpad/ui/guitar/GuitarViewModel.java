package com.example.mp_24_launchpad.ui.guitar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GuitarViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GuitarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is guitar fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}