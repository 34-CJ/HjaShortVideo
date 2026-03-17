package com.hja.libbase.base;


import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

public abstract class BaseActivity<V extends ViewDataBinding, VM extends ViewModel> extends AppCompatActivity {

    protected VM mViewModel;
    protected V mDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViewModel();
        initDatabinding();
        //开启沉浸式状态栏
        EdgeToEdge.enable(this);
        //mDataBinding.getRoot()获取根布局
        ViewCompat.setOnApplyWindowInsetsListener(mDataBinding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        initView();
        initData();
    }

    private void initDatabinding() {
        //从子类获取的布局id 与databinding关联
        mDataBinding = DataBindingUtil.setContentView(this, getLayoutResId());
        mDataBinding.setLifecycleOwner(this);

        //在父类中使用viewmodel在xml中的变量名 关联具体的mViewModel  效果等同于mDataBinding.setViewModel(mViewModel);
        mDataBinding.setVariable(getBindingVariableId(), mViewModel);
        //关联完mViewModel后，实时更新数据
        mDataBinding.executePendingBindings();
    }

    private void initViewModel() {
        //从子类获取到的viewModel 赋值给mViewModel
        mViewModel = getViewModel();
    }


    protected abstract VM getViewModel();

    protected abstract int getLayoutResId();

    protected abstract int getBindingVariableId();

    protected abstract void initView();//如果子类需要做一些视图上的初始化

    protected abstract void initData();//如果子类需要做一些数据上的初始化
}
