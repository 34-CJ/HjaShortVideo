package com.hja.feature_user.api;

import com.hja.feature_user.bean.ReqMobileLogin;
import com.hja.feature_user.bean.ReqSendSmsCode;
import com.hja.feature_user.bean.ResLogin;
import com.hja.libbase.bean.ResUser;
import com.hja.network.bean.ResBase;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 这里存放user模块的api
 */
public interface UserApiService {

    /**
     * 请求获取验证码
     *
     * @param code 请求体
     * @return
     */
    @POST("addons/cms/api.sms/send")
    Call<ResBase<ResBase>> sendSmsCode(@Body ReqSendSmsCode code);

    /**
     * 通过手机号登录
     *
     * @param login 请求体
     * @return
     */
    @POST("addons/cms/api.login/mobilelogin")
    Call<ResBase<ResLogin>> mobileLogin(@Body ReqMobileLogin login);

    /**
     * 获取用户信息
     *
     * @return
     */
    @GET("addons/cms/api.user/userInfo")
    Call<ResBase<ResUser>> getUserInfo(@Query("user_id") String userId, @Query("type") String type);

}
