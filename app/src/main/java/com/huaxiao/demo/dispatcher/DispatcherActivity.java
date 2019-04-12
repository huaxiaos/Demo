package com.huaxiao.demo.dispatcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.huaxiao.demo.R;

/**
 * ACTION_DOWN 0
 * ACTION_UP 1
 * ACTION_MOVE 2
 * ACTION_CANCEL 3
 */
public class DispatcherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatcher);
    }
}
