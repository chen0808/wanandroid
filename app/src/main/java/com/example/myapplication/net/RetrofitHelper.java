package com.example.myapplication.net;

import com.example.myapplication.base.Constant;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：陈飞
 * 时间：2019/11/06 14:02
 */
public class RetrofitHelper {

    private static Retrofit retrofit;
    private static RetrofitHelper manager;
    private static RetrofitApi retrofitApi;


    public static RetrofitHelper getInstance() {
        if (manager == null) {
            synchronized (RetrofitHelper.class) {
                manager = new RetrofitHelper();
            }
        }
        return manager;
    }

    //初始化
    public void init() {
        //okHttpClient
        Interceptor log = new HttpLoggingInterceptor();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(log)//对okHttp添加log打印
                .build();

        //converterFactory
        Converter.Factory converterFactory = GsonConverterFactory.create();
        //CallAdapterFactory
        RxJava2CallAdapterFactory callAdapterFactory = RxJava2CallAdapterFactory.create();
        retrofit = new Retrofit.Builder()//retrofitBuilder
                .baseUrl(Constant.BASE_URL)//url
                .client(client)//okHttp
                .addConverterFactory(converterFactory)//gson
                .addCallAdapterFactory(callAdapterFactory)//rxJava
                .build();
    }

    public static RetrofitApi getRequest() {
        if (retrofitApi == null) {
            synchronized (RetrofitApi.class) {
                retrofitApi = retrofit.create(RetrofitApi.class);
            }
        }
        return retrofitApi;
    }
}
