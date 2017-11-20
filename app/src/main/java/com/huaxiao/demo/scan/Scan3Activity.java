package com.huaxiao.demo.scan;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.huaxiao.demo.R;
import com.huaxiao.demo.utils.LogUtils;

public class Scan3Activity extends AppCompatActivity {

    private static final String TAG = "Scan3Activity";
    private MyFileObserver mObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan3);

        String filename = Environment.getExternalStorageDirectory().toString();

        LogUtils.d(TAG, "filename " + filename);

        mObserver = new MyFileObserver(filename);

        mObserver.startWatching();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mObserver.stopWatching();
    }
}
