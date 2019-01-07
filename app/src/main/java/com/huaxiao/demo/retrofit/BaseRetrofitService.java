package com.huaxiao.demo.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by sunhuaxiao on 2019/1/7.
 */
public interface BaseRetrofitService {

    @Domain(RetrofitContants.DOMAIN_BASE)
    @GET("api/nodes/show.json")
    Call<V2EXBean> getV2EX(@Query("name") String name);

}
