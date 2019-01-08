package com.huaxiao.demo.httpv2.core;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sunhuaxiao on 2019/1/8.
 */
public class BaseRequest {

    public <T> Callback<T> callback(final RequestListener<T> listener) {
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
