package com.hja.feature_home.fragment.videolist;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hja.feature_home.R;
import com.hja.feature_home.adapter.ResVideo;
import com.hja.feature_home.adapter.VideoAdapter;
import com.hja.feature_home.config.HomeConfig;
import com.hja.feature_home.databinding.LayoutFragmentVideoListBinding;
import com.hja.libbase.base.BaseFragment;
import com.hja.libbase.config.ARouterPath;

import java.util.ArrayList;


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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mDataBinding.recyclerView.setLayoutManager(layoutManager);

        ArrayList<ResVideo> videos = new ArrayList<>();
        videos.add(new ResVideo("标题1","作者9","00:23"));
        videos.add(new ResVideo("标题2","作者8","13:23"));
        videos.add(new ResVideo("标题3","作者7","00:43"));
        videos.add(new ResVideo("标题4","作者6","00:23"));
        videos.add(new ResVideo("标题5","作者5","00:63"));
        videos.add(new ResVideo("标题6","作者3","30:83"));
        videos.add(new ResVideo("标题7","作者3","00:23"));
        videos.add(new ResVideo("标题8","作者2","80:23"));
        videos.add(new ResVideo("标题9","作者0","00:23"));


        mDataBinding.recyclerView.setAdapter(new VideoAdapter(videos));
        if (mPageType == HomeConfig.VIDEO_LIST_FRAGMENT_RECOMMEND) {
        } else if (mPageType == HomeConfig.VIDEO_LIST_FRAGMENT_DAILY) {
        }
    }

    @Override
    protected void initData() {

    }
}
