package com.gjf.lovezzu.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.SocietyNewsResult;
import com.gjf.lovezzu.network.HttpClientUtils;

import java.util.List;

/**
 * Created by zhao on 2017/3/15.
 */

public class SocietyAdapter extends RecyclerView.Adapter<SocietyAdapter.ViewHolder> {

    private List<SocietyNewsResult> societyNewsResultList;
    HttpClientUtils httpClientUtils;

    private SocietyNewsResult societyNewsResult;

    private Context mContext;
    private Activity activity;
    private LayoutInflater inflater;


    public SocietyAdapter(List<SocietyNewsResult> societyNewsResults, Context mContext) {
        this.societyNewsResultList = societyNewsResults;

        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.society_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.societyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击事件


                Toast.makeText(view.getContext(), "点击事件", Toast.LENGTH_SHORT).show();

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        societyNewsResult = societyNewsResultList.get(position);

        // holder.newsImage.setImageResource(schoolSociety.getNewsImage());
        Glide.with(mContext)
                .load(societyNewsResult.getUrl())
                .centerCrop().dontAnimate()
                .placeholder(R.drawable.__picker_ic_photo_black_48dp)
                .error(R.drawable.__picker_ic_broken_image_black_48dp)
                .into(holder.newsImage);
        holder.newsTitle.setText(societyNewsResult.getCreatedAt());
        holder.newsDate.setText(societyNewsResult.get_id());
        holder.newsRead.setText(societyNewsResult.getSource());
         //httpClientUtils = new HttpClientUtils(societyNewsResult.getUrl(),"gjf",societyNewsResult.get_id()+".jpg");
        //httpClientUtils.downloadFile();
    }

    @Override
    public int getItemCount() {
        return societyNewsResultList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        View societyView;
        ImageView newsImage;
        TextView newsTitle;
        TextView newsDate;
        TextView newsRead;

        public ViewHolder(View itemView) {
            super(itemView);
            societyView = itemView;
            newsImage = (ImageView) itemView.findViewById(R.id.in_society_image);
            newsTitle = (TextView) itemView.findViewById(R.id.in_society_title);
            newsDate = (TextView) itemView.findViewById(R.id.in_society_date);
            newsRead = (TextView) itemView.findViewById(R.id.in_society_read);


        }
    }



}
