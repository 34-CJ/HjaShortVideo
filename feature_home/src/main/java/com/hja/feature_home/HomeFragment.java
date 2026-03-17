package com.hja.feature_home;

import static com.hja.feature_home.config.HomeConfig.KEY_VIDEO_LIST_TYPE;
import static com.hja.feature_home.config.HomeConfig.VIDEO_LIST_FRAGMENT_DAILY;
import static com.hja.feature_home.config.HomeConfig.VIDEO_LIST_FRAGMENT_RECOMMEND;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

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

    }

    @Override
    protected void initData() {

    }
}
