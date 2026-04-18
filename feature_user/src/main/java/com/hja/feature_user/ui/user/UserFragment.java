package com.hja.feature_user.ui.user;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hja.feature_user.BR;
import com.hja.feature_user.R;
import com.hja.feature_user.databinding.LayoutFragmentUserBinding;
import com.hja.libbase.base.BaseFragment;
import com.hja.libbase.config.ARouterPath;
import com.hja.libbase.eventbus.MessageEvent;
import com.hja.libbase.utils.StatusBarUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Route(path = ARouterPath.User.FRAGMENT_USER)
public class UserFragment extends BaseFragment<LayoutFragmentUserBinding, UserViewModel> {
    private static final String TAG = "UserFragment";

    @Override
    protected UserViewModel getViewModel() {
        return new ViewModelProvider(this).get(UserViewModel.class);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_fragment_user;
    }

    @Override
    protected int getBindingVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        Log.i(TAG, "initView");
        StatusBarUtils.addStatusBarHeight2Views(mDataBinding.getRoot(), mDataBinding.ivSettings, mDataBinding.ivQualifications);

        mDataBinding.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterPath.User.ACTIVITY_LOGIN).navigation();
            }
        });

    }

    @Override
    protected void initData() {

    }


    /**
     * 通过eventBus订阅 登录状态变化的消息
     *
     * @param event
     */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)//表示接收粘性事件
    public void onMessageEvent(MessageEvent.LoginStatusEvent event) {
        boolean login = event.isLogin();
        Log.i(TAG, "onMessageEvent: isLogin = " + login);
        mViewModel.loadUserInfo(login);
    }

    @Override
    public void onStart() {
        super.onStart();
        //确保页面活跃的时候再接收事件
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        //页面不活跃的时候取消事件接收
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);//注销
        }
    }
}
