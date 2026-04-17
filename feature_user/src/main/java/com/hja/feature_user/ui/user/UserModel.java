package com.hja.feature_user.ui.user;

import com.hja.libbase.bean.ResUser;
import com.hja.libbase.manager.UserManager;
import com.hja.network.config.ErrorStatusConfig;

public class UserModel {

    public boolean isLogin() {
        return UserManager.getInstance().isLogin();//是否登录
    }

    /**
     * 获取用户信息
     *
     * @param callback
     */
    public void loadUserInfo(ILoadUserInfoCallback callback) {
        if (isLogin()) {
            //获取到用户信息
            ResUser userInfo = UserManager.getInstance().getUserInfo();
            if (userInfo != null) {
                callback.onLoadSuccess(userInfo);
            } else {
                callback.onLoadFailure(ErrorStatusConfig.ERROR_STATUS_NOT_LOGIN, "未登录");
            }
        } else {
            callback.onLoadFailure(ErrorStatusConfig.ERROR_STATUS_NOT_LOGIN, "未登录");
        }
    }
}
