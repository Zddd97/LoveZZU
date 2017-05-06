package com.gjf.lovezzu.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.activity.treehole.TreeHoleActivity;
import com.gjf.lovezzu.entity.TreeHole;

import java.util.ArrayList;
import java.util.List;

import static com.gjf.lovezzu.R.id.tree_item_view;

/**
 * Created by zhao on 2017/5/4.
 */

public class TreeHoleAdapter extends RecyclerView.Adapter<TreeHoleAdapter.ViewHolder> {

    private List<TreeHole> treeHoleList = new ArrayList<>();
    private TreeHole treeHole;

    public TreeHoleAdapter(List<TreeHole> treeHoleList) {
        this.treeHoleList = treeHoleList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tree_hole_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //单条详情
                Toast.makeText(TreeHoleActivity.treeHoleActivity, "详情评论页", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.zanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点赞增加的逻辑
                Toast.makeText(TreeHoleActivity.treeHoleActivity, "点赞增加", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.talkView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //讨论操作的操作
                Toast.makeText(TreeHoleActivity.treeHoleActivity, "评论操作", Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        treeHole = treeHoleList.get(position);
        holder.contentView.setText(treeHole.getTreeContent());
        holder.zanView.setText(treeHole.getZanNumber());
        holder.talkView.setText(treeHole.getTalkNumber());
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
