package com.hja.feature_plaza;


import com.alibaba.android.arouter.facade.annotation.Route;

import com.hja.libbase.base.BaseFragment;
import com.hja.libbase.base.BaseViewModel;
import com.hja.libbase.config.ARouterPath;

@Route(path = ARouterPath.Plaza.FRAGMENT_PLAZA)

public class PlazaFragment extends BaseFragment {


    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_fragment_plaza;
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
