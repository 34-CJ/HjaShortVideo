package com.hja.feature_user.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    MutableLiveData<String> label = new MutableLiveData<>();

    public void changeData(){
        label.setValue("测试一下数据");
    }

    public LiveData<String> getLabel() {
        return label;
    }

    public void setLabel(MutableLiveData<String> label) {
        this.label = label;
    }
}
