package com.huaxiao.demo.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.huaxiao.demo.R;
import com.huaxiao.demo.utils.LogUtils;
import com.huaxiao.demo.utils.ToastUtils;

public class FragmentDemoActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "FragmentDemoActivity";
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

        fragmentManager = getSupportFragmentManager();
        addFragment(new Fragment1(), "fragment1");

        Button button1 = findViewById(R.id.fragment_demo_btn_1);
        Button button2 = findViewById(R.id.fragment_demo_btn_2);
        Button button3 = findViewById(R.id.fragment_demo_btn_3);
        Button button4 = findViewById(R.id.fragment_demo_btn_4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_demo_btn_1:
                addFragment(new Fragment1(), "fragment1");
                break;

            case R.id.fragment_demo_btn_2:
                addFragment(new Fragment2(), "fragment2");
                break;

            case R.id.fragment_demo_btn_3:
                addFragment(new Fragment3(), "fragment3");
                break;

            case R.id.fragment_demo_btn_4:
                addFragment(new Fragment4(), "fragment4");
                break;
        }
    }

    public void addFragment(Fragment fragment, String tag) {
        // 开启事务
        FragmentTransaction beginTransaction = fragmentManager
                .beginTransaction();
        // 执行事务,添加Fragment
        beginTransaction.add(R.id.fragment_demo_container, fragment, tag);
        // 添加到回退栈,并定义标记
        beginTransaction.addToBackStack(tag);
        // 提交事务
        beginTransaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 判断当前按键是返回键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 获取当前回退栈中的Fragment个数
            int backStackEntryCount = fragmentManager.getBackStackEntryCount();
            // 判断当前回退栈中的fragment个数,
            if (backStackEntryCount > 1) {
                // 立即回退一步
                fragmentManager.popBackStackImmediate();
                // 获取当前退到了哪一个Fragment上,重新获取当前的Fragment回退栈中的个数
                FragmentManager.BackStackEntry backStack = fragmentManager
                        .getBackStackEntryAt(fragmentManager
                                .getBackStackEntryCount() - 1);
                // 获取当前栈顶的Fragment的标记值
                String tag = backStack.getName();
                // 判断当前是哪一个标记
                if ("fragment1".equals(tag)) {
                    // 设置首页选中
                    LogUtils.i(TAG, "fragment1 pop");
                } else if ("fragment2".equals(tag)) {
                    // 设置购物车的tag
                    LogUtils.i(TAG, "fragment2 pop");
                } else if ("fragment3".equals(tag)) {
                    LogUtils.i(TAG, "fragment3 pop");
                } else if ("fragment4".equals(tag)) {
                    LogUtils.i(TAG, "fragment4 pop");
                }
            } else {
                //回退栈中只剩一个时,退出应用
                finish();
            }

            return false;
        }
        return true;
    }
}
