package com.huaxiao.demo.httpv2.core;

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

    private <T> Callback<T> callback(final RequestListener<T> listener) {
        return new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (listener != null) {
                    listener.onResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                if (listener != null) {
                    listener.onFailure(t);
                }
            }
        };
    }

}
