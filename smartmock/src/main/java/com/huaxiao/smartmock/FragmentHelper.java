package com.huaxiao.smartmock;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

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
