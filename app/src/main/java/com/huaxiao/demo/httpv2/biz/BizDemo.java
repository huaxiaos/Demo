package com.huaxiao.demo.httpv2.biz;

import com.huaxiao.demo.httpv2.core.RequestListener;

/**
 * Created by sunhuaxiao on 2019/1/8.
 */
public class BizDemo {

    public static void start() {
        BizRequest.getInstance().getInfo("python", new RequestListener<BizBean>() {
            @Override
            public void onResponse(BizBean bizBean) {
                
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

}
