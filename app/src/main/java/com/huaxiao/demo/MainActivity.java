package com.huaxiao.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.huaxiao.demo.base.BaseActivity;
import com.huaxiao.demo.fragment.FragmentHelper;
import com.huaxiao.demo.mvp.demo1.impl.MVPDemo1Activity;
import com.huaxiao.demo.mvp.demo1.impl.MVPDemo1Fragment;

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
//                try {
//                    DemoException.run();
//                } catch (Exception t) {
//                    t.printStackTrace();
//                }

//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName("pkg name",
//                        "service name"));
//                startService(intent);

                startActivity(new Intent(this, MVPDemo1Activity.class));

                break;

            case R.id.button2:
//                intent = new Intent();
//                intent.setAction("com.huaxiao.demo.test");
//                sendBroadcast(intent);

//                SPIDemo.run();

                MVPDemo1Fragment fragment = new MVPDemo1Fragment();
                FragmentHelper.addFragment(fragment, getSupportFragmentManager(), R.id.fragment_container);

                break;

            default:
                break;
        }
    }

}
