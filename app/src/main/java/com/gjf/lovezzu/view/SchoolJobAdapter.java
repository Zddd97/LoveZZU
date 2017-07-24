package com.gjf.lovezzu.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.activity.parttimejob.JobInfoActivity;
import com.gjf.lovezzu.activity.parttimejob.PartTimeJobActivity;
import com.gjf.lovezzu.entity.JobItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaox on 2017/5/24.
 */

public class SchoolJobAdapter extends RecyclerView.Adapter<SchoolJobAdapter.ViewHolder>{

    private List<JobItem> jobItemList=new ArrayList<>();
    private JobItem jobItem;
    public SchoolJobAdapter(List<JobItem> jobItemList){
        this.jobItemList=jobItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.part_time_job_item,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.jobContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PartTimeJobActivity.partTimeJobActivity, JobInfoActivity.class);
                intent.putExtra("JobItem",jobItem);
                PartTimeJobActivity.partTimeJobActivity.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        jobItem=jobItemList.get(position);
        holder.jobTitle.setText(jobItem.getJobTitle());
        holder.jobContent.setText(jobItem.getJobContent());
        holder.jobTime.setText(jobItem.getJobTime());
    }

    @Override
    public int getItemCount() {
        return jobItemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView jobTitle;
        TextView jobContent;
        TextView jobTime;
        public ViewHolder(View itemView) {
            super(itemView);
            jobTitle= (TextView) itemView.findViewById(R.id.job_title);
            jobContent= (TextView) itemView.findViewById(R.id.job_content);
            jobTime= (TextView) itemView.findViewById(R.id.job_date);
        }
    }

}
