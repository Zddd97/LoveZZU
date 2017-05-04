package com.gjf.lovezzu.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.TreeHole;

import java.util.List;

import static com.gjf.lovezzu.R.id.id_content;
import static com.gjf.lovezzu.R.id.tree_item_view;

/**
 * Created by zhao on 2017/5/4.
 */

public class TreeHoleAdapter extends RecyclerView.Adapter<TreeHoleAdapter.ViewHolder> {

    private List<TreeHole> treeHoleList;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return treeHoleList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View mitemView;
        TextView contentView;
        TextView testView;
        TextView zanView;
        TextView talkView;

        public ViewHolder(View itemView) {
            super(itemView);
            mitemView = itemView.findViewById(tree_item_view);
            contentView = (TextView) itemView.findViewById(R.id.tree_content);
            testView = (TextView) itemView.findViewById(R.id.tree_item_author);
            zanView = (TextView) itemView.findViewById(R.id.tree_nice);
            talkView = (TextView) itemView.findViewById(R.id.tree_talk);
        }
    }
}
