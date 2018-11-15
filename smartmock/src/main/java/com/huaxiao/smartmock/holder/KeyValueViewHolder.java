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

    public static final String ACTION_CHANGE = "Change";
    public static final String ACTION_INSERT = "Insert";

    public KeyValueViewHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(final TreeNode node, Object value) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.view_key_value_tree_node, null);

        Button btnAction = rootView.findViewById(R.id.btn_sm_kv_action);
        btnAction.setText(ACTION_CHANGE);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = ((Button) v).getText().toString();
                if (ACTION_CHANGE.equals(text)) {
                    ((Button) v).setText(ACTION_INSERT);
                    mView.setBackgroundColor(Color.BLUE);
                } else if (ACTION_INSERT.equals(text)) {
                    ((Button) v).setText(ACTION_CHANGE);
                    mView.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });

        return rootView;
    }

}
