package com.huaxiao.demo.httpv2.biz;

import com.huaxiao.demo.httpv2.core.BaseRequest;
import com.huaxiao.demo.httpv2.core.RequestListener;
import com.huaxiao.demo.httpv2.core.RequestManager;

/**
 * Created by sunhuaxiao on 2019/1/8.
 */
public class BizRequest extends BaseRequest {

    private static volatile BizRequest mInstance;
    private BizService mBizService;
    private BizServiceV2 mBizServiceV2;
    private static final String BASE_URL = "https://www.v2ex.com/";

    public static BizRequest getInstance() {
        if (mInstance == null) {
            synchronized (BizRequest.class) {
                if (mInstance == null) {
                    mInstance = new BizRequest();
                }
            }
        }
        return mInstance;
    }

    public BizRequest() {
        mBizService = RequestManager.getInstance().createService(BASE_URL, BizService.class);
        mBizServiceV2 = RequestManager.getInstance().createService(BASE_URL, BizServiceV2.class);
    }

    public void getInfo(String name, final RequestListener<BizBean> listener) {
        mBizService.getNodeInfo(name).enqueue(callback(listener));
    }

    public void getInfoV2(String name, final RequestListener<BizBean> listener) {
        mBizServiceV2.getNodeInfo(name).enqueue(callback(listener));
    }

}
