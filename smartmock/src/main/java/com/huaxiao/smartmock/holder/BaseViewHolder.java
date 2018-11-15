package com.huaxiao.smartmock.holder;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;

import com.huaxiao.smartmock.model.TreeNode;
import com.huaxiao.smartmock.view.ActionView;

/**
 * Created by sunhuaxiao on 2018/11/15.
 */
public class BaseViewHolder extends TreeNode.BaseNodeViewHolder<Object> {

    public ActionView mActionView;

    public BaseViewHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, Object value) {
        return null;
    }

    @Override
    public void onNodeViewCreate(View nodeView) {
        super.onNodeViewCreate(nodeView);
        mActionView = new ActionView(context, nodeView);
        mActionView.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                onActionViewItemClick(item);
                return false;
            }
        });
    }

    public void onActionViewItemClick(MenuItem item) {
        if (item.getItemId() == ActionView.ID_DELETE) {
            int size = mNode.getParent().getChildren().size();
            if (size <= 1) {
                return;
            }
            getTreeView().removeNode(mNode);
        }
    }
}
