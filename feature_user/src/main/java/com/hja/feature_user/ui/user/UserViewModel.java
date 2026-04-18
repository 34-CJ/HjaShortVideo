package com.hja.feature_user.ui.user;

import androidx.lifecycle.MutableLiveData;

import com.hja.libbase.base.BaseViewModel;
import com.hja.libbase.bean.ResUser;
import com.hja.libbase.bean.UserInfo;

public class UserViewModel extends BaseViewModel {

    private final UserModel mModel;

    private MutableLiveData<String> mAvatar = new MutableLiveData<>();
    private MutableLiveData<String> mNickName = new MutableLiveData<>();
    private MutableLiveData<String> mBio = new MutableLiveData<>();
    private MutableLiveData<String> mFans = new MutableLiveData<>();
    private MutableLiveData<String> mFollow = new MutableLiveData<>();
    private MutableLiveData<String> mMedal = new MutableLiveData<>();

    public UserViewModel() {
        mModel = new UserModel();
        //进入到user页面后 根据登录状态更新ui
        boolean login = mModel.isLogin();
        loadUserInfo(login);
    }


    public UserModel getModel() {
        return mModel;
    }

    public MutableLiveData<String> getAvatar() {
        return mAvatar;
    }

    public MutableLiveData<String> getNickName() {
        return mNickName;
    }

    public MutableLiveData<String> getBio() {
        return mBio;
    }

    public MutableLiveData<String> getFans() {
        return mFans;
    }

    public MutableLiveData<String> getFollow() {
        return mFollow;
    }

    public MutableLiveData<String> getMedal() {
        return mMedal;
    }

    /**
     * 加载用户信息
     *
     * @param login
     */
    public void loadUserInfo(boolean login) {
        if (login) {
            showLoading(true);
            mModel.loadUserInfo(new ILoadUserInfoCallback() {
                @Override
                public void onLoadSuccess(ResUser user) {
                    showLoading(false);
                    updateUserInfo(user);
                }

                @Override
                public void onLoadFailure(int errorCode, String message) {
                    showLoading(false);
                    notLoginUpdateUserInfo();
                }
            });
        } else {
            notLoginUpdateUserInfo();
        }
    }

    private void notLoginUpdateUserInfo() {
        //如果没登录 或者获取不到登录的信息，那么传个空的user用来更新ui
        ResUser user = new ResUser();
        user.setUser(new UserInfo());
        updateUserInfo(user);
    }

    /**
     * 更新用户数据的显示
     *
     * @param user
     */
    private void updateUserInfo(ResUser user) {
        String avatar = user.getUser().getAvatar();

        if (avatar != null && !avatar.isEmpty()) {
            mAvatar.setValue(avatar);
        } else {
            mAvatar.setValue(null);
        }

        String nickname = user.getUser().getNickname();
        if (nickname != null && !nickname.isEmpty()) {
            mNickName.setValue(nickname);
        } else {
            mNickName.setValue("请先登录");
        }

        String bio = user.getUser().getBio();
        if (bio != null && !bio.isEmpty()) {
            mBio.setValue(bio);
        } else {
            mBio.setValue("请编辑资料完善个人信息吧！");
        }


        int fans = user.getFans();
        mFans.setValue(fans + " 粉丝");

        int follow = user.getFollow();
        mFollow.setValue(follow + " 关注");
        int medal = user.getMedal();
        mMedal.setValue(medal + " 粉丝");
    }
}
