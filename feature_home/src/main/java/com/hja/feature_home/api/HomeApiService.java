package com.hja.feature_home.api;

import com.hja.feature_home.bean.ResVideo;
import com.hja.network.bean.ResBase;
import com.hja.network.bean.ResList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HomeApiService {


    @GET("addons/cms/api.eye/daily")
    Call<ResBase<ResList<ResVideo>>> getDaily(@Query("page") int page, @Query("limit") int limit);


    @GET("addons/cms/api.eye/recommend")
    Call<ResBase<ResList<ResVideo>>> getRecommend(@Query("page") int page, @Query("limit") int limit);
}
