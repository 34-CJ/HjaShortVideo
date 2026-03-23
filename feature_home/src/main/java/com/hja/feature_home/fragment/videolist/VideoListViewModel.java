package com.hja.feature_home.fragment.videolist;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hja.feature_home.bean.ResVideo;
import com.hja.network.bean.ResList;
import com.hja.network.config.ErrorStatusConfig;

import java.util.List;

public class VideoListViewModel extends ViewModel implements IVideoListListenner {

    //model
    private final VideoListModel mModel;

    //列表需要使用的数据
    public MutableLiveData<ResList<ResVideo>> mDatas = new MutableLiveData<>();
    //错误码
    public MutableLiveData<Integer> mErrorCode = new MutableLiveData<>();

    //是否还能继续加载更多 默认是true
    public MutableLiveData<Boolean> mIsLoadMore = new MutableLiveData<>(true);

    public VideoListViewModel() {
        mModel = new VideoListModel(this);
    }

    /**
     * 根据页面类型请求数据
     *
     * @param pageType 页面类型：推荐、日报
     * @param isFirst  是否是第一次加载
     */
    public void requestData(int pageType, boolean isFirst) {
        if (isFirst) {
            mIsLoadMore.setValue(true);
        }
        //发起网络请求
        mModel.requestData(pageType, isFirst);
    }

    @Override
    public void onLoadFinish(boolean isFirst, ResList<ResVideo> videos) {
        if (isFirst) {
            //第一次加载或者是刷新的情况
            mDatas.setValue(videos);
        } else {
            //分页加载的情况
            ResList<ResVideo> value = mDatas.getValue();
            List<ResVideo> resVideos = value.getList();
            resVideos.addAll(videos.getList());
            mDatas.setValue(value);
        }

        //当前列表的总数
        int count = videos.getCount();
        if (mDatas.getValue().getList().size() >= count) {
            mIsLoadMore.setValue(false);
        }
    }

    @Override
    public void onLoadFial(int statusCode, String message) {
        mErrorCode.setValue(statusCode);
        if (statusCode == ErrorStatusConfig.ERROR_STATUS_EMPTY) {
            mIsLoadMore.setValue(false);
        }
    }


    public MutableLiveData<ResList<ResVideo>> getDatas() {
        return mDatas;
    }

    public MutableLiveData<Integer> getErrorCode() {
        return mErrorCode;
    }

    public MutableLiveData<Boolean> getIsLoadMore() {
        return mIsLoadMore;
    }


}
