package com.huaxiao.demo.http;

import android.text.TextUtils;

import com.huaxiao.demo.utils.LogUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static java.lang.String.valueOf;

/**
 * Description OkHttp封装
 * Author sunhuaxiao
 * Date 2017/11/1
 */

public class OkHttpHelper {

    private static final String TAG = "OkHttpHelper";
    private static OkHttpClient mClient = null;

    public static OkHttpClient getInstance() {
        if (mClient == null) {
            synchronized (OkHttpHelper.class) {
                if (mClient == null)
                    mClient = new OkHttpClient();
            }
        }
        return mClient;
    }

    public interface ProgressListener {
        void onProgress(long bytesRead, long contentLength, boolean done);

        void onFailure(String msg);
    }

    public static void downloadFile(String url,
                                    final String fileDir,
                                    final String fileName,
                                    final ProgressListener listener) {
        if (TextUtils.isEmpty(url)) {
            listener.onFailure("url is empty");
            return;
        }

        Request request = new Request.Builder()
                .url(url)
                .build();

        final ProgressResponseBody.ProgressListener progressListener =
                new ProgressResponseBody.ProgressListener() {
                    @Override
                    public void onProgress(long bytesRead, long contentLength, boolean done) {
                        listener.onProgress(bytesRead, contentLength, done);
                    }
                };

        OkHttpClient client = getInstance().newBuilder()
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Response response = chain.proceed(chain.request());
                        return response.newBuilder()
                                .body(new ProgressResponseBody(response.body(), progressListener))
                                .build();
                    }
                })
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onFailure(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len;
                FileOutputStream fos = null;
                try {
                    is = response.body().byteStream();
                    File file = new File(fileDir, fileName);
                    fos = new FileOutputStream(file);
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    fos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (is != null) is.close();
                    if (fos != null) fos.close();
                }
            }
        });
    }

    public static void uploadFile(File file,
                                  String url,
                                  Map<String, String> map,
                                  final ProgressListener listener) {
        if (file == null || !file.exists() || listener == null) return;

        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), RequestBody.create(null, file));

        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                builder.addFormDataPart(valueOf(entry.getKey()), valueOf(entry.getValue()));
            }
        }

        RequestBody requestBody = builder.build();

        Request request = new Request.Builder()
                .url(url)
                .post(addProgressRequestListener(requestBody, listener))
                .build();

        getInstance().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onFailure(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtils.d(TAG, response.body().toString());
            }
        });
    }

    /**
     * 包装请求体用于上传文件的回调
     *
     * @param requestBody             请求体RequestBody
     * @param progressRequestListener 进度回调接口
     * @return 包装后的进度回调请求体
     */
    public static ProgressRequestBody addProgressRequestListener(RequestBody requestBody,
                                                                 ProgressListener progressRequestListener) {
        return new ProgressRequestBody(requestBody, progressRequestListener);
    }

}
