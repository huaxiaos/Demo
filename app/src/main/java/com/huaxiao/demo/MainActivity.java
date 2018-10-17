package com.huaxiao.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.huaxiao.demo.annotation.AnnotationDemo;
import com.huaxiao.demo.aspectj.AspectJ1;
import com.huaxiao.demo.base.BaseActivity;
import com.huaxiao.demo.bitmap.Bitmap1Activity;
import com.huaxiao.demo.classloader.ClassLoader;
import com.huaxiao.demo.fragment.FragmentDemoActivity;
import com.huaxiao.demo.handler.HandlerTestActivity;
import com.huaxiao.demo.java.SynchronizedDemo;
import com.huaxiao.demo.mvvm.MVVMActivity;
import com.huaxiao.demo.proxy.ProxyDemoActivity;
import com.huaxiao.demo.scan.Scan2Activity;
import com.huaxiao.demo.scan.Scan3Activity;
import com.huaxiao.demo.scan.ScanActivity;
import com.huaxiao.demo.service.DemoService;
import com.huaxiao.demo.spi.SPIDemo;
import com.huaxiao.demo.spider.SpiderActivity;

import static android.content.Intent.FLAG_INCLUDE_STOPPED_PACKAGES;

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
                Intent intent = new Intent(this, FragmentDemoActivity.class);
                startActivity(intent);
//                ClassLoader.main(null);

//                AspectJ1 aspectJ1 = new AspectJ1();
//                aspectJ1.run();

//                Intent intent = new Intent();
//                intent.setAction("com.huaxiao.demo.test");
//                sendBroadcast(intent);

//                Intent intent = new Intent(this, DemoService.class);
//                startService(intent);

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
