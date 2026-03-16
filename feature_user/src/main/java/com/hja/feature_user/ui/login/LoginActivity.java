package com.hja.feature_user.ui.login;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hja.feature_user.BR;

import com.hja.feature_user.R;
import com.hja.feature_user.databinding.ActivityLoginBinding;
import com.hja.libbase.base.BaseActivity;
import com.hja.libbase.config.ARouterPath;

@Route(path = ARouterPath.User.ACTIVITY_LOGIN)
public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {

    @Override
    protected void initView() {
        //在这里做一些布局、ui的初始化
//        mDataBinding.main.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void initData() {
        //在这里做一些数据上的初始化
        mViewModel.changeData();
    }

    @Override
    protected LoginViewModel getViewModel() {
        return new ViewModelProvider(this).get(LoginViewModel.class);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected int getBindingVariableId() {
        return BR.viewModel;
    }


}