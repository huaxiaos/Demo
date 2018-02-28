package com.huaxiao.demo.spider;

import com.huaxiao.demo.http.DefaultRequestCallback;
import com.huaxiao.demo.http.HttpUtils;
import com.huaxiao.demo.utils.JsonUtils;
import com.huaxiao.demo.utils.LogUtils;

import java.util.List;

/**
 * Description TODO
 * Author sunhuaxiao
 * Date 2018/2/28
 */

public class SpiderPYX {

    private static final String TAG = "SpiderPYX";

    private static class PYXFilmData {
        public int filmid;
        public int userid;
    }

    private static class PYXFilmDetailData {
        public String film_url;
    }

    public static void start() {
        String url = "";
        HttpUtils.get(url, new DefaultRequestCallback() {
            @Override
            public void onResponse(String response) {
//                LogUtils.i(TAG, "response " + response);
                List<PYXFilmData> filmList = JsonUtils.parseArray(response, PYXFilmData.class);

                LogUtils.i(TAG, "list size " + filmList.size());

                for (int i = 0; i < filmList.size(); i++) {
//                    if (i == 1) {
                        getFilmDetail(filmList.get(i));
//                    }
                }
            }

            @Override
            public void onFailure(int code, String errMsg) {
                LogUtils.i(TAG, "err " + errMsg);
            }
        });
    }

    private static void getFilmDetail(PYXFilmData pyxFilmData) {
        String url = "";
        HttpUtils.get(url, new DefaultRequestCallback() {
            @Override
            public void onResponse(String response) {
//                LogUtils.i(TAG, "response " + response);
                PYXFilmDetailData filmDetailData = JsonUtils.parseObject(response, PYXFilmDetailData.class);
                LogUtils.i(TAG, "download url " + filmDetailData.film_url);
            }

            @Override
            public void onFailure(int code, String errMsg) {
                LogUtils.i(TAG, "errMsg " + errMsg);
            }
        });
    }

}
