package com.huaxiao.demo.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.huaxiao.demo.R;
import com.huaxiao.demo.utils.LogUtils;

public class HandlerTestActivity extends AppCompatActivity {

    private static final String TAG = "HandlerTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Handler handler = new Handler(getMainLooper(), new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {
                        switch (msg.what) {
                            case 1:
                                LogUtils.i(TAG, "msg.what 1");
                                break;
                        }
                        return false;
                    }
                });
                handler.sendEmptyMessage(1);
            }
        }).start();
    }

}
