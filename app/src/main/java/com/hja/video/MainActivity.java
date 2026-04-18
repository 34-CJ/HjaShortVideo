package com.hja.video;


import android.util.Log;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hja.libbase.base.BaseActivity;
import com.hja.libbase.config.ARouterPath;
import com.hja.libbase.eventbus.MessageEvent;
import com.hja.video.adapter.MainFragmentStateAdapter;
import com.hja.video.databinding.ActivityMainBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

@Route(path = ARouterPath.Main.ACTIVITY_MAIN)
public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    private static final String TAG = "MainActivity";
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
        return BR.viewModel;
    }

    @Override
    protected void initView() {

        Fragment homeFragment = (Fragment) ARouter.getInstance().build("/home/homeFragment").navigation();
        Fragment plazaFragment = (Fragment) ARouter.getInstance().build("/plaza/plazaFragment").navigation();
        Fragment findFragment = (Fragment) ARouter.getInstance().build("/find/findFragment").navigation();
        Fragment userFragment = (Fragment) ARouter.getInstance().build("/user/userFragment").navigation();

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(homeFragment);
        fragments.add(plazaFragment);
        fragments.add(findFragment);
        fragments.add(userFragment);

        MainFragmentStateAdapter stateAdapter = new MainFragmentStateAdapter(this);
        stateAdapter.setFragments(fragments);
        mDataBinding.viewPager.setAdapter(stateAdapter);

        mDataBinding.viewPager.setUserInputEnabled(false);//不允许用户滑动切换

        mDataBinding.rbBottomNavigation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_home) {
                    showFragment(0);
                } else if (checkedId == R.id.rb_plaza) {
                    showFragment(1);
                } else if (checkedId == R.id.rb_find) {
                    showFragment(2);
                } else if (checkedId == R.id.rb_mine) {
                    showFragment(3);
                }
            }
        });

    }

    private void showFragment(int position) {
        mDataBinding.viewPager.setCurrentItem(position);
    }

    @Override
    protected void initData() {

    }



}