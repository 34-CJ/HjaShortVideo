package com.hja.feature_plaza.fragment.plaza;

import com.hja.feature_plaza.api.PlazaApiServiceProvider;
import com.hja.feature_plaza.bean.ResPlaza;
import com.hja.libbase.base.IRequestCallback;
import com.hja.network.ApiCall;
import com.hja.network.bean.ResBase;

import java.util.List;

import retrofit2.Call;

public class PlazaModel {


    public void requestDatas(IRequestCallback<List<ResPlaza>> callback) {
        //获取call
        Call<ResBase<List<ResPlaza>>> call = PlazaApiServiceProvider.getApiService().getPlaza();

        ApiCall.enqueue(call, new ApiCall.ApiCallback<ResBase<List<ResPlaza>>>() {
            @Override
            public void onSuccess(ResBase<List<ResPlaza>> result) {
                callback.onLoadFinish(result.getData());
            }

            @Override
            public void onError(int errorCode, String meesage) {
                callback.onLoadFailure(errorCode,meesage);
            }
        });

    }


}
