package com.huaxiao.smartmock.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.huaxiao.smartmock.R;
import com.huaxiao.smartmock.model.TreeNode;

/**
 * Created by sunhuaxiao on 2018/11/12.
 */
public class KeyValueViewHolder extends TreeNode.BaseNodeViewHolder<Object> {

    private static final String STATUS_CHANGE = "change";
    private static final String STATUS_ADD = "add";

    public KeyValueViewHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(final TreeNode node, Object value) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.view_key_value_tree_node, null);

        return rootView;
    }

}
