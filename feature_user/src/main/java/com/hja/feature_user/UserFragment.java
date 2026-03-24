package com.hja.feature_user;


import androidx.lifecycle.ViewModel;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hja.feature_user.databinding.LayoutFragmentUserBinding;
import com.hja.libbase.base.BaseFragment;
import com.hja.libbase.base.BaseViewModel;
import com.hja.libbase.config.ARouterPath;

@Route(path = ARouterPath.User.FRAGMENT_USER)
public class UserFragment extends BaseFragment {


    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_fragment_user;
    }

    @Override
    protected int getBindingVariableId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
