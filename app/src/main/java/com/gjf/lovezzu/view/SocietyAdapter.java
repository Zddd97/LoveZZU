package com.gjf.lovezzu.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.SchoolSociety;

import java.util.List;

/**
 * Created by zhao on 2017/3/15.
 */

public class SocietyAdapter extends RecyclerView.Adapter<SocietyAdapter.ViewHolder> {

    private List<SchoolSociety> schoolSocietyList;
    private SchoolSociety schoolSociety;

    public SocietyAdapter(List<SchoolSociety> schoolSocieties) {
        this.schoolSocietyList = schoolSocieties;
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
        schoolSociety = schoolSocietyList.get(position);
        holder.newsImage.setImageResource(schoolSociety.getNewsImage());
        holder.newsTitle.setText(schoolSociety.getNewsTitle());
        holder.newsDate.setText(schoolSociety.getNewsDate());
        holder.newsRead.setText(schoolSociety.getNewsRead());
    }

    @Override
    public int getItemCount() {
        return schoolSocietyList.size();
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
