package com.gjf.lovezzu.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.activity.treehole.TreeHoleActivity;
import com.gjf.lovezzu.activity.treehole.TreeHoleContentActivity;
import com.gjf.lovezzu.entity.TreeHoleResult;

import java.util.ArrayList;
import java.util.List;

import static com.gjf.lovezzu.R.id.tree_hole_content_id;
import static com.gjf.lovezzu.R.id.tree_item_view;

/**
 * Created by BlackBeard丶 on 2017/5/23.
 */

public class TreeHoleContentAdapter  extends RecyclerView.Adapter<TreeHoleContentAdapter.ViewHolder> {

    private List<TreeHoleResult> treeHoleResultList = new ArrayList<>();
    private TreeHoleResult treeHoleResult;

    public TreeHoleContentAdapter(List<TreeHoleResult> treeHoleResultList) {
        this.treeHoleResultList = treeHoleResultList;
    }

    @Override
    public TreeHoleContentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tree_comment_view, parent, false);
        final TreeHoleContentAdapter.ViewHolder viewHolder = new TreeHoleContentAdapter.ViewHolder(view);

        viewHolder.zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点赞增加的逻辑
                Toast.makeText(TreeHoleActivity.
                        treeHoleActivity, "点赞增加", Toast.LENGTH_SHORT).show();
                TreeHoleContentActivity treeHoleContentActivity = new TreeHoleContentActivity();
            }
        });

       return viewHolder;
    }

    @Override
    public void onBindViewHolder(TreeHoleContentAdapter.ViewHolder holder, int position) {
        treeHoleResult = treeHoleResultList.get(position);
        holder.contentView.setText(treeHoleResult.getTreeContent());
        holder.zanView.setText(treeHoleResult.getZanNumber());
        holder.id.setText(treeHoleResult.getTalkNumber());

    }

    @Override
    public int getItemCount() {
        return treeHoleResultList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View mitemView;
        TextView contentView;
        TextView id;
        TextView zanView;
        ImageView zan;


        public ViewHolder(View itemView) {
            super(itemView);
            mitemView = itemView.findViewById(tree_item_view);
            contentView = (TextView) itemView.findViewById(R.id.tree_hole_comment_content);
            zanView = (TextView) itemView.findViewById(R.id.tree_hole_comment_zan);
            id = (TextView)itemView.findViewById(tree_hole_content_id);
            zan = (ImageView)itemView.findViewById(R.id.tree_hole_comment_zan_imageview);
        }
    }
}
