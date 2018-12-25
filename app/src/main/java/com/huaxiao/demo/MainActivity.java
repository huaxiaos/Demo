package com.huaxiao.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.huaxiao.demo.base.BaseActivity;
import com.huaxiao.demo.service.RemoteProcess;
import com.huaxiao.module_a.ModuleAMainActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                startActivity(new Intent(this, ModuleAMainActivity.class));
                break;

            case R.id.button2:
                startService(new Intent(this, RemoteProcess.class));
                break;

            case R.id.button3:
                stopService(new Intent(this, RemoteProcess.class));
                break;

            default:
                break;
        }
    }

}
