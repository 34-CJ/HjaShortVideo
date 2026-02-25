package com.hja.libbase.base;

import android.app.Application;

import com.alibaba.android.arouter.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 当前工程中的Application基类
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //在调试模式下
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }

        //初始化ARouter
        ARouter.init(this);
    }
}
