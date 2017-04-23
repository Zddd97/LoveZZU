package com.gjf.lovezzu.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.activity.palytogether.PlayGroupListActivity;
import com.gjf.lovezzu.entity.PlayEnd;

import java.util.List;

/**
 * Created by zhaox on 2017/4/20.
 */

public class PlayGroupListAdapter extends RecyclerView.Adapter<PlayGroupListAdapter.ViewHolder> {

    List<PlayEnd> playEndList;
    PlayEnd playEnd;
    public PlayGroupListAdapter(List<PlayEnd> playEndList) {
        this.playEndList = playEndList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.play_group_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.joinGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(PlayGroupListActivity.playGroupListActivity);
                dialog.setTitle(holder.groupName.getText());
                dialog.setMessage("是否加入" + holder.groupName.getText() + "?");
                dialog.setCancelable(true);
                dialog.setPositiveButton("加入", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //加入群组的网络操作
                        Toast.makeText(PlayGroupListActivity.playGroupListActivity, "加入成功!", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
            }
        });
        holder.userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.playGroup");
                intent.addCategory("com.play.MY_CATEGROY");
                intent.putExtra("group",playEnd);
                PlayGroupListActivity.playGroupListActivity.startActivity(intent);
            }
        });
        holder.infoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.playGroup");
                intent.addCategory("com.play.MY_CATEGROY");
                intent.putExtra("group",playEnd);
                PlayGroupListActivity.playGroupListActivity.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        playEnd = playEndList.get(position);
        holder.userImage.setImageResource(playEnd.getGroupImage());
        holder.groupName.setText(playEnd.getGroupName());
        holder.groupInfo.setText(playEnd.getGroupInfo());
        holder.tagsImage1.setImageResource(playEnd.getGroupTagesImages1());
        holder.tagsImage2.setImageResource(playEnd.getGroupTagesImages2());
        holder.groupTitle.setText(playEnd.getGroupNewsTitle());
        holder.groupUserInfo1.setImageResource(playEnd.getInfoImages1());
        holder.groupUserInfo2.setImageResource(playEnd.getInfoImages2());
        holder.groupUserInfo3.setImageResource(playEnd.getInfoImages3());
        holder.groupUserImage1.setImageResource(playEnd.getJoinersImage1());
        holder.groupUserImage2.setImageResource(playEnd.getJoinersImage2());
        holder.groupUserImage3.setImageResource(playEnd.getJoinersImage3());
        holder.groupUserImage4.setImageResource(playEnd.getJoinersImage4());
    }

    @Override
    public int getItemCount() {
        return playEndList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView userImage;
        View infoView;
        TextView joinGroup;
        TextView groupName;
        TextView groupInfo;
        ImageView tagsImage1;
        ImageView tagsImage2;
        TextView groupTitle;
        ImageView groupUserInfo1;
        ImageView groupUserInfo2;
        ImageView groupUserInfo3;
        ImageView groupUserImage1;
        ImageView groupUserImage2;
        ImageView groupUserImage3;
        ImageView groupUserImage4;

        public ViewHolder(View itemView) {
            super(itemView);
            groupName = (TextView) itemView.findViewById(R.id.g_group_name);
            userImage = (CircleImageView) itemView.findViewById(R.id.g_group_image);
            infoView = itemView.findViewById(R.id.g_end_news);
            joinGroup = (TextView) itemView.findViewById(R.id.g_join_group);
            groupInfo = (TextView) itemView.findViewById(R.id.g_group_info);
            tagsImage1 = (ImageView) itemView.findViewById(R.id.g_play_tag1);
            tagsImage2 = (ImageView) itemView.findViewById(R.id.g_play_tag2);
            groupTitle = (TextView) itemView.findViewById(R.id.g_group_info_title);
            groupUserInfo1 = (ImageView) itemView.findViewById(R.id.g_group_info_image1);
            groupUserInfo2 = (ImageView) itemView.findViewById(R.id.g_group_info_image2);
            groupUserInfo3 = (ImageView) itemView.findViewById(R.id.g_group_info_image3);
            groupUserImage1 = (ImageView) itemView.findViewById(R.id.g_group_joiner1);
            groupUserImage2 = (ImageView) itemView.findViewById(R.id.g_group_joiner2);
            groupUserImage3 = (ImageView) itemView.findViewById(R.id.g_group_joiner3);
            groupUserImage4 = (ImageView) itemView.findViewById(R.id.g_group_joiner4);
        }
    }
}
