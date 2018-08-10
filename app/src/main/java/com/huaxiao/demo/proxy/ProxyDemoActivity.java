package com.huaxiao.demo.proxy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.huaxiao.demo.R;
import com.huaxiao.demo.utils.LogUtils;

import java.lang.reflect.Proxy;

public class ProxyDemoActivity extends AppCompatActivity {

    private static final String TAG = "Proxy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy_demo);

        TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(new OperateImpl());
        IOperate operate = (IOperate) Proxy.newProxyInstance(
                IOperate.class.getClassLoader(),
                new Class[]{IOperate.class},
                timeInvocationHandler);

        LogUtils.i(TAG, "start method1");
        operate.method1();

        LogUtils.i(TAG, "start method2");
        operate.method2();

        LogUtils.i(TAG, "start method3");
        operate.method3();
    }
}
