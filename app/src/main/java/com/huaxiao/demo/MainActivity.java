package com.huaxiao.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.huaxiao.demo.annotation.AnnotationDemo;
import com.huaxiao.demo.base.BaseActivity;
import com.huaxiao.demo.bitmap.Bitmap1Activity;
import com.huaxiao.demo.classloader.ClassLoader;
import com.huaxiao.demo.handler.HandlerTestActivity;
import com.huaxiao.demo.java.SynchronizedDemo;
import com.huaxiao.demo.proxy.ProxyDemoActivity;
import com.huaxiao.demo.scan.Scan2Activity;
import com.huaxiao.demo.scan.Scan3Activity;
import com.huaxiao.demo.scan.ScanActivity;
import com.huaxiao.demo.spider.SpiderActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, ProxyDemoActivity.class);
                startActivity(intent);
//                ClassLoader.main(null);
                break;

            default:
                break;
        }
    }
}
