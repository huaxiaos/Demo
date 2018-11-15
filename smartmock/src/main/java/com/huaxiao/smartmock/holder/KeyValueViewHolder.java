package com.huaxiao.smartmock.holder;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.huaxiao.smartmock.R;
import com.huaxiao.smartmock.model.TreeNode;
import com.huaxiao.smartmock.view.ActionView;

/**
 * Created by sunhuaxiao on 2018/11/12.
 */
public class KeyValueViewHolder extends BaseViewHolder {

    private static final String STATUS_CHANGE = "change";
    private static final String STATUS_ADD = "add";

    public KeyValueViewHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(final TreeNode node, Object value) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.view_key_value_tree_node, null);

        Button btnAction = rootView.findViewById(R.id.btn_sm_kv_action);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActionView.show();
            }
        });

        return rootView;
    }

    @Override
    public void onNodeViewCreate(View nodeView) {
        super.onNodeViewCreate(nodeView);
        mActionView.showActions(ActionView.ID_STATUS);
    }

    @Override
    public void onActionViewItemClick(MenuItem item) {
        super.onActionViewItemClick(item);
        if (item.getItemId() == ActionView.ID_STATUS) {
            if (ActionView.TITLE_CHANGE.equals(item.getTitle().toString())) {
                item.setTitle(ActionView.TITLE_CREATE);
                mView.setBackgroundColor(Color.TRANSPARENT);
            } else if (ActionView.TITLE_CREATE.equals(item.getTitle().toString())) {
                item.setTitle(ActionView.TITLE_CHANGE);
                mView.setBackgroundColor(Color.BLUE);
            }
        }
    }
}
