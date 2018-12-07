package com.huaxiao.demo.leetcode;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.huaxiao.demo.R;
import com.huaxiao.demo.base.BaseActivity;

public class LeetCodeActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_leet_code);
    }
}
