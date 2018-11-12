package com.huaxiao.smartmock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SmartMockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_mock);

        FragmentHelper.addFragment(new SmartMockFragment(), getFragmentManager(), R.id.sm_container);
    }
}
