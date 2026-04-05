package com.hja.video;

import android.util.Log;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hja.libbase.base.BaseActivity;
// 这两行是自动生成的，环境修好后它们会自动变黑
import com.hja.libbase.config.ARouterPath;
import com.hja.video.databinding.ActivityMainBinding;

import java.util.ArrayList;

@Route(path = ARouterPath.Main.ACTIVITY_MAIN)

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
    protected void initView() {

        Fragment homeFragment = (Fragment) ARouter.getInstance().build("/home/homeFragment").navigation();
        Fragment plazaFragment = (Fragment) ARouter.getInstance().build("/plaza/plazaFragment").navigation();
        Fragment findFragment = (Fragment) ARouter.getInstance().build("/find/findFragment").navigation();
        Fragment userFragment = (Fragment) ARouter.getInstance().build("/user/userFragment").navigation();


        if (homeFragment != null) {
            replaceFragment(homeFragment);
        } else {
            Log.e("ARouter", "家模块 Fragment 未找到，请检查路由配置和注解！");
        }

        mDataBinding.rbBottomNavigation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_home) {
                    replaceFragment(homeFragment);
                } else if (checkedId == R.id.rb_plaza) {
                    replaceFragment(plazaFragment);
                } else if (checkedId == R.id.rb_find) {
                    replaceFragment(findFragment);
                } else if (checkedId == R.id.rb_mine) {
                    replaceFragment(userFragment);
                }
            }
        });

    }

    private void replaceFragment(Fragment homeFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fcv, homeFragment).commit();
    }

    @Override
    protected void initData() {}
}