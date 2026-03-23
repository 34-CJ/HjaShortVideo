package com.hja.feature_home.fragment.videolist;

import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hja.feature_home.R;
import com.hja.feature_home.adapter.VideoAdapter;
import com.hja.feature_home.bean.ResVideo;
import com.hja.feature_home.config.HomeConfig;
import com.hja.feature_home.databinding.LayoutFragmentVideoListBinding;
import com.hja.libbase.base.BaseFragment;
import com.hja.libbase.config.ARouterPath;
import com.hja.network.config.ErrorStatusConfig;
import com.hja.libbase.databinding.LayoutStatusViewBinding;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.List;

@Route(path = ARouterPath.Home.FRAGMENT_VIDEO_LIST)
public class VideoListFragment extends BaseFragment<LayoutFragmentVideoListBinding, VideoListViewModel> {


    @Autowired(name = HomeConfig.KEY_VIDEO_LIST_TYPE)
    public int mPageType;
    private VideoAdapter mAdapter;

    @Override
    protected VideoListViewModel getViewModel() {
        return new ViewModelProvider(this).get(VideoListViewModel.class);
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
        //初始化recyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mDataBinding.recyclerView.setLayoutManager(layoutManager);
        //初始化适配器
        mAdapter = new VideoAdapter();
        mDataBinding.recyclerView.setAdapter(mAdapter);
        //为smartRefreshLayout添加  加载更多的回调
        mDataBinding.smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                //下拉触发这个方法
                mViewModel.requestData(mPageType, false);
            }
        });
        //为smartRefreshLayout添加  刷新的回调
        mDataBinding.smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新
                mViewModel.requestData(mPageType, true);
            }
        });

    }

    @Override
    protected void initData() {
        //根据页面类型请求数据
        mViewModel.requestData(mPageType, true);
        //观测到数据发生变化
        mViewModel.getDatas().observe(this, resVideoResList -> {
            //停止刷新、加载的状态
            SmartRefreshLayout smartRefreshLayout = mDataBinding.smartRefreshLayout;
            if (smartRefreshLayout.isRefreshing()) {
                smartRefreshLayout.finishRefresh();
            }
            if (smartRefreshLayout.isLoading()) {
                smartRefreshLayout.finishLoadMore();
            }
            //将数据设置到适配器进行显示
            List<ResVideo> resVideos = resVideoResList.getList();
            mAdapter.setVideos(resVideos);
        });

        //是否允许加载更多
        mViewModel.getIsLoadMore().observe(this, isLoadMore -> {
            //是否允许继续加载
            mDataBinding.smartRefreshLayout.setEnableLoadMore(isLoadMore);
            if (!isLoadMore) {
                Toast.makeText(getContext(), "没有更多数据了！", Toast.LENGTH_SHORT).show();
            }

        });
        //错误状态显示
        mViewModel.getErrorCode().observe(this, errorCode -> {
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

            LayoutStatusViewBinding layoutStatusView = mDataBinding.layoutStatusView;
            boolean isVisibility = errorCode != ErrorStatusConfig.ERROR_STATUS_NORMAL;
            layoutStatusView.clStatusView.setVisibility(isVisibility ? View.VISIBLE : View.GONE);
            layoutStatusView.tvLable.setText(content);

        });
    }

    /**
     * 测试用的方法， 用来测试错误码，并不是实际存在的功能
     *
     * @param value 自定义错误码
     */
    public void setErrorCode(Integer value) {
        mViewModel.getErrorCode().setValue(value);
    }
}
