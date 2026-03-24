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
import com.hja.libbase.R;
import com.hja.libbase.databinding.LayoutStatusViewBinding;
import com.hja.network.config.ErrorStatusConfig;

public abstract class BaseFragment<V extends ViewDataBinding, VM extends BaseViewModel> extends Fragment {

    protected VM mViewModel;
    protected V mDataBinding;
    protected LayoutStatusViewBinding mLayoutStatusViewBinding;

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
        initStatusView();

        return mDataBinding.getRoot();
    }

    private void initStatusView() {
        //获取当前页面的根布局
        ViewGroup root = (ViewGroup) mDataBinding.getRoot();
        //查找状态错误提示布局
        mLayoutStatusViewBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.layout_status_view, null, false);
        //将布局添加到当前页面并设置宽高尺寸
        View statusViewRoot = mLayoutStatusViewBinding.getRoot();
        statusViewRoot.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        root.addView(statusViewRoot);

        if (mViewModel != null) {
            //错误状态显示
            //getViewLifecycleOwner()：通过这个方法获取当前视图生命周期的所有者，以免造成内存泄露
            mViewModel.getErrorCode().observe(getViewLifecycleOwner(), errorCode -> {
                String content = "";
                switch (errorCode) {
                    case ErrorStatusConfig.ERROR_STATUS_NETWORK_FIAL:
                        content = "网络错误，请检查网络！";
                        break;
                    case ErrorStatusConfig.ERROR_STATUS_NOT_LOGIN:
                        content = "请登录后再进行操作！";
                        break;
                    case ErrorStatusConfig.ERROR_STATUS_EMPTY:
                        content = "当前没有更多数据了！";
                        break;
                    case ErrorStatusConfig.ERROR_STATUS_SERVER_ERROR:
                        content = "服务器异常！";
                        break;
                    case ErrorStatusConfig.ERROR_STATUS_NORMAL:
                    default:
                        content = "";
                        break;
                }

                LayoutStatusViewBinding layoutStatusView = mLayoutStatusViewBinding;
                boolean isVisibility = errorCode != ErrorStatusConfig.ERROR_STATUS_NORMAL;
                layoutStatusView.clStatusView.setVisibility(isVisibility ? View.VISIBLE : View.GONE);
                layoutStatusView.tvLable.setText(content);

            });
        }

    }



    protected abstract VM getViewModel();

    protected abstract int getLayoutResId();

    protected abstract int getBindingVariableId();

    protected abstract void initView();//如果子类需要做一些视图上的初始化

    protected abstract void initData();//如果子类需要做一些数据上的初始化
}
