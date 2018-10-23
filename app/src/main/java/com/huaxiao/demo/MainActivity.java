package com.huaxiao.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.huaxiao.demo.base.BaseActivity;
import com.huaxiao.demo.exception.DemoException;
import com.huaxiao.demo.fragment.FragmentDemoActivity;
import com.huaxiao.demo.spi.SPIDemo;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                try {
                    DemoException.run();
                } catch (Exception t) {
                    t.printStackTrace();
                }

                break;

            case R.id.button2:
//                intent = new Intent();
//                intent.setAction("com.huaxiao.demo.test");
//                sendBroadcast(intent);

                SPIDemo.run();

                break;

            default:
                break;
        }
    }
}
