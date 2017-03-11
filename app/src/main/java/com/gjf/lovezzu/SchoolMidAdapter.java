package com.gjf.lovezzu;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by zhaox on 2017/3/11.
 */

public class SchoolMidAdapter extends RecyclerView.Adapter<SchoolMidAdapter.ViewHolder> {

    private List<SchoolMid> midList;


    public SchoolMidAdapter(List<SchoolMid> schoolMidList) {
        midList = schoolMidList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mid_school_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.schoolImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"点击事件",Toast.LENGTH_SHORT).show();
                //获取intent，开启新的活动
            }
        });
        return holder;
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SchoolMid schoolMid = midList.get(position);
        holder.schoolImage.setImageResource(schoolMid.getImageId());
    }

    @Override
    public int getItemCount() {
        return midList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView schoolImage;

        public ViewHolder(View itemView) {
            super(itemView);
            schoolImage = (ImageView) itemView.findViewById(R.id.mid_school_image);

        }
    }


}
