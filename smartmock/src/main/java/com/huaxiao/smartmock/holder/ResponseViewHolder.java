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
public class ResponseViewHolder extends BaseViewHolder {

    public ResponseViewHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(final TreeNode node, Object value) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.view_response_tree_node, null);

        Button btnAdd = rootView.findViewById(R.id.btn_sm_response_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TreeNode kvRoot = new TreeNode("kv");
                kvRoot.setViewHolder(new KeyValueViewHolder(context));
                getTreeView().addNode(node, kvRoot);
            }
        });

        return rootView;
    }
}
