package com.hja.feature_user.ui.playsettings;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hja.feature_user.R;
import com.hja.feature_user.databinding.ActivityPlaySettingsBinding;
import com.hja.libbase.base.BaseActivity;
import com.hja.libbase.base.BaseViewModel;
import com.hja.libbase.config.ARouterPath;
import com.hja.libbase.utils.StatusBarUtils;

@Route(path = ARouterPath.User.ACTIVITY_PLAYTTINGS)
public class PlaySettingsActivity extends BaseActivity<ActivityPlaySettingsBinding, BaseViewModel> {


    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_play_settings;
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