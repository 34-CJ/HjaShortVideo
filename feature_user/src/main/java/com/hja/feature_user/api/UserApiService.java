package com.hja.feature_user.api;

import com.hja.feature_user.bean.ReqMobileLogin;
import com.hja.feature_user.bean.ReqSendSmsCode;
import com.hja.feature_user.bean.ResLogin;
import com.hja.libbase.bean.ResUser;
import com.hja.network.bean.ResBase;
import com.hja.feature_user.bean.ReqResetPwd;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 这里存放user模块的api
 */

public interface UserApiService {


    /**
     * 退出登录
     *
     * @return
     */
    @POST("addons/cms/api.user/logout")
    Call<ResBase<ResBase>> logout(@Header("token") String token);

    /**
     * 重置密码
     *
     * @param code 请求体
     * @return
     */
    @POST("addons/cms/api.login/resetpwd")
    Call<ResBase<ResBase>> resetPassword(@Header("token") String token, @Body ReqResetPwd code);

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
