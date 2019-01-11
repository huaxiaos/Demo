package com.huaxiao.demo.httpv2.biz;

import com.huaxiao.android.smartcore.http.RequestListener;
import com.huaxiao.demo.utils.LogUtils;

/**
 * Created by sunhuaxiao on 2019/1/8.
 */
public class BizDemo {

    public static void start() {
        BizRequest.getInstance().getInfo("python", new RequestListener<BizBean>() {
            @Override
            public void onResponse(BizBean bizBean) {
                LogUtils.i("huaxiao", "getInfo " + bizBean.header);
            }

            @Override
            public void onFailure(Throwable t) {
                LogUtils.i("huaxiao", "getInfo error " + t.getMessage());
            }
        });

        BizRequest.getInstance().getInfoV2("go", new RequestListener<BizBean>() {
            @Override
            public void onResponse(BizBean bizBean) {
                LogUtils.i("huaxiao", "getInfoV2 " + bizBean.header);
            }

            @Override
            public void onFailure(Throwable t) {
                LogUtils.i("huaxiao", "getInfoV2 error " + t.getMessage());
            }
        });
    }

}
