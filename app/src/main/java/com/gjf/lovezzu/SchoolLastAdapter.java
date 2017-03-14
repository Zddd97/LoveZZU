package com.gjf.lovezzu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by zhao on 2017/3/12.
 */

public class SchoolLastAdapter extends RecyclerView.Adapter<SchoolLastAdapter.ViewHolder> {

    private List<SchoolLast> schoolLastList;

    public SchoolLastAdapter(List<SchoolLast> schoolLastList) {
        this.schoolLastList = schoolLastList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.last_school_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.schoolLastView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "点击事件", Toast.LENGTH_SHORT).show();
                //点击事件
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SchoolLast schoolLast = schoolLastList.get(position);
        holder.imageView.setImageResource(schoolLast.getImageId());
        holder.titleText.setText(schoolLast.getTitletText());
    }

    @Override
    public int getItemCount() {
        return schoolLastList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View schoolLastView;
        ImageView imageView;
        TextView titleText;

        public ViewHolder(View itemView) {
            super(itemView);
            schoolLastView = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.in_school_last_image);
            titleText = (TextView) itemView.findViewById(R.id.in_school_last_text);
        }
    }

}
