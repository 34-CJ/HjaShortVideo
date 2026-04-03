package com.hja.feature_user.ui.login;

import com.hja.feature_user.api.UserApiServiceProvider;
import com.hja.feature_user.bean.ReqMobileLogin;
import com.hja.feature_user.bean.ReqSendSmsCode;
import com.hja.feature_user.bean.ResLogin;
import com.hja.libbase.base.IRequestCallback;
import com.hja.network.ApiCall;
import com.hja.network.bean.ResBase;

import retrofit2.Call;

public class LoginModel {

    /**
     * 发送验证码
     *
     * @param mobile   手机号
     * @param callback 回调
     */
    public void sendSmsCode(String mobile, IRequestCallback<ResBase<ResBase>> callback) {

        ReqSendSmsCode smsCode = new ReqSendSmsCode(mobile, "mobilelogin");
        Call<ResBase<ResBase>> call = UserApiServiceProvider.getApiService().sendSmsCode(smsCode);
        ApiCall.enqueue(call, new ApiCall.ApiCallback<ResBase<ResBase>>() {
            @Override
            public void onSuccess(ResBase<ResBase> result) {
                callback.onLoadFinish(result);
            }

            @Override
            public void onError(int errorCode, String meesage) {
                callback.onLoadFailure(errorCode, meesage);
            }
        });

    }

    /**
     * 手机号登录
     *
     * @param mobile   手机号
     * @param code     验证码
     * @param callback 回调
     */
    public void mobileLogin(String mobile, String code, IRequestCallback<ResBase<ResLogin>> callback) {

        ReqMobileLogin login = new ReqMobileLogin(mobile, code);
        Call<ResBase<ResLogin>> call = UserApiServiceProvider.getApiService().mobileLogin(login);
        ApiCall.enqueue(call, new ApiCall.ApiCallback<ResBase<ResLogin>>() {
            @Override
            public void onSuccess(ResBase<ResLogin> result) {
                callback.onLoadFinish(result);
            }

            @Override
            public void onError(int errorCode, String meesage) {
                callback.onLoadFailure(errorCode, meesage);
            }
        });

    }
}
