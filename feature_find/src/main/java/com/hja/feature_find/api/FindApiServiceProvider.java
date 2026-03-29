package com.hja.feature_find.api;

import com.hja.network.RetrofitProvider;

import retrofit2.Retrofit;

/**
 * home模块中的PlazaApiService统一在这里获取，以便统一管理
 */
public class FindApiServiceProvider {

    private static FindApiService mApiService;

    //单例
    public static FindApiService getApiService() {
        if (mApiService == null) {
            Retrofit retrofit = RetrofitProvider.provide();
            mApiService = retrofit.create(FindApiService.class);
        }
        return mApiService;
    }
}
