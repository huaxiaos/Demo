package com.huaxiao.demo.http;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Description TODO
 * Author sunhuaxiao
 * Date 2017/11/7
 */

public abstract class DefaultRequestCallback implements okhttp3.Callback {

    @Override
    public void onFailure(Call call, IOException e) {
        //网络异常
        onFailure(-1, e.getMessage());
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String responseMsg;
        try {
            responseMsg = response.body().string();
            DefaultResponseBean bean = JSON.parseObject(responseMsg, DefaultResponseBean.class);
            if (bean.code == 0) {
                onResponse(bean.data);
            } else {
                onFailure(bean.code, bean.msg);
            }
        } catch (Exception e) {
            onFailure(-10, e.getMessage());
        }
    }

    abstract public void onResponse(String response);

    abstract public void onFailure(int code, String errMsg);
}
