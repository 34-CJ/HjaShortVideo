package com.hja.feature_home;

import static com.hja.feature_home.config.HomeConfig.KEY_VIDEO_LIST_TYPE;
import static com.hja.feature_home.config.HomeConfig.VIDEO_LIST_FRAGMENT_DAILY;
import static com.hja.feature_home.config.HomeConfig.VIDEO_LIST_FRAGMENT_RECOMMEND;

import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hja.feature_home.databinding.LayoutFragmentHomeBinding;
import com.hja.feature_home.fragment.videolist.VideoListFragment;
import com.hja.libbase.base.BaseFragment;
import com.hja.libbase.config.ARouterPath;

import java.util.ArrayList;

@Route(path = ARouterPath.Home.FRAGMENT_HOME)
public class HomeFragment extends BaseFragment<LayoutFragmentHomeBinding, HomeViewModel> {


    @Override
    protected HomeViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_fragment_home;
    }

    @Override
    protected int getBindingVariableId() {
        return 0;
    }

    @Override
    protected void initView() {
        VideoListFragment recommendFragment = (VideoListFragment) ARouter.getInstance()
                .build(ARouterPath.Home.FRAGMENT_VIDEO_LIST)
                .withInt(KEY_VIDEO_LIST_TYPE, VIDEO_LIST_FRAGMENT_RECOMMEND)
                .navigation();
        VideoListFragment dailyFragment = (VideoListFragment) ARouter.getInstance()
                .build(ARouterPath.Home.FRAGMENT_VIDEO_LIST)
                .withInt(KEY_VIDEO_LIST_TYPE, VIDEO_LIST_FRAGMENT_DAILY)
                .navigation();

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(recommendFragment);
        fragments.add(dailyFragment);

        mDataBinding.viewPager2.setAdapter(new FragmentStateAdapter(getActivity()) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return fragments.get(position);
            }

            @Override
            public int getItemCount() {
                return fragments != null ? fragments.size() : 0;
            }
        });

        mDataBinding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            /**
             * ViewPager2滑动完之后
             * @param position Position index of the new selected page.
             */
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        mDataBinding.rbRecommend.setChecked(true);
                        break;
                    case 1:
                        mDataBinding.rbDaily.setChecked(true);
                        break;
                }
            }
        });

        mDataBinding.rgIndicator.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mDataBinding.rbRecommend.getId()) {
                    mDataBinding.viewPager2.setCurrentItem(0);
                } else if (checkedId == mDataBinding.rbDaily.getId()) {
                    mDataBinding.viewPager2.setCurrentItem(1);
                }
            }
        });
    }



    @Override
    protected void initData() {

    }
}
