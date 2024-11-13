package com.example.mp_24_launchpad.ui.piano;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PianoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PianoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is piano fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}