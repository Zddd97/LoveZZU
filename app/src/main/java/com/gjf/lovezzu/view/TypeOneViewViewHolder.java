package com.gjf.lovezzu.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.PlayTop;

import java.util.List;

/**
 * Created by zhaox on 2017/4/9.
 */

public class TypeOneViewViewHolder extends RecyclerView.ViewHolder {
    private static int TYPE = 1;
    TextView topHot;
    CircleImageView circleImageView;
    TextView userName;
    TextView userTime;
    //点赞数目
    TextView userNice;
    TextView userTalk;
    //新闻大标题
    TextView userTitle;
    //新闻小标题
    TextView newsTilte;
    ImageView newsImage;

    public TypeOneViewViewHolder(View itemView) {
        super(itemView);
        topHot = (TextView) itemView.findViewById(R.id.play_hot);
        circleImageView = (CircleImageView) itemView.findViewById(R.id.play_user_image);
        userName = (TextView) itemView.findViewById(R.id.play_user_name);
        userTime = (TextView) itemView.findViewById(R.id.play_user_time);
        userNice = (TextView) itemView.findViewById(R.id.play_nice);
        userTalk = (TextView) itemView.findViewById(R.id.play_talk);
        userTitle = (TextView) itemView.findViewById(R.id.play_user_title);
        newsTilte = (TextView) itemView.findViewById(R.id.play_news_title);
        newsImage = (ImageView) itemView.findViewById(R.id.play_news_image);
    }


}
