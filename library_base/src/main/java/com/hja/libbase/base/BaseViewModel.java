package com.hja.libbase.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {
    public MutableLiveData<Integer> mErrorCode = new MutableLiveData<>();


    public MutableLiveData<Integer> getErrorCode() {
        return mErrorCode;
    }
}
