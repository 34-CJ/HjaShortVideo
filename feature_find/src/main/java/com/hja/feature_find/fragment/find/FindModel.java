package com.hja.feature_find.fragment.find;

import com.hja.feature_find.api.FindApiService;
import com.hja.feature_find.api.FindApiServiceProvider;
import com.hja.feature_find.bean.ResFind;
import com.hja.libbase.base.IRequestCallback;
import com.hja.network.ApiCall;
import com.hja.network.bean.ResBase;

import retrofit2.Call;

public class FindModel {


    public FindModel() {

    }

    /**
     * 加载发现页数据
     */
    public void loadFindData(IRequestCallback<ResFind> callback) {

        FindApiService apiService = FindApiServiceProvider.getApiService();
        Call<ResBase<ResFind>> call = apiService.getFindData();

        ApiCall.enqueue(call, new ApiCall.ApiCallback<ResBase<ResFind>>() {
            @Override
            public void onSuccess(ResBase<ResFind> result) {
                callback.onLoadFinish(result.getData());
            }

            @Override
            public void onError(int errorCode, String meesage) {
                callback.onLoadFailure(errorCode);
            }
        });

    }
}
