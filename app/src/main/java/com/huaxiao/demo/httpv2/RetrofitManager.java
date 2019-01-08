package com.huaxiao.demo.httpv2;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sunhuaxiao on 2019/1/7.
 */
public class RetrofitManager {

    private static volatile RetrofitManager mInstance;
    private OkHttpClient mOkHttpClient;

    public static RetrofitManager getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }

        return mInstance;
    }

    public RetrofitManager() {
        mOkHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new HostSelectionInterceptor())
                .build();
    }

    public <T> T createService(@NonNull String baseUrl, @NonNull Class<T> service) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(service);
    }

    public void enqueue() {

    }

}
