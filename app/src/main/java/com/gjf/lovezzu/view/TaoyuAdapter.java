package com.gjf.lovezzu.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.TaoyuResult;

import java.util.List;

/**
 * Created by lenovo047 on 2017/3/24.
 */

public class TaoyuAdapter extends RecyclerView.Adapter<TaoyuAdapter.ViewHolder>{
    private List<TaoyuResult> taoyuResultList;

    public TaoyuAdapter(List<TaoyuResult> taoyuResultList) {
        this.taoyuResultList = taoyuResultList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.taoyu,parent,false);
        final  ViewHolder holder =new ViewHolder(view);
        holder.taoyuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"点击事件",Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TaoyuResult TaoyuResult = taoyuResultList.get(position);
        holder.touxiang.setImageResource(TaoyuResult.getImageID1());
        holder.taoyuimag.setImageResource(TaoyuResult.getImageID2());
        holder.title.setText(TaoyuResult.getTitle());
        holder.comment.setText(TaoyuResult.getComment());
        holder.position.setText(TaoyuResult.getPosition());
        holder.price.setText(TaoyuResult.getPrice());
        holder.phone.setText(TaoyuResult.getPhone());
        holder.time.setText(TaoyuResult.getTime());
        holder.zan.setText(TaoyuResult.getZan());


    }

    @Override
    public int getItemCount() {
        return taoyuResultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View taoyuView;
        ImageView touxiang;
        ImageView  taoyuimag;
        TextView phone;
        TextView time;
        TextView price;
        TextView position;
        TextView zan;
        TextView comment;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            taoyuView = itemView;
            taoyuimag = (ImageView) itemView.findViewById(R.id.taoyuimag);
            touxiang = (ImageView) itemView.findViewById(R.id.taoyuimag);
            phone =(TextView) itemView.findViewById(R.id.phone);
            time  =(TextView) itemView.findViewById(R.id.time);
            price = (TextView) itemView.findViewById(R.id.price);
            position = (TextView) itemView.findViewById(R.id.position);
            zan = (TextView)  itemView.findViewById(R.id.zan);
            comment = (TextView) itemView.findViewById(R.id.comment);
            title =(TextView)  itemView.findViewById(R.id.title);



        }
    }

}
