package com.huaxiao.demo.http;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * Description 回调进度
 * Author sunhuaxiao
 * Date 2017/11/1
 */

public class ProgressResponseBody extends ResponseBody {

    private ResponseBody mResponseBody;
    private ProgressListener mProgressListener;
    private BufferedSource mBufferedSource;

    public ProgressResponseBody(ResponseBody responseBody, ProgressListener listener) {
        mResponseBody = responseBody;
        mProgressListener = listener;
    }

    interface ProgressListener {
        /**
         * @param bytesRead     已经读取的字节数
         * @param contentLength 响应总长度
         * @param done          是否读取完毕
         */
        void onProgress(long bytesRead, long contentLength, boolean done);
    }

    @Override
    public MediaType contentType() {
        return mResponseBody.contentType();
    }

    @Override
    public long contentLength() {
        return mResponseBody.contentLength();
    }

    @Override
    public BufferedSource source() {
        if (mBufferedSource == null) {
            mBufferedSource = Okio.buffer(source(mResponseBody.source()));
        }
        return mBufferedSource;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) {
            long mTotalBytesRead = 0L;

            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                long bytesRead = super.read(sink, byteCount);
                // 不断统计当前下载好的数据
                mTotalBytesRead += bytesRead != -1 ? bytesRead : 0;
                // 接口回调
                mProgressListener.onProgress(
                        mTotalBytesRead,
                        mResponseBody.contentLength(),
                        bytesRead == -1);
                return bytesRead;
            }
        };
    }
}
