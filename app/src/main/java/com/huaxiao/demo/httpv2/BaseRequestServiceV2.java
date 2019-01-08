package com.huaxiao.demo.httpv2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sunhuaxiao on 2019/1/7.
 */
public interface BaseRequestServiceV2 {

    @GET("api/nodes/show.json")
    Call<V2EXBean> getNodeInfo(@Query("name") String name);

}
