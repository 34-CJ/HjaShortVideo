package com.hja.feature_home.fragment.videolist;

import android.util.Log;

import com.hja.feature_home.api.HomeApiService;
import com.hja.feature_home.api.HomeApiServiceProvider;
import com.hja.feature_home.bean.ResVideo;
import com.hja.feature_home.config.HomeConfig;
import com.hja.network.RetrofitProvider;
import com.hja.network.bean.ResBase;
import com.hja.network.bean.ResList;
import com.hja.network.config.ErrorStatusConfig;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class VideoListModel {

    private static final String TAG = "VideoListModel";

    private final HomeApiService mApiService;
    private IVideoListListenner mListenner;

    private int mPage = 1;//当前请求的页数
    private final int mLimit = 10;

    public VideoListModel(IVideoListListenner listenner) {

        Retrofit retrofit = RetrofitProvider.provide();

        mApiService = retrofit.create(HomeApiService.class);

        mListenner = listenner;
    }

    /**
     * 请求推荐页、日报页的数据
     *
     * @param pageType 是推荐页还是日报页？
     * @param isFirst  是不是第一次加载？
     */
    public void requestData(int pageType, boolean isFirst) {
        if (isFirst) {
            mPage = 1;
        } else {
            mPage++;
        }
        HomeApiService apiService = HomeApiServiceProvider.getApiService();
        Call<ResBase<ResList<ResVideo>>> call;
        if (pageType == HomeConfig.VIDEO_LIST_FRAGMENT_RECOMMEND) {
            call = apiService.getRecommend(mPage, mLimit);
        } else {
            call = apiService.getDaily(mPage, mLimit);
        }
        call.enqueue(new Callback<ResBase<ResList<ResVideo>>>() {
            @Override
            public void onResponse(Call<ResBase<ResList<ResVideo>>> call, Response<ResBase<ResList<ResVideo>>> response) {
                //网络请求是否成功
                if (response.isSuccessful()) {
                    Log.i(TAG, "onResponse: 请求成功");
                    ResBase<ResList<ResVideo>> body = response.body();
                    if (body.getCode() == 1) {
                        Log.i(TAG, "onResponse: 数据请求成功");
                        if (body.getData().getList().size() > 0) {
                            mListenner.onLoadFinish(isFirst, body.getData());
                        } else {
                            mListenner.onLoadFial(ErrorStatusConfig.ERROR_STATUS_EMPTY, "当前列表没有数据！");
                        }
                    } else {
                        //服务器告诉我们，数据请求失败
                        mListenner.onLoadFial(ErrorStatusConfig.ERROR_STATUS_SERVER_ERROR, body.getMsg());
                    }
                } else {
                    mListenner.onLoadFial(ErrorStatusConfig.ERROR_STATUS_NETWORK_FIAL, "网络请求失败，请检查网络！");
                }
            }

            @Override
            public void onFailure(Call<ResBase<ResList<ResVideo>>> call, Throwable throwable) {
                //网络请求失败   超时、网络异常...
                mListenner.onLoadFial(ErrorStatusConfig.ERROR_STATUS_NETWORK_FIAL, "网络请求失败，请检查网络！");
            }
        });
    }
}
