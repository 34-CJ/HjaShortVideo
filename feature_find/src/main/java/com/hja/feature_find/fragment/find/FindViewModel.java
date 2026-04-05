package com.hja.feature_find.fragment.find;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.hja.feature_find.bean.ResFind;
import com.hja.feature_find.bean.ResFindAnchor;
import com.hja.feature_find.bean.ResFindCategory;
import com.hja.feature_find.bean.ResFindTopic;
import com.hja.libbase.base.BaseViewModel;
import com.hja.libbase.base.IRequestCallback;

import java.util.List;

public class FindViewModel extends BaseViewModel implements IRequestCallback<ResFind> {


    private static final String TAG = "FindViewModel";

    private final FindModel mModel;

    private MutableLiveData<List<ResFindCategory>> mCategory = new MutableLiveData<>();
    private MutableLiveData<List<ResFindAnchor>> mAnchor = new MutableLiveData<>();
    private MutableLiveData<List<ResFindTopic>> mTopic = new MutableLiveData<>();

    public FindViewModel() {
        mModel = new FindModel();
    }

    public void loadFindData() {
        mModel.loadFindData(this);
        Log.i(TAG, "loadFindData: 请求发现页数据");
    }

    @Override
    public void onLoadFinish(ResFind datas) {
        Log.i(TAG, "onLoadFinish:" + datas.getCategory().size());
        //获取到数据，更新到mCategory
        mCategory.setValue(datas.getCategory());

        mAnchor.setValue(datas.getAnchor());

        mTopic.setValue(datas.getTopic());
    }

    @Override
    public void onLoadFailure(int errorCode, String message) {
        Log.i(TAG, "onLoadFailure: errorCode = " + errorCode);
    }

    public MutableLiveData<List<ResFindCategory>> getCategory() {
        return mCategory;
    }

    public MutableLiveData<List<ResFindAnchor>> getAnchor() {
        return mAnchor;
    }

    public MutableLiveData<List<ResFindTopic>> getTopic() {
        return mTopic;
    }
}
