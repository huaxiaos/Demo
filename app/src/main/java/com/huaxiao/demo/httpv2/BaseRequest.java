package com.huaxiao.demo.httpv2;

/**
 * Created by sunhuaxiao on 2019/1/8.
 */
public class BaseRequest {

    private static volatile BaseRequest mInstance;
    private BaseRequestService mBaseRequestService;
    private BaseRequestServiceV2 mBaseRequestServiceV2;
    private static final String BASE_URL = "https://www.v2ex.com/";

    public static BaseRequest getInstance() {
        if (mInstance == null) {
            synchronized (BaseRequest.class) {
                if (mInstance == null) {
                    return mInstance;
                }
            }
        }
        return mInstance;
    }

    public BaseRequest() {
        mBaseRequestService = RetrofitManager.getInstance().createService(BASE_URL, BaseRequestService.class);
        mBaseRequestServiceV2 = RetrofitManager.getInstance().createService(BASE_URL, BaseRequestServiceV2.class);
    }

    public BaseRequestService getBaseRequestService() {
        return mBaseRequestService;
    }

    public BaseRequestServiceV2 getBaseRequestServiceV2() {
        return mBaseRequestServiceV2;
    }
}
