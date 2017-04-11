package com.gjf.lovezzu.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gjf.lovezzu.R;

/**
 * Created by zhaox on 2017/4/9.
 */

public class TypeTwoViewViewHolder extends RecyclerView.ViewHolder {
    private static int TYPE = 2;
    TextView playGroup;
    CircleImageView groupImage;
    TextView groupName;
    TextView groupInfo;
    TextView joinGroup;
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

    public TypeTwoViewViewHolder(View itemView) {
        super(itemView);
        playGroup = (TextView) itemView.findViewById(R.id.play_group);
        groupImage = (CircleImageView) itemView.findViewById(R.id.play_group_image);
        groupName = (TextView) itemView.findViewById(R.id.play_group_name);
        groupInfo = (TextView) itemView.findViewById(R.id.play_group_info);
        joinGroup = (TextView) itemView.findViewById(R.id.play_join_group);
        tagsImage1 = (ImageView) itemView.findViewById(R.id.play_play_tag1);
        tagsImage2 = (ImageView) itemView.findViewById(R.id.play_play_tag2);
        groupTitle = (TextView) itemView.findViewById(R.id.play_group_info_title);
        groupUserInfo1 = (ImageView) itemView.findViewById(R.id.play_group_info_image1);
        groupUserInfo2 = (ImageView) itemView.findViewById(R.id.play_group_info_image2);
        groupUserInfo3 = (ImageView) itemView.findViewById(R.id.play_group_info_image3);
        groupUserImage1 = (ImageView) itemView.findViewById(R.id.play_group_joiner1);
        groupUserImage2 = (ImageView) itemView.findViewById(R.id.play_group_joiner2);
        groupUserImage3 = (ImageView) itemView.findViewById(R.id.play_group_joiner3);
        groupUserImage4 = (ImageView) itemView.findViewById(R.id.play_group_joiner4);

    }
}
