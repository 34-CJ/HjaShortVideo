package com.hja.feature_home.fragment.videolist;

import android.util.Log;

import com.hja.feature_home.api.HomeApiService;
import com.hja.feature_home.api.HomeApiServiceProvider;
import com.hja.feature_home.bean.ResVideo;
import com.hja.feature_home.config.HomeConfig;
import com.hja.libbase.base.list.BaseListModel;
import com.hja.network.ApiCall;
import com.hja.network.RetrofitProvider;
import com.hja.network.bean.ResBase;
import com.hja.network.bean.ResList;
import com.hja.network.config.ErrorStatusConfig;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class VideoListModel extends BaseListModel {

    private static final String TAG = "VideoListModel";

    private int mPageType;

    /**
     * 请求推荐页、日报页的数据
     *
     * @param isFirst 是不是第一次加载？
     */

    @Override
    public void requestDatas(boolean isFirst) {
        if (isFirst) {
            mPage = 1;
        } else {
            mPage++;
        }
        HomeApiService apiService = HomeApiServiceProvider.getApiService();
        Call<ResBase<ResList<ResVideo>>> call;
        if (mPageType == HomeConfig.VIDEO_LIST_FRAGMENT_RECOMMEND) {
            call = apiService.getRecommend(mPage, mLimit);
        } else {
            call = apiService.getDaily(mPage, mLimit);
        }

        ApiCall.enqueueLists(call, new ApiCall.ApiListsCallback() {
            @Override
            public void onSuccess(ResList result) {
                mListenner.onLoadFinish(isFirst, result);
            }

            @Override
            public void onError(int errorCode, String meesage) {
                mListenner.onLoadFailure(errorCode);
            }
        });
    }

    /**
     * 设置当前页面是推荐页 还是日报页
     *
     * @param pageType 页面的类型，可选值如下：
     */

    public void setPageType(int pageType) {
        mPageType = pageType;
    }
}
