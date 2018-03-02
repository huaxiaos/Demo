package com.huaxiao.demo.spider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.huaxiao.demo.R;

public class SpiderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spider);

//        SpiderPYX.start();
        SpiderLocalFile.start();
    }
}
