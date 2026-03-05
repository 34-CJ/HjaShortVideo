package com.hja.video;

import androidx.lifecycle.ViewModelProvider;
import com.hja.libbase.base.BaseActivity;
// 这两行是自动生成的，环境修好后它们会自动变黑
import com.hja.video.databinding.ActivityMainBinding;
import com.hja.video.BR;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    protected MainViewModel getViewModel() {
        return new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getBindingVariableId() {
        // 这里的 BR 如果还报错，说明编译还没彻底完成
        return BR.viewModel;
    }

    @Override
    protected void initView() {}

    @Override
    protected void initData() {}
}