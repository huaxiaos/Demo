package com.huaxiao.demo.dispatcher;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by sunhuaxiao on 2019/4/12.
 */
public class ViewB extends RelativeLayout {
    public ViewB(Context context) {
        super(context);
    }

    public ViewB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.i("huaxiao", "ViewB dispatchTouchEvent " + ev.getAction());
//        return super.dispatchTouchEvent(ev);
//    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("huaxiao", "ViewB onInterceptTouchEvent " + ev.getAction());

        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            return true;
        }

        return false;
    }
}
