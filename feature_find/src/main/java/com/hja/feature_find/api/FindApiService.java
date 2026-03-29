package com.hja.feature_find.api;

import com.hja.feature_find.bean.ResFind;
import com.hja.network.bean.ResBase;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 这里存放find模块的api
 */
public interface FindApiService {

    /**
     * 发现首页数据
     *
     * @return 服务端返回的数据类型
     */
    @GET("addons/cms/api.eye/find")
    Call<ResBase<ResFind>> getFindData();


}
