package com.hja.feature_user.ui.pushsettings;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hja.feature_user.R;
import com.hja.feature_user.databinding.ActivityPushSettingsBinding;
import com.hja.libbase.base.BaseActivity;
import com.hja.libbase.base.BaseViewModel;
import com.hja.libbase.config.ARouterPath;
import com.hja.libbase.utils.StatusBarUtils;

@Route(path = ARouterPath.User.ACTIVITY_PUSHSETTINGS)
public class PushSettingsActivity extends BaseActivity<ActivityPushSettingsBinding, BaseViewModel> {

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_push_settings;
    }

    @Override
    protected int getBindingVariableId() {
        return 0;
    }

    @Override
    protected void initView() {
        StatusBarUtils.addStatusBarHeight2RootView(mDataBinding.getRoot());
    }

    @Override
    protected void initData() {

    }
}