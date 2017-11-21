package com.huaxiao.demo.http;

import android.content.Context;
import android.util.Base64;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


/**
 * Description 网络层封装
 * Author sunhuaxiao
 * Date 2017/11/1
 */

public class HttpUtils {

    private static OkHttpClient mClient = null;

    public interface ProgressListener {
        void onProgress(long bytesRead, long contentLength, boolean done);

        void onFailure(String msg);
    }

    private static OkHttpClient getInstance() {
        if (mClient == null) {
            synchronized (HttpUtils.class) {
                if (mClient == null)
                    mClient = new OkHttpClient();
            }
        }
        return mClient;
    }

    public static void downloadFile(String url,
                                    final String fileDir,
                                    final String fileName,
                                    final ProgressListener listener) {
        OkHttpHelper.downloadFile(url, fileDir, fileName,
                new OkHttpHelper.ProgressListener() {
                    @Override
                    public void onProgress(long bytesRead, long contentLength, boolean done) {
                        listener.onProgress(bytesRead, contentLength, done);
                    }

                    @Override
                    public void onFailure(String msg) {
                        listener.onFailure(msg);
                    }
                });
    }

    public static void uploadFile(File file, String url, final ProgressListener listener) {
        uploadFile(file, url, null, listener);
    }

    public static void uploadFile(File file,
                                  String url,
                                  Map<String, String> map,
                                  final ProgressListener listener) {
        OkHttpHelper.uploadFile(file, url, map, new OkHttpHelper.ProgressListener() {
            @Override
            public void onProgress(long bytesRead, long contentLength, boolean done) {
                listener.onProgress(bytesRead, contentLength, done);
            }

            @Override
            public void onFailure(String msg) {
                listener.onFailure(msg);
            }
        });
    }

    public static void post(String url,
                            RequestBody requestBodyPost,
                            DefaultRequestCallback callback) {
        Request requestPost = new Request.Builder().url(url).post(requestBodyPost).build();
        getInstance().newCall(requestPost).enqueue(callback);
    }

    public static void get(String url, DefaultRequestCallback callback) {
        Request requestPost = new Request.Builder().url(url).build();
        getInstance().newCall(requestPost).enqueue(callback);
    }

    private static String base64(String s) {
        String base64 = "";

        try {
            base64 = Base64.encodeToString(s.getBytes("utf-8"), Base64.NO_WRAP);
        } catch (UnsupportedEncodingException e) {
            // Empty
        }

        return base64;
    }

    public static String md5(String s) {
        return MD5Utils.md5LowerCase(s);
    }

    public static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

}
