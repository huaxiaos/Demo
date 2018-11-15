package com.huaxiao.smartmock.view;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.view.View;

import com.huaxiao.smartmock.R;

/**
 * Created by sunhuaxiao on 2018/11/15.
 */
public class ActionView extends PopupMenu {

    public static final int ID_MAPLOCAL = R.id.menu_sm_action_maplocal;
    public static final int ID_STATUS = R.id.menu_sm_action_status;
    public static final int ID_DELETE = R.id.menu_sm_action_delete;

    public ActionView(Context context, View anchor) {
        super(context, anchor);
        init();
    }

    public ActionView(Context context, View anchor, int gravity) {
        super(context, anchor, gravity);
        init();
    }

    public ActionView(Context context, View anchor, int gravity, int popupStyleAttr, int popupStyleRes) {
        super(context, anchor, gravity, popupStyleAttr, popupStyleRes);
        init();
    }

    private void init() {
        getMenuInflater().inflate(R.menu.menu_sm_action, getMenu());
    }

    public void showActions(int... ids) {
        for (int id : ids) {
            getMenu().findItem(id).setVisible(true);
        }
    }

}
