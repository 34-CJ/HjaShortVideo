package com.hja.feature_home.fragment.videolist;

import androidx.lifecycle.ViewModel;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hja.feature_home.R;
import com.hja.feature_home.config.HomeConfig;
import com.hja.feature_home.databinding.LayoutFragmentVideoListBinding;
import com.hja.libbase.base.BaseFragment;
import com.hja.libbase.config.ARouterPath;


@Route(path = ARouterPath.Home.FRAGMENT_VIDEO_LIST)
public class VideoListFragment extends BaseFragment<LayoutFragmentVideoListBinding, VideoListViewModel> {

    @Autowired(name = HomeConfig.KEY_VIDEO_LIST_TYPE)
    public int mPageType;
    @Override
    protected VideoListViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_fragment_video_list;
    }

    @Override
    protected int getBindingVariableId() {
        return 0;
    }

    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);

        if (mPageType == HomeConfig.VIDEO_LIST_FRAGMENT_RECOMMEND) {
        } else if (mPageType == HomeConfig.VIDEO_LIST_FRAGMENT_DAILY) {
        }
    }

    @Override
    protected void initData() {

    }
}
