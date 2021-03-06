package com.huaxiao.smartmock.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.huaxiao.smartmock.R;
import com.huaxiao.smartmock.model.TreeNode;
import com.huaxiao.smartmock.view.ActionView;

/**
 * Created by sunhuaxiao on 2018/11/12.
 */
public class UrlViewHolder extends BaseViewHolder {

    public UrlViewHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, Object value) {
        final View rootView = LayoutInflater.from(context).inflate(R.layout.view_url_tree_node, null);

        Button btnAction = rootView.findViewById(R.id.btn_sm_url_action);
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
        mActionView.showActions(ActionView.ID_MAPLOCAL);
    }
}
