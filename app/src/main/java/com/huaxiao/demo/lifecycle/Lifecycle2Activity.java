package com.huaxiao.demo.lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.huaxiao.demo.R;
import com.huaxiao.demo.helper.LogHelper;

public class Lifecycle2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle2);

        LogHelper.e("2 onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogHelper.e("2 onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogHelper.e("2 onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogHelper.e("2 onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogHelper.e("2 onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogHelper.e("2 onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogHelper.e("2 onDestory");
    }
}
