package com.hja.feature_plaza;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hja.feature_plaza.databinding.LayoutFragmentPlazaBinding;
import com.hja.libbase.base.BaseFragment;
import com.hja.libbase.config.ARouterPath;

@Route(path = ARouterPath.Plaza.FRAGMENT_PLAZA)

public class PlazaFragment extends BaseFragment {


    @Override
    protected ViewModel getViewModel() {
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
