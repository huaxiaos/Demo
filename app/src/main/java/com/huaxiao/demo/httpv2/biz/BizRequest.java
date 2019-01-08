package com.huaxiao.demo.httpv2.biz;

import com.huaxiao.demo.httpv2.core.BaseRequest;
import com.huaxiao.demo.httpv2.core.RequestListener;
import com.huaxiao.demo.httpv2.core.RequestManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                    return mInstance;
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

}
