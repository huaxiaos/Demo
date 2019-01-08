package com.huaxiao.demo.httpv2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sunhuaxiao on 2019/1/8.
 */
public class HttpV2Demo {

    public static void start() {
        BaseRequest.getInstance()
                .getBaseRequestService()
                .getNodeInfo("python")
                .enqueue(new Callback<V2EXBean>() {
                    @Override
                    public void onResponse(Call<V2EXBean> call, Response<V2EXBean> response) {

                    }

                    @Override
                    public void onFailure(Call<V2EXBean> call, Throwable t) {

                    }
                });
    }

}
