package com.example.myapplication;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：陈飞
 * 时间：2019/11/06 14:02
 */
class RetrofitHelper {

    private static Retrofit retrofit;
    private static OkHttpClient client = new OkHttpClient();
    private static Converter.Factory factory = GsonConverterFactory.create();

    //初始化
    static void init() {
        retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL)
                .client(client)
                .addConverterFactory(factory)
                .build();
    }

    static RetrofitService getServer() {
        return retrofit.create(RetrofitService.class);
    }
}
