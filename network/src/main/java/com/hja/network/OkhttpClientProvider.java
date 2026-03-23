package com.hja.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * 项目中的OkHttpClient统一在这里获取，以便统一管理
 */
public class OkhttpClientProvider {
    public static OkHttpClient provide() {
        OkHttpClient build = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        return build;
    }
}
