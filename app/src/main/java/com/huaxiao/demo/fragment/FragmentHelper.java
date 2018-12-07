package com.huaxiao.demo.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by sunhuaxiao on 2018/11/12.
 */
public class FragmentHelper {

    public static void addFragment(Fragment fragment, FragmentManager fragmentManager, int container) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(container, fragment);
        beginTransaction.commit();
    }

}
