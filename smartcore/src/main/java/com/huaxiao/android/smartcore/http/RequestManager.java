package com.huaxiao.android.smartcore.http;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sunhuaxiao on 2019/1/7.
 */
public class RequestManager {

    private static volatile RequestManager mInstance;
    private OkHttpClient mOkHttpClient;

    public static RequestManager getInstance() {
        if (mInstance == null) {
            synchronized (RequestManager.class) {
                if (mInstance == null) {
                    mInstance = new RequestManager();
                }
            }
        }

        return mInstance;
    }

    public RequestManager() {
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

}
