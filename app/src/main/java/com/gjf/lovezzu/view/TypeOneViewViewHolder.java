package com.gjf.lovezzu.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.activity.palytogether.PlayTogetherActivity;
import com.gjf.lovezzu.entity.PlayTop;

import java.util.List;

/**
 * Created by zhaox on 2017/4/9.
 */

public class TypeOneViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static int TYPE = 1;
    LinearLayout playTopTtile;
    LinearLayout playTopnews;
    TextView topHot;
    CircleImageView circleImageView;
    ImageView share;
    TextView userName;
    TextView userTime;
    //点赞数目
    ImageView userNiceImage;
    TextView userNice;

    //讨论数目
    ImageView userTalkImage;
    TextView userTalk;
    //新闻大标题
    TextView userTitle;
    //新闻小标题
    TextView newsTilte;
    ImageView newsImage;

    public TypeOneViewViewHolder(View itemView) {
        super(itemView);
        playTopnews = (LinearLayout) itemView.findViewById(R.id.play_top_news);
        share = (ImageView) itemView.findViewById(R.id.play_user_share);
        playTopTtile = (LinearLayout) itemView.findViewById(R.id.play_top_title);
        topHot = (TextView) itemView.findViewById(R.id.play_hot);
        circleImageView = (CircleImageView) itemView.findViewById(R.id.play_user_image);
        userName = (TextView) itemView.findViewById(R.id.play_user_name);
        userTime = (TextView) itemView.findViewById(R.id.play_user_time);
        userNiceImage = (ImageView) itemView.findViewById(R.id.play_nice_image);
        userNice = (TextView) itemView.findViewById(R.id.play_nice);
        userTalkImage = (ImageView) itemView.findViewById(R.id.play_talk_image);
        userTalk = (TextView) itemView.findViewById(R.id.play_talk);
        userTitle = (TextView) itemView.findViewById(R.id.play_user_title);
        newsTilte = (TextView) itemView.findViewById(R.id.play_news_title);
        newsImage = (ImageView) itemView.findViewById(R.id.play_news_image);
        playTopTtile.setOnClickListener(this);
        circleImageView.setOnClickListener(this);
        userNice.setOnClickListener(this);
        userNiceImage.setOnClickListener(this);
        share.setOnClickListener(this);
        userTalk.setOnClickListener(this);
        userTalkImage.setOnClickListener(this);
        playTopnews.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_top_title:
                Toast.makeText(v.getContext(), "热门活动", Toast.LENGTH_SHORT).show();
                break;
            case R.id.play_user_image:
                Toast.makeText(v.getContext(), "用户头像", Toast.LENGTH_SHORT).show();
                break;
            case R.id.play_user_share:
                Toast.makeText(v.getContext(), "分享活动", Toast.LENGTH_SHORT).show();
                break;
            case R.id.play_nice:
            case R.id.play_nice_image:
                Toast.makeText(v.getContext(), "点赞", Toast.LENGTH_SHORT).show();
                break;
            case R.id.play_talk:
            case R.id.play_talk_image:
                Toast.makeText(v.getContext(), "讨论", Toast.LENGTH_SHORT).show();
                break;
            case R.id.play_top_news:
                Toast.makeText(v.getContext(), "活动详情", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
