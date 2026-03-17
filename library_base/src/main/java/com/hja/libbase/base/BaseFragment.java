package com.hja.libbase.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

import com.alibaba.android.arouter.launcher.ARouter;

public abstract class BaseFragment<V extends ViewDataBinding, VM extends ViewModel> extends Fragment {

    protected VM mViewModel;
    protected V mDataBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mDataBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false);
        mDataBinding.setLifecycleOwner(this);

        VM viewModel = getViewModel();
        if (viewModel != null) {
            mViewModel = viewModel;
        }


        //在父类中使用viewmodel在xml中的变量名 关联具体的mViewModel  效果等同于mDataBinding.setViewModel(mViewModel);
        int bindingVariableId = getBindingVariableId();
        if (bindingVariableId != 0) {
            mDataBinding.setVariable(bindingVariableId, mViewModel);
            //关联完mViewModel后，实时更新数据
            mDataBinding.executePendingBindings();
        }

        ARouter.getInstance().inject(this);
        initView();
        initData();

        return mDataBinding.getRoot();
    }


    protected abstract VM getViewModel();

    protected abstract int getLayoutResId();

    protected abstract int getBindingVariableId();

    protected abstract void initView();//如果子类需要做一些视图上的初始化

    protected abstract void initData();//如果子类需要做一些数据上的初始化
}
