package com.huaxiao.demo.base;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;

import com.huaxiao.demo.mvp.BasePresenter;

/**
 * Description TODO
 * Author sunhuaxiao
 * Date 2018/4/24
 */
@SuppressLint("Registered")
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

}
