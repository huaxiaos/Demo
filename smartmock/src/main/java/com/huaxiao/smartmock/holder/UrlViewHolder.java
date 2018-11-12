package com.huaxiao.smartmock.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huaxiao.smartmock.R;
import com.huaxiao.smartmock.model.TreeNode;

/**
 * Created by sunhuaxiao on 2018/11/12.
 */
public class UrlViewHolder extends TreeNode.BaseNodeViewHolder<Object> {

    public UrlViewHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, Object value) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.view_url_tree_node, null);
        return rootView;
    }
}
