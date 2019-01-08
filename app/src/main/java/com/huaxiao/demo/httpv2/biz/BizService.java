package com.huaxiao.demo.httpv2.biz;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sunhuaxiao on 2019/1/7.
 */
public interface BizService {

    @GET("api/nodes/show.json")
    Call<BizBean> getNodeInfo(@Query("name") String name);

}
