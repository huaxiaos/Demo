package com.huaxiao.smartmock;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huaxiao.smartmock.holder.UrlViewHolder;
import com.huaxiao.smartmock.model.TreeNode;
import com.huaxiao.smartmock.view.AndroidTreeView;

/**
 * Created by sunhuaxiao on 2018/11/12.
 */
public class SmartMockFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        @SuppressLint("InflateParams")
        View rootView = inflater.inflate(R.layout.fragment_smart_mock, null);
        ViewGroup treeContainer = rootView.findViewById(R.id.sm_tree_container);

        TreeNode root = TreeNode.root();
        TreeNode urlRoot = new TreeNode("url");
        TreeNode responseRoot = new TreeNode("response");

        urlRoot.addChildren(responseRoot);
        root.addChildren(urlRoot);

        AndroidTreeView treeView = new AndroidTreeView(getActivity(), root);
        treeView.setDefaultViewHolder(UrlViewHolder.class);
        treeContainer.addView(treeView.getView());

        return rootView;
    }
}
