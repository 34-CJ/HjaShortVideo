package com.hja.feature_home.fragment.videolist;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hja.feature_home.adapter.VideoAdapter;
import com.hja.feature_home.bean.ResVideo;
import com.hja.feature_home.config.HomeConfig;
import com.hja.libbase.base.list.BaseListFragment;
import com.hja.libbase.config.ARouterPath;

import java.util.List;

/**
 * 首页视频列表页fragment  列表相关的功能全部在BaseListFragment中已完成
 * 当前页面只需要做下面几件事：
 * 1、返回具体的ViewModel
 * 2、如果有重写initView、initData，记得调用super父类对应的方法，因为子类重写方法会覆盖父类中的方法
 * 3、返回recyclerview的布局管理器
 * 4、onDatasRequestSuccess中为适配器设置请求成功的数据
 */
@Route(path = ARouterPath.Home.FRAGMENT_VIDEO_LIST)
public class VideoListFragment extends BaseListFragment<ResVideo> {

    @Autowired(name = HomeConfig.KEY_VIDEO_LIST_TYPE)
    public int mPageType;
    private VideoAdapter mAdapter;

    @Override
    protected VideoListViewModel getViewModel() {
        return new ViewModelProvider(this).get(VideoListViewModel.class);
    }

    /**
     * 在列表形式的页面中 这个方法用处不大，可以不写
     *
     * @return
     */
    @Override
    protected int getBindingVariableId() {
        return 0;
    }

    @Override
    protected void initView() {
        super.initView();//记得调用super
    }

    @Override
    protected void initData() {
        VideoListViewModel model = (VideoListViewModel) mViewModel;
        model.setPageType(mPageType);
        super.initData();//记得调用super
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        mAdapter = new VideoAdapter();
        return mAdapter;
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    @Override
    protected void onDatasRequestSuccess(List<ResVideo> list) {
        mAdapter.setVideos(list);
    }
//
//
//    /**
//     * 测试用的方法， 用来测试错误码，并不是实际存在的功能
//     *
//     * @param value 自定义错误码
//     */
//    public void setErrorCode(Integer value) {
//        mViewModel.getErrorCode().setValue(value);
//    }
}
